package EduManager.Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import EduManager.Components.ErrorComponent;
import EduManager.Components.SuccessComponent;
import EduManager.DataBase.DatabaseAccess;
import EduManager.Entities.Enrollment;
import EduManager.Entities.GroupSubject;
import java.time.LocalTime;
import raven.toast.Notifications;

public class EnrollmentController {

	ErrorComponent errorComponent = new ErrorComponent();
	SuccessComponent successComponent = new SuccessComponent();
	GroupSubjectController groupSubjectController = new GroupSubjectController();

	public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
		List<Enrollment> allEnrollments = getEnrollments();
		return allEnrollments.stream()
			.filter(enrollment -> enrollment.getStudentId() == studentId)
			.collect(Collectors.toList());
	}

	public List<Enrollment> getEnrollmentsByGroupSubjectId(int groupSubjectId) {
		List<Enrollment> allEnrollments = getEnrollments();
		return allEnrollments.stream()
			.filter(enrollment -> enrollment.getGroupSubjectId() == groupSubjectId)
			.collect(Collectors.toList());
	}

	public boolean addEnrollment(Enrollment enrollment) {
		try {
			DatabaseAccess.connect();
			int currentVacancies = groupSubjectController.getVacancies(enrollment.getGroupSubjectId());
			if (currentVacancies <= 0) {
				errorComponent.setText("El grupo está lleno y no tiene cupo disponible");
				Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
				return false;
			}

			if (getEnrollmentsByStudentId(enrollment.getStudentId()).size() >= 6) {
				errorComponent.setText("Un estudiante solo puede estar matriculado en un máximo de 6 materias");
				Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
				return false;
			}

			if (getEnrollmentsByGroupSubjectId(enrollment.getGroupSubjectId()).stream()
				.anyMatch(e -> e.getStudentId() == enrollment.getStudentId())) {
				errorComponent.setText("El estudiante ya está matriculado en esta materia");
				Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
				return false;
			}

			List<Enrollment> studentEnrollments = getEnrollmentsByStudentId(enrollment.getStudentId());
			GroupSubject newGroupSubject = groupSubjectController.getGroupSubjectById(enrollment.getGroupSubjectId());
			if (studentEnrollments.stream()
				.map(e -> groupSubjectController.getGroupSubjectById(e.getGroupSubjectId()))
				.anyMatch(gs -> gs.getSubjectId() == newGroupSubject.getSubjectId())) {
				errorComponent.setText("El estudiante ya está matriculado en esta materia con otro profesor");
				Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
				return false;
			}

			if (studentEnrollments.stream()
				.map(e -> groupSubjectController.getGroupSubjectById(e.getGroupSubjectId()))
				.anyMatch(gs
					-> gs.getDaysOfWeek().equals(newGroupSubject.getDaysOfWeek())
				&& LocalTime.parse(gs.getStartTime().toString()).equals(LocalTime.parse(newGroupSubject.getStartTime().toString()))
				&& LocalTime.parse(gs.getEndTime().toString()).equals(LocalTime.parse(newGroupSubject.getEndTime().toString())))) {
				errorComponent.setText("El estudiante ya tiene una materia en el mismo horario");
				Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
				return false;
			}

			String query = "INSERT INTO Enrollment (studentId, groupSubjectId) VALUES (?, ?)";
			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, enrollment.getStudentId());
			preparedStatement.setInt(2, enrollment.getGroupSubjectId());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				groupSubjectController.updateVacancies(enrollment.getGroupSubjectId(), -1);
				successComponent.setText("Estudiante matriculado con éxito");
				Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, successComponent);
				return true;
			}
			return false;
		} catch (SQLException e) {
			errorComponent.setText("Error en la base de datos");
			Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
			e.printStackTrace();
			return false;
		}
	}

	public List<Enrollment> getEnrollments() {
		List<Enrollment> enrollments = new ArrayList<>();
		try {
			DatabaseAccess.connect();
			String query = "SELECT * FROM Enrollment";
			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Enrollment enrollment = new Enrollment();
				enrollment.setEnrollmentId(resultSet.getInt("enrollmentId"));
				enrollment.setStudentId(resultSet.getInt("studentId"));
				enrollment.setGroupSubjectId(resultSet.getInt("groupSubjectId"));
				enrollments.add(enrollment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrollments;
	}

	public boolean deleteEnrollment(Enrollment enrollment) {
		try {
			DatabaseAccess.connect();
			String query = "DELETE FROM Enrollment WHERE studentId = ? AND groupSubjectId = ?";
			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, enrollment.getStudentId());
			preparedStatement.setInt(2, enrollment.getGroupSubjectId());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				groupSubjectController.updateVacancies(enrollment.getGroupSubjectId(), 1);
				successComponent.setText("Estudiante eliminado del grupo con éxito");
				Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, successComponent);
				return true;
			}
			return false;
		} catch (SQLException e) {
			errorComponent.setText("Error en la base de datos");
			Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
			e.printStackTrace();
			return false;
		}
	}
}
