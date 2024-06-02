package dao;

import model.College;

import java.util.List;

public interface CollegeDAO {
    public boolean addCollege(College college);
    public College getCollege(int id);
    public List<College> getAllCollege();
    public boolean updateCollege(College college);
    public boolean deleteCollege(int id);

}
