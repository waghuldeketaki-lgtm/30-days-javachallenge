import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("---------------------");
    }
}

public class EmployeeMonitoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1.Add Employee");
            System.out.println("2.Display Employees");
            System.out.println("3.Search Employee");
            System.out.println("4.Delete Employee");
            System.out.println("5.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    list.add(new Employee(id, name, dept, salary));
                    System.out.println("Employee Added Successfully!");
                    break;

                case 2:
                    for (Employee e : list) {
                        e.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Search: ");
                    int sid = sc.nextInt();
                    boolean found = false;

                    for (Employee e : list) {
                        if (e.id == sid) {
                            e.display();
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Employee Not Found!");
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int did = sc.nextInt();
                    list.removeIf(e -> e.id == did);
                    System.out.println("Employee Deleted!");
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
