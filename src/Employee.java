public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private String email;

    public Employee(String name, String department, double salary, String email) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    public Employee(int id, String name, String department, double salary, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }
}