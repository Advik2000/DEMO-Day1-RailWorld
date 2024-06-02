package app;

import model.College;
import model.Course;
import model.Student;
import service.CollegeService;
import service.CourseService;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentApp {
    private static StudentService studentService = new StudentService();
    private static CourseService courseServiceOBJ = new CourseService();
    private static CollegeService collegeService = new CollegeService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Course");
            System.out.println("7. View Course by ID");
            System.out.println("8. View all Course");
            System.out.println("9. Update Course");
            System.out.println("10. Delete Course");
            System.out.println("11. ADD College");
            System.out.println("12. View College");
            System.out.println("13. View All College ");
            System.out.println("14. Delete  College ");
            System.out.println("15.  Update College ");
            System.out.println("16.Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println(addcourse());
                    break;
                case 7:
                    System.out.println(viewCourseByID());
                    break;
                case 8:
                    System.out.println(viewAllCourse());
                    break;
                case 9:
                    System.out.println(updateCourse());
                    break;
                case 10:
                    System.out.println(deleteCourse());
                    break;
                case 11:
                               addCollege();
                    break;
                case 12:
                    getCollege();
                    break;
                case 13:
                    getAllCollege();
                    break;
                case 14:
                    deleteCollge();
                    break;
                case 15:
                    updateCollege();
                    break;
                case 16:
                    System.out.println("THANK YOU FOR VISITING BYE....!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter branch: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        Student student = new Student(0, name, age, grade);
        studentService.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void viewStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        Student student = studentService.getStudent(id);
        if (student != null) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Branch: " + student.getAge());
            System.out.println("Grade: " + student.getGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();
        for (Student student : students) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Branch: " + student.getAge());
            System.out.println("Grade: " + student.getGrade());
            System.out.println("-----------------------");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Student existingStudent = studentService.getStudent(id);
        if (existingStudent != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new branch: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new grade: ");
            String grade = scanner.nextLine();
            existingStudent.setName(name);
            existingStudent.setAge(age);
            existingStudent.setGrade(grade);
            studentService.updateStudent(existingStudent);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        studentService.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }
    private static String addcourse(){
        System.out.println("Enter Student ID");
        int id = scanner.nextInt();
        System.out.println("Enter course name");
        String courseName = scanner.next();
        System.out.println("Enter course fees");
        double coursefees = scanner.nextDouble();
        Course courseOBJ = new Course(courseName,coursefees,id);
        if(courseServiceOBJ.addCourse(courseOBJ)){
            return "success";
        }else{
            return "failure";
        }
    }
    private static Course viewCourseByID(){
        System.out.println("Enter Student id ");
        int id = scanner.nextInt();
        return courseServiceOBJ.getCourse(id);
    }
    private static List<Course> viewAllCourse(){
        return courseServiceOBJ.getAllCourse();
    }
    private static String deleteCourse(){
        System.out.println("enter Course ID");
        int id = scanner.nextInt();
        if(courseServiceOBJ.deleteCourse(id)){
          return  "Successfully Deleted";
        }else{
            return "Failed to Delete";
        }
    }
    private static String updateCourse(){
        System.out.println("Enter Student ID");
        int id = scanner.nextInt();
        System.out.println("Enter course name");
        String courseName = scanner.next();
        System.out.println("Enter course fees");
        double coursefees = scanner.nextDouble();
        Course courseOBJ = new Course(courseName,coursefees,id);
        if(courseServiceOBJ.updateCourse(courseOBJ)){
            return "success";
        }else{
            return "failure";
        }
    }
    private static  void addCollege(){
        System.out.print("Enter College ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter CollegeName : ");
        String collegeName = scanner.next();
        System.out.print("Enter College Place: ");
        String collegePlace = scanner.next();
        College collegeOBJ = new College(id, collegePlace,collegeName );
        collegeService.addCollege(collegeOBJ);
        System.out.println("College added successfully.");
    }
    public static  void getCollege(){
        System.out.print("Enter College ID: ");
        int id = scanner.nextInt();
        College collegeOBJ = collegeService.getCollege(id);
        if (collegeOBJ != null) {
            System.out.println("ID: " + collegeOBJ.getStudentID());
            System.out.println("College Name: " + collegeOBJ.getCollegeName());
            System.out.println("College Place: " + collegeOBJ.getCollegePlace());
        } else {
            System.out.println("College not found.");
        }
    }
    public  static void getAllCollege(){
        List<College> colleges = collegeService.getAllCollege();
        for (College college : colleges) {
            System.out.println("ID: " + college.getStudentID());
            System.out.println("College Name: " + college.getCollegeName());
            System.out.println("College Place: " + college.getCollegePlace());
            System.out.println("-----------------------");
        }
    }
    public static void deleteCollge(){
        System.out.print("Enter College ID to delete: ");
        int id = scanner.nextInt();
        collegeService.deleteCollege(id);
        System.out.println("College deleted successfully.");
    }
    public static void updateCollege(){
        System.out.print("Enter College ID to update: ");
        int id = scanner.nextInt();
        College collegeOBJ = collegeService.getCollege(id);
        if (collegeOBJ != null) {
            System.out.print("Enter new College name: ");
            String name = scanner.next();
            System.out.print("Enter new College Place: ");
            String collegePlace = scanner.next();
            collegeOBJ.setCollegeName(name);
            collegeOBJ.setCollegePlace(collegePlace);
            collegeService.updateCollege(collegeOBJ);
            System.out.println("College updated successfully.");
        } else {
            System.out.println("College not found.");
        }
    }
}

