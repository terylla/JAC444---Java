//**********************************//
// Name: Tran Ngoc La (Teryl)
// SID: 150353175
// JAC444NBB Fall 2020
// Professor Reza Khotasjeh
// Workshop 8
//**********************************//


import java.text.DecimalFormat;

public class Student {

    private String firstName;
    private String lastName;
    private double grade;
    private String department;

    // CONSTRUCTOR //
    Student(String first, String last, double grade, String dep) {
        this.firstName = first;
        this.lastName = last;
        this.grade = grade;
        this.department = dep;
    }

    /////////////////////////*** GETTER ***//////////////////////////

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public double getGrade() {
        return this.grade;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getName(){
        return this.firstName + "\t" + this.lastName ;
    }


    /////////////////////////*** SETTER ***//////////////////////////

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    ///////// OTHER METHODS ////////
    public boolean equals(Student stu) {
        return this.getFirstName().equals(stu.getFirstName())
                && this.getLastName().equals(stu.getLastName())
                && this.getGrade() == stu.getGrade()
                && this.getDepartment().equals(stu.getDepartment());
    }


    public String toString(){
        DecimalFormat df = new DecimalFormat("00.00");
        return getFirstName() + "\t" +
                getLastName() +"\t" +
                df.format(getGrade()) +"\t" +
                getDepartment();

    }



}
