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
}
