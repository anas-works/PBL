import java.sql.*;

public class DataBase {
    public String username;
    public String password;

    
    DataBase getAuthenticatedUser(String username, String password){
        DataBase user = null;

        final String URL = "jdbc:mysql://localhost:3306/my_boutiquee"; // Your database URL
        final String USERNAME = "root";  // Your database username
        final String PASSWORD = "";  // Your database password

        try {
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            // connection succeeded

            String sql = "SELECT * FROM login WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new DataBase();
                user.username = resultSet.getString("username");
                user.password = resultSet.getString("password");
            }

            preparedStatement.close();
            conn.close();


        } catch (Exception e) {
            System.out.println("Database connection failed");
        }
                return user;
    }


}