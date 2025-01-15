import java.sql.*;

public class DataBase {
    public final String URL = "jdbc:mysql://localhost:3306/my_boutiquee"; // Your database URL
    public final String USERNAME = "root";  // Your database username
    public final String PASSWORD = "";  // Your database password
    
    public String username;
    public String password;
    

    
    public boolean verifyUser(String username, String password){
        boolean isValid = false;

        try {
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            // connection succeeded

            
            String sql = "SELECT * FROM login WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);  // Set username from input
            preparedStatement.setString(2, password);  // Set password from input

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // If a matching row is found, it means the credentials are valid
            if (resultSet.next()) {
                isValid = true;  // Credentials are valid
            }

            // Clean up
            preparedStatement.close();
            conn.close();



        } catch (Exception e) {
            System.out.println("Database connection failed");
        }
                return isValid;
    }


    public void insertUser(String username, String password) {
    
        try {
            // Establish the connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    
            // Create SQL query to insert a new user
            String sql = "INSERT INTO login (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
    
            // Set the parameters for username and password
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
    
            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();
    
            // Check if the insert was successful
            if (rowsAffected > 0) {
                System.out.println("User inserted successfully!");
            }
    
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Database connection failed or insert failed.");
            e.printStackTrace();
        }
    }


}