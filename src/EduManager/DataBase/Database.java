package EduManager.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EduManager.Entities.Admin;
import EduManager.Entities.Coordinator;
import EduManager.Entities.Enrollment;
import EduManager.Entities.GroupSubject;
import EduManager.Entities.Student;
import EduManager.Entities.Teacher;
import EduManager.Entities.User;
import EduManager.Utils.Utilities;

public class Database {

	public Database() {
		DatabaseAccess.connect();
	}

	public static List<GroupSubject> getGroupsSubjects() {
		List<GroupSubject> groupSubjects = new ArrayList<>();
		try {
			DatabaseAccess.connect();
			String query = "SELECT gs.groupId, gs.subjectId, s.name AS subjectName, gs.startTime, gs.endTime, gs.teacherId, "
				+ "CONCAT(t.firstName, ' ', t.lastName) AS teacherName, gs.daysOfWeek "
				+ "FROM GroupSubject gs "
				+ "JOIN Subject s ON gs.subjectId = s.subjectId "
				+ "JOIN Teacher t ON gs.teacherId = t.teacherId";
			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				GroupSubject groupSubject = new GroupSubject();
				groupSubject.setGroupId(resultSet.getString("groupId"));
				groupSubject.setSubjectId(resultSet.getInt("subjectId"));
				groupSubject.setSubjectName(resultSet.getString("subjectName"));
				groupSubject.setStartTime(resultSet.getTime("startTime"));
				groupSubject.setEndTime(resultSet.getTime("endTime"));
				groupSubject.setTeacherId(resultSet.getInt("teacherId"));
				groupSubject.setDaysOfWeek(resultSet.getString("daysOfWeek"));
				groupSubject.setTeacherName(resultSet.getString("teacherName"));
				groupSubjects.add(groupSubject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseAccess.closeConnection();
		}
		return groupSubjects;
	}

  public static List<Enrollment> getEnrollments() {
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
        } finally {
            DatabaseAccess.closeConnection();
        }
        return enrollments;
    }

	public static User login(String username, String password) {
		try {
			DatabaseAccess.connect();
			String query = "SELECT * FROM STUDENT WHERE studentId = ? AND password = ?";
			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, Utilities.hashPassword(password));
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Student student = new Student();
				student.setUserId(resultSet.getInt("studentId"));
				student.setFirstName(resultSet.getString("firstName"));
				student.setLastName(resultSet.getString("lastName"));
				student.setCurp(resultSet.getString("curp"));
				student.setPhoneNumber(resultSet.getString("phoneNumber"));
				student.setEmail(resultSet.getString("email"));
				student.setCareer(resultSet.getString("career"));
				student.setSemester(resultSet.getInt("semester"));
				student.setBirthDate(resultSet.getDate("birthDate"));
				String genderStr = resultSet.getString("gender");
				if (genderStr != null && !genderStr.isEmpty()) {
					student.setGender(genderStr.charAt(0));
				}
				return student;
			}

			query = "SELECT * FROM TEACHER WHERE teacherId = ? AND password = ?";
			preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, Utilities.hashPassword(password));
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setUserId(resultSet.getInt("teacherId"));
				teacher.setLastName(resultSet.getString("lastName"));
				teacher.setFirstName(resultSet.getString("firstName"));
				teacher.setCurp(resultSet.getString("curp"));
				teacher.setEmail(resultSet.getString("email"));
				teacher.setPhoneNumber(resultSet.getString("phoneNumber"));
				teacher.setBirthDate(resultSet.getDate("birthDate"));
				String genderStr = resultSet.getString("gender");
				if (genderStr != null && !genderStr.isEmpty()) {
					teacher.setGender(genderStr.charAt(0));
				}
				teacher.setCareer(resultSet.getString("career"));
				return teacher;
			}

			query = "SELECT * FROM COORDINATOR WHERE coordinatorId = ? AND password = ?";
			preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, Utilities.hashPassword(password));
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Coordinator coordinator = new Coordinator();
				coordinator.setUserId(resultSet.getInt("coordinatorId"));
				coordinator.setFirstName(resultSet.getString("firstName"));
				coordinator.setLastName(resultSet.getString("lastName"));
				coordinator.setCurp(resultSet.getString("curp"));
				coordinator.setEmail(resultSet.getString("email"));
				coordinator.setCurp(resultSet.getString("curp"));
				coordinator.setEmail(resultSet.getString("email"));
				coordinator.setPhoneNumber(resultSet.getString("phoneNumber"));
				coordinator.setBirthDate(resultSet.getDate("birthDate"));
				String genderStr = resultSet.getString("gender");
				if (genderStr != null && !genderStr.isEmpty()) {
					coordinator.setGender(genderStr.charAt(0));
				}
				coordinator.setArea(resultSet.getString("area"));
				return coordinator;
			}

			query = "SELECT * FROM ADMIN WHERE adminId = ? AND password = ?";
			preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, Utilities.hashPassword(password));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Admin admin = new Admin();
				admin.setUserId(resultSet.getInt("adminId"));
				admin.setPhoneNumber(resultSet.getString("phoneNumber"));
				admin.setEmail(resultSet.getString("email"));
				admin.setFirstName(resultSet.getString("firstName"));
				admin.setLastName(resultSet.getString("lastName"));
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseAccess.closeConnection();
		}
		return null;
	}

}
