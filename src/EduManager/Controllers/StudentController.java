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
                student.setImagePath(resultSet.getString("imagePath"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public boolean deleteStudentById(int studentId) {
        try {
            DatabaseAccess.connect();
            deleteEnrollmentsByStudentId(studentId);
            String query = "DELETE FROM Student WHERE studentId = ?";
            PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void deleteEnrollmentsByStudentId(int studentId) throws SQLException {
        String query = "DELETE FROM Enrollment WHERE studentId = ?";
        PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, studentId);
        preparedStatement.executeUpdate();
    }
    
    public boolean createStudent(Student student) {
    try {
        DatabaseAccess.connect();
        String query = "INSERT INTO Student (studentId, password, firstName, lastName, email, phoneNumber, curp, gender, career, semester, imagePath) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, student.getUserId());
        preparedStatement.setString(2, student.getPassword());
        preparedStatement.setString(3, student.getFirstName());
        preparedStatement.setString(4, student.getLastName());
        preparedStatement.setString(5, student.getEmail());
        preparedStatement.setString(6, student.getPhoneNumber());
        preparedStatement.setString(7, student.getCurp());
        preparedStatement.setString(8, String.valueOf(student.getGender()));
        preparedStatement.setString(9, student.getCareer());
        preparedStatement.setInt(10, student.getSemester());
        preparedStatement.setString(11, student.getImagePath());

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
