package dao;

import model.College;
import model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollegeDAOImple implements CollegeDAO{
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
    public boolean addCollege(College college) {
        String sql = "INSERT INTO college (studentID,collegeName,collegePlace) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, college.getStudentID());
            stmt.setString(2, college.getCollegeName());
            stmt.setString(3, college.getCollegePlace());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    @Override
    public College getCollege(int id) {
        String sql = "SELECT * FROM college WHERE  studentID = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int collegeeid =  rs.getInt(1);
                String courseName =rs.getString(2);
                String collegePlace= rs.getString(3);
                College collegeOBJ= new College(collegeeid,collegePlace,courseName);
                return collegeOBJ;
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<College> getAllCollege()  {
        List<College> collegeOBJ = new ArrayList<>();
        String sql = "SELECT * FROM college";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int studentID =  rs.getInt(1);
                String collegeName =rs.getString(2);
                String collegePlace= rs.getString(3);
                College collegeOBJ1= new College(studentID,collegePlace,collegeName);
                collegeOBJ.add(collegeOBJ1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collegeOBJ;
    }

    @Override
    public boolean updateCollege(College college) {
        String sql = "UPDATE college SET collegeName = ?, collegePlace = ? WHERE studentID = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, college.getCollegeName());
            stmt.setString(2, college.getCollegePlace());
            stmt.setInt(3, college.getStudentID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteCollege(int id) {
        String sql = "DELETE FROM college WHERE studentID = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
