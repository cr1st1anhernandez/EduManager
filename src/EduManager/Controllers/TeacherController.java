package EduManager.Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EduManager.DataBase.DatabaseAccess;
import EduManager.Entities.Teacher;

public class TeacherController {
  public List<Teacher> getAllTeachers() {
    List<Teacher> teachers = new ArrayList<>();
    try {
      DatabaseAccess.connect();
      String query = "SELECT * FROM Teacher";
      PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Teacher teacher = new Teacher();
        teacher.setUserId(resultSet.getInt("teacherId"));
        teacher.setFirstName(resultSet.getString("firstName"));
        teacher.setLastName(resultSet.getString("lastName"));
        teachers.add(teacher);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return teachers;
  }
  public boolean createTeacher(Teacher teacher) {
        try {
            DatabaseAccess.connect();
            String query = "INSERT INTO Teacher (teacherId, password, firstName, lastName, email, phoneNumber, curp, gender, career, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, teacher.getUserId());
            preparedStatement.setString(2, teacher.getPassword());
            preparedStatement.setString(3, teacher.getFirstName());
            preparedStatement.setString(4, teacher.getLastName());
            preparedStatement.setString(5, teacher.getEmail());
            preparedStatement.setString(6, teacher.getPhoneNumber());
            preparedStatement.setString(7, teacher.getCurp());
            preparedStatement.setString(8, String.valueOf(teacher.getGender()));
            preparedStatement.setString(9, teacher.getCareer());
            preparedStatement.setString(10, teacher.getImagePath());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
