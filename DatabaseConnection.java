import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/UserLoginDB"; // Your database URL
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Static method to get the database connection
    public static Connection getConnection() {
        try {
            // Load the MySQL JDBC driver (optional, only needed for some versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish and return the connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySQL JDBC driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }

        return null; // If connection fails, return null
    }

    // Optional: Method to close the connection if needed
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to close the connection.");
        }
    }
}
