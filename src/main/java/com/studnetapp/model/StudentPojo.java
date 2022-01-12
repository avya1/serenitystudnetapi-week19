package com.studnetapp.model;

import java.util.List;

public class StudentPojo {

    private String firstName,lastname,email,programme;
    private List<String> courses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
    public static StudentPojo getStudentPojo(String firstName,String lastName,String email,String programme,List<String> courses){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastname(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courses);
        return studentPojo;
    }
}

