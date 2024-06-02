package EduManager.Controllers;

import EduManager.DataBase.DatabaseAccess;
import EduManager.Entities.Coordinator;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoordinatorController {

	public boolean createCoordinator(Coordinator coordinator) {
		try {
			DatabaseAccess.connect();
			String query = "INSERT INTO Coordinator (coordinatorId, password, firstName, lastName, email, phoneNumber, curp, gender, area, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = DatabaseAccess.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, coordinator.getUserId());
			preparedStatement.setString(2, coordinator.getPassword());
			preparedStatement.setString(3, coordinator.getFirstName());
			preparedStatement.setString(4, coordinator.getLastName());
			preparedStatement.setString(5, coordinator.getEmail());
			preparedStatement.setString(6, coordinator.getPhoneNumber());
			preparedStatement.setString(7, coordinator.getCurp());
			preparedStatement.setString(8, String.valueOf(coordinator.getGender()));
			preparedStatement.setString(9, coordinator.getArea());
			preparedStatement.setString(10, coordinator.getImagePath());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
