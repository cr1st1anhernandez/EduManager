package EduManager.DataBase;

import EduManager.Entities.Admin;
import EduManager.Entities.Coordinator;
import EduManager.Entities.Student;
import EduManager.Entities.Teacher;
import EduManager.Entities.User;
import EduManager.Utils.Utilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	public Database() {
		DatabaseAccess.connect();
	}

	public static void main(String[] args) {
		Database db = new Database();
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
