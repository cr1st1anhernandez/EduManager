package EduManager.Controllers;

import EduManager.DataBase.DatabaseAccess;
import EduManager.Entities.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GroupController {
    
    public boolean createGroup(Group group) {
        try {
            Connection connection = DatabaseAccess.getConnection();
            String query = "INSERT INTO `Group` (groupId) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, group.getGroupId());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
