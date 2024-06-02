package EduManager.Utils;

import EduManager.DataBase.DatabaseAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClearDatabase {

    public static void main(String[] args) {
        DatabaseAccess dbAccess = new DatabaseAccess();
        Connection connection = null;

        try {
            connection = DatabaseAccess.getConnection();
            connection.setAutoCommit(false);

            List<String> tableNames = getTableNames(connection);

            try (Statement stmt = connection.createStatement()) {
                stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
            }

            try (Statement stmt = connection.createStatement()) {
                for (String tableName : tableNames) {
                    stmt.executeUpdate("DELETE FROM " + tableName);
                }
            }

            try (Statement stmt = connection.createStatement()) {
                stmt.execute("SET FOREIGN_KEY_CHECKS = 1");
            }

            connection.commit();
            System.out.println("Todos los datos de la base de datos han sido eliminados.");

        } catch (SQLException ex) {
            System.out.println("Error al eliminar los datos de la base de datos");
            ex.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static List<String> getTableNames(Connection connection) throws SQLException {
        List<String> tableNames = new ArrayList<>();
        String sql = "SELECT table_name FROM information_schema.tables WHERE table_schema = DATABASE()";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tableNames.add(rs.getString(1));
            }
        }
        return tableNames;
    }
}
