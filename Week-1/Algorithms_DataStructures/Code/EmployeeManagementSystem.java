class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + employeeId + " - Name: " + name + " - Position -> " + position + " - Salary -> " + salary;
    }
}

public class EmployeeManagementSystem {
    private static final int MAX = 100;
    private Employee[] employees = new Employee[MAX];
    private int size = 0;

    public void addEmployee(Employee emp) {
        if (size < MAX) {
            employees[size++] = emp;
            System.out.println("Employee added: " + emp.name);
        } else {
            System.out.println("Employee limit reached.");
        }
    }

    public Employee searchEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(id)) {
                String removedName = employees[i].name;
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                System.out.println("Employee deleted: " + removedName);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void showAllEmployees() {
        if (size == 0) {
            System.out.println("No employees in the system.");
        } else {
            System.out.println("\n Employee List ");
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.addEmployee(new Employee("E101", "Tejaswini", "Team Lead", 82000));
        ems.addEmployee(new Employee("E102", "Ravi", "Developer", 60000));

        ems.showAllEmployees();

        System.out.println("\nSearching for E102");
        Employee found = ems.searchEmployee("E102");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Not found.");
        }

        System.out.println("\nDeleting E101");
        ems.deleteEmployee("E101");

        ems.showAllEmployees();
    }
}
