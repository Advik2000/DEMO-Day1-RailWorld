package dao;

import model.Course;

import java.util.List;

public interface CourseDAO {
    public boolean addCourse(Course course);
    public Course getCourse(int id);

    List<Course> getAllCourses();

    void updateCourse(Course course);

    void deleteCourse(int id);
}
