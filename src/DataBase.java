import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    public final String URL = "jdbc:mysql://localhost:3306/my_boutiquee"; // Your database URL
    public final String USERNAME = "root";  // Your database username
    public final String PASSWORD = "";  // Your database password
    
    public ArrayList<Employee> employees = new ArrayList<>();
    public ArrayList<Items> items = new ArrayList<>();

    
    public boolean verifyUser(String username, String password){
        boolean isValid = false;
        
        try {
            // connection succeeded
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
            String sql = "SELECT * FROM login WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);  // Set username from input
            preparedStatement.setString(2, password);  // Set password from input

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                isValid = true;
            }

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
    
        
        
    public void selectEmployee(){
        try {
            // connection succeeded
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql = "SELECT * FROM employee";  // Replace 'employee' with your table name if needed
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 3: Loop through the ResultSet and create Employee objects
            while (resultSet.next()) {
                // Create a new Employee object for each row
                Employee emp = new Employee();
                
                // Set the fields of the Employee object
                emp.setName(resultSet.getString("name"));
                emp.setContact(resultSet.getInt("contact"));
                emp.setAddress(resultSet.getString("address"));
                emp.setDesignation(resultSet.getString("designation"));
                emp.setSalary(resultSet.getInt("salary"));
                
                // Add the Employee object to the ArrayList
                employees.add(emp);
            }
            
            statement.close();
            conn.close();
    
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to get the ArrayList of employees
    public ArrayList<Employee> getEmployees() {
        return employees;
    }


    public void insertEmployee(String name, int contact, String address, String designation, int salary) {
    
        try {
            // Establish the connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    
            // Create SQL query to insert a new user
            String sql = "INSERT INTO employee (name, contact, address, designation, salary) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
    
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, contact);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, designation);
            preparedStatement.setLong(5, salary);
    
            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();
    
            // Check if the insert was successful
            if (rowsAffected > 0) {
                System.out.println("Employee inserted successfully!");
            }
    
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Database connection failed or insert failed.");
            e.printStackTrace();
        }
    }
     
    

    // ITEMS DATABASE

    public void selectItems(){
        try {
            // connection succeeded
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql = "SELECT * FROM items";  // Replace 'employee' with your table name if needed
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 3: Loop through the ResultSet and create Employee objects
            while (resultSet.next()) {
                // Create a new Employee object for each row
                Items itm = new Items();
                
                // Set the fields of the Employee object
                itm.setitemName(resultSet.getString("itemName"));
                itm.setRate(resultSet.getInt("rate"));
                
                // Add the Employee object to the ArrayList
                items.add(itm);
            }
            
            statement.close();
            conn.close();
    
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to get the ArrayList of employees
    public ArrayList<Items> getItems() {
        return items;
    }


    public void insertItems(String itemName, int rate) {
    
        try {
            // Establish the connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    
            // Create SQL query to insert a new user
            String sql = "INSERT INTO items (itemName, rate) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
    
            preparedStatement.setString(1, itemName);
            preparedStatement.setInt(2, rate);
    
            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();
    
            // Check if the insert was successful
            if (rowsAffected > 0) {
                System.out.println("Employee inserted successfully!");
            }
    
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Database connection failed or insert failed.");
            e.printStackTrace();
        }
    }




}