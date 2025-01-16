import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Employee extends Person {
    private DataBase employee = new DataBase();

    private String designation;
    private String salary;

    void insertData(String name, int contact, String address, String designation, String salary){
        try {
            // Establish the connection
            Connection conn = DriverManager.getConnection(employee.URL, employee.USERNAME, employee.PASSWORD);
    
            // Create SQL query to insert a new user
            String sql = "INSERT INTO login (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
    
            // Set the parameters for username and password
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            
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
