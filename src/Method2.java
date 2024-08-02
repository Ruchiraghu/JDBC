import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Method2 {
    public static void main(String[] args) {
        // Database URL, username and password
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "Ruchi@12345";

        Connection connection = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Successfully connected to the database.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console");
            e.printStackTrace();
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
}