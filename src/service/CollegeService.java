package service;

import dao.CollegeDAO;
import dao.CollegeDAOImple;
import model.College;

import java.util.List;

public class CollegeService {
    CollegeDAO collegeDAO= new CollegeDAOImple();

    public boolean addCollege(College college){
        return collegeDAO.addCollege(college);
    }
    public College getCollege(int id){
        return collegeDAO.getCollege(id);
    }
    public List<College> getAllCollege(){
        return collegeDAO.getAllCollege();
    }
    public Boolean deleteCollege(int id){
        return collegeDAO.deleteCollege(id);
    }
    public boolean updateCollege(College college){
        return collegeDAO.updateCollege(college);
    }
}
