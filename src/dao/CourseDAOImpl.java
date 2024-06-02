package dao;

import model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "admin1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean addCourse(Course course) {
        String sql = "INSERT INTO course (studentID,courseName,course_fee) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, course.getId());
            stmt.setString(2, course.getCourseName());
            stmt.setDouble(3, course.getCourseFees());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Course getCourse(int id) {
        String sql = "SELECT * FROM course WHERE  studentID = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            System.out.println(id+" in getting course id");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
               int courseid =  rs.getInt(1);
                String courseName =rs.getString(2);
               double courseFees= rs.getInt(3);
                Course courseOBJ= new Course(courseName,courseFees,courseid);
                return courseOBJ;
            }
        } catch (SQLException e) {
            System.out.println("GETTING ERROR IN GET COURSE ");
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int courseid =  rs.getInt(1);
                String courseName =rs.getString(2);
                double courseFees= rs.getInt(3);
                Course courseOBJ= new Course(courseName,courseFees,courseid);
                courses.add(courseOBJ);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    @Override
    public void updateCourse(Course course) {
        String sql = "UPDATE course SET courseName = ?, course_fee = ? WHERE studentID = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getCourseName());
            stmt.setDouble(2, course.getCourseFees());
            stmt.setInt(3, course.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(int id) {
        String sql = "DELETE FROM course WHERE studentID = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



