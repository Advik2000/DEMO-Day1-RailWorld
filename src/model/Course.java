package model;

public class Course {
    private int id;
    private String courseName;
    private double courseFees;

    public Course(String courseName, double courseFees, int id) {
        this.courseName = courseName;
        this.courseFees = courseFees;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCourseFees() {
        return courseFees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseFees(double courseFees) {
        this.courseFees = courseFees;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseFees=" + courseFees +
                '}';
    }
}
