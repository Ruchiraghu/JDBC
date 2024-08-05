package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //singleton class
    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {}

    public static ConnectionFactory getConnectionFactory() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();

        }
        return connectionFactory;
    }

    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student",
                "root",
                "Ruchi@12345");
    }
}
