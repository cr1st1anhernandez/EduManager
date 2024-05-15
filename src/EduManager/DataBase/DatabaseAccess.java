package EduManager.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseAccess {

  public DatabaseAccess() {
    connect();
  }

  private static Connection connection;

  public static Connection getConnection() {
    return connection;
  }

  public static void connect() {
    try {
      Dotenv dotenv = Dotenv.load();
      String SERVER = dotenv.get("SERVER");
      String DATABASE = dotenv.get("DATABASE");
      String USER_ID = dotenv.get("USER_ID");
      String PASSWORD = dotenv.get("PASSWORD");
      connection = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DATABASE, USER_ID, PASSWORD);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void closeConnection() {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
