import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Employee employee =
                            new Employee(name, department, salary, email);

                    employeeDAO.addEmployee(employee);
                    break;

                case 2:
                    employeeDAO.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    employeeDAO.searchEmployeeById(searchId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine();

                    employeeDAO.updateEmployee(updateId, newDepartment, newSalary);
                    break;

                case 5:
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    employeeDAO.deleteEmployee(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you for using Employee Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}