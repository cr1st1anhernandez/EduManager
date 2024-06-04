package EduManager.Controllers;

import EduManager.Application.Application;
import static EduManager.Utils.Utilities.hashPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import EduManager.DataBase.DatabaseAccess;
import EduManager.Entities.Admin;
import EduManager.Entities.Coordinator;
import EduManager.Entities.Student;
import EduManager.Entities.Teacher;
import EduManager.Entities.User;
import EduManager.Forms.LoginForm;
import java.awt.Window;
import lombok.Data;

@Data
public class UserController {

	static Student student;
	static User user;
	static Teacher teacher;
	static Coordinator coordinator;
	static Admin admin;

	public static User getUser() {
		return user;
	}

	public static Admin getAdmin() {
		return admin;
	}

	public static Student getStudent() {
		return student;
	}

	public static Teacher getTeacher() {
		return teacher;
	}

	public static Coordinator getCoordinator() {
		return coordinator;
	}

	public static boolean updateImagePath(String newPath) {
		if (user == null) {
			return false;
		}
		String userType = "";
		if (user instanceof Student) {
			userType = "Student";
		} else if (user instanceof Teacher) {
			userType = "Teacher";
		} else if (user instanceof Coordinator) {
			userType = "Coordinator";
		} else if (user instanceof Admin) {
			userType = "Admin";
		}
		try {
			DatabaseAccess.connect();
			String query = "";
			switch (userType) {
				case "Student":
					query = "UPDATE Student SET imagePath = ? WHERE studentId = ?";
					break;
				case "Teacher":
					query = "UPDATE Teacher SET imagePath = ? WHERE teacherId = ?";
					break;
				case "Coordinator":
					query = "UPDATE Coordinator SET imagePath = ? WHERE coordinatorId = ?";
					break;
				case "Admin":
					query = "UPDATE Admin SET imagePath = ? WHERE adminId = ?";
					break;
				default:
					return false;
			}

			// Guardar solo la ruta relativa, sin la carpeta "src"
			String baseDir = System.getProperty("user.dir").replace("\\", "/");
			String newPathNormalized = newPath.replace("\\", "/");
			String relativePath = newPathNormalized.replaceFirst("^.*?/EduManager", "/EduManager").replace("/src/EduManager",
					"");

			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, relativePath);
			preparedStatement.setInt(2, user.getUserId());
			int rowsAffected = preparedStatement.executeUpdate();

			// Actualizar el objeto de usuario en memoria
			if (rowsAffected > 0) {
				user.setImagePath(relativePath);
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean login(String username, String password) {
		try {
			DatabaseAccess.connect();
			String query = "SELECT * FROM STUDENT WHERE studentId = ? AND password = ?";
			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, hashPassword(password));
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				student = new Student();
				student.setUserId(resultSet.getInt("studentId"));
				student.setFirstName(resultSet.getString("firstName"));
				student.setLastName(resultSet.getString("lastName"));
				student.setCurp(resultSet.getString("curp"));
				student.setPhoneNumber(resultSet.getString("phoneNumber"));
				student.setEmail(resultSet.getString("email"));
				student.setImagePath(resultSet.getString("imagePath"));
				student.setCareer(resultSet.getString("career"));
				student.setSemester(resultSet.getInt("semester"));
				String genderStr = resultSet.getString("gender");
				if (genderStr != null && !genderStr.isEmpty()) {
					student.setGender(genderStr.charAt(0));
				}
				user = student;
				return true;
			}

			query = "SELECT * FROM TEACHER WHERE teacherId = ? AND password = ?";
			preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, hashPassword(password));
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				teacher = new Teacher();
				teacher.setUserId(resultSet.getInt("teacherId"));
				teacher.setLastName(resultSet.getString("lastName"));
				teacher.setFirstName(resultSet.getString("firstName"));
				teacher.setCurp(resultSet.getString("curp"));
				teacher.setEmail(resultSet.getString("email"));
				teacher.setPhoneNumber(resultSet.getString("phoneNumber"));
				teacher.setImagePath(resultSet.getString("imagePath"));
				String genderStr = resultSet.getString("gender");
				if (genderStr != null && !genderStr.isEmpty()) {
					teacher.setGender(genderStr.charAt(0));
				}
				teacher.setCareer(resultSet.getString("career"));
				user = teacher;
				return true;
			}

