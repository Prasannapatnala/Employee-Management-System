import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employees (name, department, salary, email) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setDouble(3, employee.getSalary());
            statement.setString(4, employee.getEmail());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Employee added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error adding employee!");
            e.printStackTrace();
        }
    }
    public void viewEmployees() {

        String sql = "SELECT * FROM employees";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            java.sql.ResultSet resultSet = statement.executeQuery()) {

                System.out.println("\n--- Employee List ---");

                while (resultSet.next()) {
                    System.out.println(
                    "ID: " + resultSet.getInt("id") +
                    " | Name: " + resultSet.getString("name") +
                    " | Department: " + resultSet.getString("department") +
                    " | Salary: " + resultSet.getDouble("salary") +
                    " | Email: " + resultSet.getString("email")
                );
            }

        } catch (SQLException e) {
        System.out.println("Error fetching employees!");
        e.printStackTrace();
        }
    }
    public void searchEmployeeById(int id) {

        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            java.sql.ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("\n--- Employee Found ---");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Department: " + resultSet.getString("department"));
                System.out.println("Salary: " + resultSet.getDouble("salary"));
                System.out.println("Email: " + resultSet.getString("email"));
            } else {
                    System.out.println("Employee not found!");
            }

        } catch (SQLException e) {
                System.out.println("Error searching employee!");
                e.printStackTrace();
        }
    }
    public void updateEmployee(int id, String department, double salary) {

        String sql = "UPDATE employees SET department = ?, salary = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, department);
            statement.setDouble(2, salary);
            statement.setInt(3, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("Employee not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating employee!");
            e.printStackTrace();
        }
    }
    public void deleteEmployee(int id) {

        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found!");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting employee!");
            e.printStackTrace();
        }
    }

}