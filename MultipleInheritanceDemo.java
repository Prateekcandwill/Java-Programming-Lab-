import java.util.Scanner;
interface Gross {
    void gross_salary();
}
class Employee {
    String name;
    double basic_salary;
    void acceptEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        basic_salary = scanner.nextDouble();
    }
}
class Salary extends Employee implements Gross {
    double allowance; 
    double totalGross;
    void acceptAllowances() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Allowances (DA/HRA/Expenses): ");
        allowance = scanner.nextDouble();
    }
    @Override
    public void gross_salary() {
        totalGross = basic_salary + allowance;
    }
    void displaySalaryDetails() {
        System.out.println("      EMPLOYEE SALARY SLIP        ");
        System.out.println("Employee Name : " + name);
        System.out.println("Basic Salary  : " + basic_salary);
        System.out.println("Allowances    : " + allowance);
        System.out.println("----------------------------------");
        System.out.println("Gross Salary  : " + totalGross);
     }
}
public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        Salary emp = new Salary();
        emp.acceptEmployeeDetails();
        emp.acceptAllowances();
        emp.gross_salary();
        emp.displaySalaryDetails();
    }
}
