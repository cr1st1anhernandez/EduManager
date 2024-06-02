package EduManager.Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EduManager.DataBase.DatabaseAccess;
import EduManager.Entities.Subject;

public class SubjectController {

    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        try {
            DatabaseAccess.connect();
            String query = "SELECT * FROM Subject";
            PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setSubjectId(resultSet.getInt("subjectId"));
                subject.setName(resultSet.getString("name"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }
    
    public boolean createSubject(Subject subject) {
        try {
            DatabaseAccess.connect();
            String query = "INSERT INTO Subject (name) VALUES (?)";
            PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
            preparedStatement.setString(1, subject.getName());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

	
