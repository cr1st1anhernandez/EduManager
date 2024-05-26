package EduManager.Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import EduManager.DataBase.DatabaseAccess;
import EduManager.Entities.Student;

public class StudentController {

    public Student getStudentById(int studentId) {
        Student student = null;
        try {
            DatabaseAccess.connect();
            String query = "SELECT * FROM Student WHERE studentId = ?";
            PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student = new Student();
                student.setUserId(resultSet.getInt("studentId"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setCareer(resultSet.getString("career"));
                student.setSemester(resultSet.getInt("semester"));
                student.setEmail(resultSet.getString("email"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseAccess.closeConnection();
        }
        return student;
    }
}

