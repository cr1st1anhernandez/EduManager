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
import raven.toast.Notifications;

public class EnrollmentController {

	ErrorComponent errorComponent = new ErrorComponent();
	SuccessComponent successComponent = new SuccessComponent();

	public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
		List<Enrollment> allEnrollments = getEnrollments();

		List<Enrollment> filteredEnrollments = allEnrollments.stream()
			.filter(enrollment -> enrollment.getStudentId() == studentId)
			.collect(Collectors.toList());

		return filteredEnrollments;
	}

	public List<Enrollment> getEnrollmentsByGroupSubjectId(int groupSubjectId) {
		List<Enrollment> allEnrollments = getEnrollments();

		List<Enrollment> filteredEnrollments = allEnrollments.stream()
			.filter(enrollment -> enrollment.getGroupSubjectId() == groupSubjectId)
			.collect(Collectors.toList());

		return filteredEnrollments;
	}

	public boolean addEnrollment(Enrollment enrollment) {
		try {
			DatabaseAccess.connect();
			if (getEnrollments().stream().filter(e -> e.getStudentId() == enrollment.getStudentId()).count() >= 6) {
				errorComponent.setText("Un estudiante solo puede estar matriculado en un máximo de 6 materias");
				Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
				return false;
			}

			if (getEnrollments().stream().anyMatch(e -> e.getStudentId() == enrollment.getStudentId()
				&& e.getGroupSubjectId() == enrollment.getGroupSubjectId())) {
				errorComponent.setText("El estudiante ya está matriculado en esta materia");
				Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
				return false;
			}

			String query = "INSERT INTO Enrollment (studentId, groupSubjectId) VALUES (?, ?)";
			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, enrollment.getStudentId());
			preparedStatement.setInt(2, enrollment.getGroupSubjectId());

			int rowsAffected = preparedStatement.executeUpdate();
			successComponent.setText("Estudiante matriculado con exito");
			Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, successComponent);
			return rowsAffected > 0;
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
			successComponent.setText("Estudiante eliminado del grupo con exito");
			Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, successComponent);
			return rowsAffected > 0;
		} catch (SQLException e) {
			errorComponent.setText("Error en la base de datos");
			Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
			e.printStackTrace();
			return false;
		}
	}

}
