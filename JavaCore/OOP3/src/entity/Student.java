/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author D
 */
public class Student {
    private String id;
    private String StudentName;
    private String Semester;
    private String CourseName;

    public Student() {
    }

    public Student(String id, String StudentName, String Semester, String CourseName) {
        this.id = id;
        this.StudentName = StudentName;
        this.Semester = Semester;
        this.CourseName = CourseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", StudentName=" + StudentName + ", Semester=" + Semester + ", CourseName=" + CourseName + '}';
    }
    
    
}
