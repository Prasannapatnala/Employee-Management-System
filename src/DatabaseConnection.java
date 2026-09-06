import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/employee_management_db";

    private static final String USER = "root";
    private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }

        return connection;
    }
}