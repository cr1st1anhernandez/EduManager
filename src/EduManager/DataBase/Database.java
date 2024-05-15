package EduManager.DataBase;

import EduManager.Entities.Coordinator;
import EduManager.Entities.Student;
import EduManager.Entities.Teacher;
import EduManager.Entities.User;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import EduManager.Utils.Utilities;

public class Database {

  DatabaseAccess databaseAccess = new DatabaseAccess();

  public Database() {
    DatabaseAccess.connect();
  }

  public static void main(String[] args) {
    createUser("STUDENT", 22169096, "Juan Alberto Rodriguez", "22161090", "juan@example.com", "Ingeniería en Sistemas", "Contraseña9$");
    createUser("COORDINATOR", 123456, "Pedro Rodriguez Altamirano", "123456", "correo@ejemplo.com", "Ingeniería en Sistemas",
        "Contraseña9$");
    createUser("TEACHER", 789012, "Jesus Enrique Jimenez", "789012", "correo@ejemplo.com", "Ingeniería Quimica", "Contraseña9$");
  }

  public static void createUser(String userType, Integer userId, String name, String curp, String email, String career,
      String password) {
    try {
      DatabaseAccess.connect();
      String hashedPassword = Utilities.hashPassword(password);
      String tableName = userType.toUpperCase();
      String query = "INSERT INTO " + tableName + " (" + tableName.toLowerCase()
          + "_id, name, curp, email, " +
          (userType.equals("COORDINATOR") ? "area" : "career") + ", password) VALUES (?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
      preparedStatement.setInt(1, userId);
      preparedStatement.setString(2, name);
      preparedStatement.setString(3, curp);
      preparedStatement.setString(4, email);
      preparedStatement.setString(5, career);
      preparedStatement.setString(6, hashedPassword);
      preparedStatement.executeUpdate();
      System.out.println(userType + " created successfully!");
      DatabaseAccess.closeConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static User login(String username, String password) {
    try {
      DatabaseAccess.connect();
      String query = "SELECT * FROM STUDENT WHERE student_id = ? AND password = ?";
      PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, Utilities.hashPassword(password));
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        Student student = new Student();
        student.setStudentId(resultSet.getInt("student_id"));
        student.setName(resultSet.getString("name"));
        student.setCurp(resultSet.getString("curp"));
        student.setEmail(resultSet.getString("email"));
        student.setCareer(resultSet.getString("career"));
        DatabaseAccess.closeConnection();
        return student;
      }

      query = "SELECT * FROM TEACHER WHERE teacher_id = ? AND password = ?";
      preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, Utilities.hashPassword(password));
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(resultSet.getInt("teacher_id"));
        teacher.setName(resultSet.getString("name"));
        teacher.setCurp(resultSet.getString("curp"));
        teacher.setEmail(resultSet.getString("email"));
        teacher.setCareer(resultSet.getString("career"));
        DatabaseAccess.closeConnection();
        return teacher;
      }

      query = "SELECT * FROM COORDINATOR WHERE coordinator_id = ? AND password = ?";
      preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, Utilities.hashPassword(password));
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        Coordinator coordinator = new Coordinator();
        coordinator.setCoordinatorId(resultSet.getInt("coordinator_id"));
        coordinator.setName(resultSet.getString("name"));
        coordinator.setCurp(resultSet.getString("curp"));
        coordinator.setEmail(resultSet.getString("email"));
        coordinator.setArea(resultSet.getString("area"));
        DatabaseAccess.closeConnection();
        return coordinator;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    DatabaseAccess.closeConnection();
    return null;
  }

}
