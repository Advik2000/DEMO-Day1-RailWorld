package model;

public class College {
    private int StudentID;
    private String collegeName;
    private String collegePlace;

    public College(int studentID, String collegePlace, String collegeName) {
        StudentID = studentID;
        this.collegePlace = collegePlace;
        this.collegeName = collegeName;
    }

    public String getCollegePlace() {
        return collegePlace;
    }

    public void setCollegePlace(String collegePlace) {
        this.collegePlace = collegePlace;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "college{" +
                "StudentID=" + StudentID +
                ", collegeName='" + collegeName + '\'' +
                ", collegePlace='" + collegePlace + '\'' +
                '}';
    }
}
