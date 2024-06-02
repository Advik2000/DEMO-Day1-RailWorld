package service;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO = new StudentDAOImpl();

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
