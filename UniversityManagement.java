/* Create a Department interface and a Hostel class, then write a Student class extending Hostel and implementing Department with a menu-driven driver class to admit, migrate (search by registration number), and display student details. */
import java.util.ArrayList;
import java.util.Scanner;
interface Department {
    String deptName = "Computer Science and Engineering";
    String deptHead = "Dr. Saptarshi Das";
    void printDeptDetails();
}
class Hostel {
    protected String hostelName;
    protected String hostelLocation;
    protected int numberOfRooms;
    public void getHostelData(String name, String location, int rooms) {
        this.hostelName = name;
        this.hostelLocation = location;
        this.numberOfRooms = rooms;
    }
    public void printHostelDetails() {
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Location: " + hostelLocation);
        System.out.println("Number of Rooms: " + numberOfRooms);
    }
}
class Student extends Hostel implements Department {
    private String studentName;
    private String regdNo;
    private String electiveSubject;
    private double avgMarks;
    public void getData(String studentName, String regdNo, String electiveSubject, double avgMarks, String hostelName, String hostelLocation, int rooms) {
        this.studentName = studentName;
        this.regdNo = regdNo;
        this.electiveSubject = electiveSubject;
        this.avgMarks = avgMarks;
        getHostelData(hostelName, hostelLocation, rooms);
    }
    public String getRegdNo() {
        return regdNo;
    }
    @Override
    public void printDeptDetails() {
        System.out.println("Department Name: " + deptName);
        System.out.println("Department Head: " + deptHead);
    }
    public void printData() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + studentName);
        System.out.println("Registration No: " + regdNo);
        System.out.println("Elective Subject: " + electiveSubject);
        System.out.println("Average Marks: " + avgMarks);
        printDeptDetails();
        printHostelDetails();
        System.out.println("-----------------------\n");
    }
}
public class UniversityManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;
        do {
            System.out.println("===== MENU =====");
            System.out.println("1) Admit new student");
            System.out.println("2) Migrate a student");
            System.out.println("3) Display details");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Registration No: ");
                    String reg = scanner.nextLine();
                    System.out.print("Enter Elective Subject: ");
                    String elective = scanner.nextLine();
                    System.out.print("Enter Average Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();                  
                    System.out.print("Enter Hostel Name: ");
                    String hName = scanner.nextLine();
                    System.out.print("Enter Hostel Location: ");
                    String hLoc = scanner.nextLine();
                    System.out.print("Enter Number of Rooms: ");
                    int hRooms = scanner.nextInt();
                    Student s = new Student();
                    s.getData(name, reg, elective, marks, hName, hLoc, hRooms);
                    students.add(s);
                    System.out.println("Student admitted successfully!\n");
                    break;
                case 2:
                    System.out.print("Enter Registration No to migrate: ");
                    String searchReg = scanner.next();
                    boolean found = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getRegdNo().equalsIgnoreCase(searchReg)) {
                            students.remove(i);
                            System.out.println("Student with Registration No " + searchReg + " has been migrated (removed from records).\n");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found!\n");
                    }
                    break;
                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students enrolled yet.\n");
                    } else {
                        for (Student std : students) {
                            std.printData();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid Choice! Please try again.\n");
            }
        } while (choice != 4);
        scanner.close();
    }
}
