package henrique.matheus.librarymanager.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private static final String URL = "jdbc:postgresql://localhost:9090/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "mypass";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null)
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        }
        catch (SQLException e) {
            System.out.printf("Error while connecting to the database: %s%n", e.getMessage());
        }
        return null;
    }
}