			query = "SELECT * FROM COORDINATOR WHERE coordinatorId = ? AND password = ?";
			preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, hashPassword(password));
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				coordinator = new Coordinator();
				coordinator.setUserId(resultSet.getInt("coordinatorId"));
				coordinator.setFirstName(resultSet.getString("firstName"));
				coordinator.setLastName(resultSet.getString("lastName"));
				coordinator.setCurp(resultSet.getString("curp"));
				coordinator.setEmail(resultSet.getString("email"));
				coordinator.setPhoneNumber(resultSet.getString("phoneNumber"));
				coordinator.setImagePath(resultSet.getString("imagePath"));
				String genderStr = resultSet.getString("gender");
				if (genderStr != null && !genderStr.isEmpty()) {
					coordinator.setGender(genderStr.charAt(0));
				}
				coordinator.setArea(resultSet.getString("area"));
				user = coordinator;
				return true;
			}

			query = "SELECT * FROM ADMIN WHERE adminId = ? AND password = ?";
			preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, hashPassword(password));
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				admin = new Admin();
				admin.setUserId(resultSet.getInt("adminId"));
				admin.setPhoneNumber(resultSet.getString("phoneNumber"));
				admin.setEmail(resultSet.getString("email"));
				admin.setImagePath(resultSet.getString("imagePath"));
				admin.setFirstName(resultSet.getString("firstName"));
				admin.setLastName(resultSet.getString("lastName"));
				user = admin;
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void logOut() {
		user = null;
		student = null;
		teacher = null;
		coordinator = null;
		admin = null;
		Window[] windows = Window.getWindows();

		for (Window window : windows) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}
		JFrame loginForm = new LoginForm();
		loginForm.setVisible(true);
		Application app = new Application();
	}

	public static boolean changePassword(String newPassword) {
		if (user == null) {
			return false;
		}
		String userType = "";
		if (user instanceof Student) {
			userType = "Student";
		} else if (user instanceof Teacher) {
			userType = "Teacher";
		} else if (user instanceof Coordinator) {
			userType = "Coordinator";
		} else if (user instanceof Admin) {
			userType = "Admin";
		}
		try {
			DatabaseAccess.connect();
			String query = "";
			switch (userType) {
				case "Student":
					query = "UPDATE Student SET password = ? WHERE studentId = ?";
					break;
				case "Teacher":
					query = "UPDATE Teacher SET password = ? WHERE teacherId = ?";
					break;
				case "Coordinator":
					query = "UPDATE Coordinator SET password = ? WHERE coordinatorId = ?";
					break;
				case "Admin":
					query = "UPDATE Admin SET password = ? WHERE adminId = ?";
					break;
				default:
					return false;
			}

			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setString(1, hashPassword(newPassword));
			preparedStatement.setInt(2, user.getUserId());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean deleteRecordById(int id) {
		Connection connection = null;
		try {
			connection = DatabaseAccess.getConnection();
			connection.setAutoCommit(false);

			String[] tables = { "teacher", "coordinator", "student" };
			String[] idColumns = { "teacherId", "coordinatorId", "studentId" };

			for (int i = 0; i < tables.length; i++) {
				if (recordExists(connection, tables[i], idColumns[i], id)) {
					deleteRecord(connection, tables[i], idColumns[i], id);
					connection.commit();
					System.out.println("Registro eliminado correctamente de la tabla " + tables[i]);
					return true;
				}
			}

			System.out.println("No se encontró ningún registro con el id proporcionado en las tablas especificadas.");
			return false;
		} catch (SQLException ex) {
			System.out.println("Error de base de datos");
			ex.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
			return false;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException closeEx) {
					closeEx.printStackTrace();
				}
			}
		}
	}

	private static boolean recordExists(Connection connection, String tableName, String idColumn, int id)
			throws SQLException {
		String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE " + idColumn + " = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getInt(1) > 0;
				}
			}
		}
		return false;
	}

	private static void deleteRecord(Connection connection, String tableName, String idColumn, int id)
			throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE " + idColumn + " = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		}
	}
}
