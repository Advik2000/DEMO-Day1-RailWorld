package service;

import dao.CourseDAO;
import dao.CourseDAOImpl;
import model.Course;

import java.util.List;

public class CourseService {
    CourseDAO courseOBJ = new CourseDAOImpl();

    public boolean addCourse(Course course){
        return courseOBJ.addCourse(course);
    }
    public Course getCourse(int id){
        return courseOBJ.getCourse(id);
    }
    public List<Course> getAllCourse(){
        return courseOBJ.getAllCourses();
    }
    public boolean deleteCourse(int id){
         courseOBJ.deleteCourse(id);
         return true;
    }
    public boolean updateCourse(Course course){
        courseOBJ.updateCourse(course);
        return true;
    }
}
