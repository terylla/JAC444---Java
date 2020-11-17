// Name: Tran Ngoc La (Teryl)
// SID: 150353175
// Workshop 4
// Professor Reza Khojasteh
// JAC444NBB Fall 2020

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private ArrayList<String> courses = new ArrayList<String>();
    private int stdID;

    // DEFAULT CONSTRUCTOR //
    Student(){

    }

    // CONSTRUCTOR //
    public Student(int stdID, String firstName, String lastName, ArrayList<String> courses) {
        this.stdID = stdID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }


    // Setters
    public void setStdID(int stdID) {
        this.stdID = stdID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourses(String courses) {
        this.courses.add(courses);
    }

    // Getters
    public int getStdID() {
        return stdID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "First Name: " + getFirstName() + "\n"  +
                "Last Name: " + getLastName() + "\n" +
                "SID: " + getStdID() + "\n" +
                "Course(s): " + getCourses() + "\n";
    }
}
