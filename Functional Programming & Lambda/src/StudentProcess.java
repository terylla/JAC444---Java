
// Workshop 7
//**********************************//

import java.util.*;

public class StudentProcess {

    // Sample input
    private static Student[] students = {
            new Student("Jack", "Smith", 50.0, "IT"),
            new Student("Aaron", "Johnson", 76.0, "IT"),
            new Student("Maaria", "White", 35.8, "Business"),
            new Student("John", "White", 47.0, "Media"),
            new Student("Laney", "White", 62.0, "IT"),
            new Student("Jack", "Jones", 32.9, "Business"),
            new Student("Wesley", "Jones", 42.89, "Media")
    };


    public static void main(String[] args) {

        /////////////****** TASK 1 ******/////////////
        List<Student> studentList = Arrays.asList(students); // no need "new ArrayList<>()"
        System.out.println("Task 1:" + "\n\n" + "Complete Student list:");
        studentList.forEach(System.out::println); // forEach() is since Java8


        ////////////****** TASK 2 ******//////////////
        System.out.println("\n" + "Task 2:" + "\n\n" + "Students who got 50.0-100.0 sorted by grade:");
        studentList
                .stream()
                .filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100)
                .sorted(Comparator.comparing(Student::getGrade)) //Comparator method
                .forEach(System.out::println);


        ////////////****** TASK 3 ******//////////////
        System.out.println("\n" + "Task 3:" + "\n\n" + "First Student who got 50.0-100.0:");
        studentList
                .stream()
                .filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100)
                .findFirst() //Optional method
                .ifPresent(System.out::println); //Optional method


        ////////////****** TASK 4 ******//////////////
        System.out.println("\n" + "Task 4:" + "\n\n" + "Students in ascending order by last name then first:");
        studentList
                .stream()
                .sorted(Comparator.comparing(Student::getFirstName)) //Comparator method
                .sorted(Comparator.comparing(Student::getLastName)) //Comparator method
                .forEach(System.out::println);
        System.out.println("Students in descending order by last name then first:");
        studentList
                .stream()
                .sorted(Comparator.comparing(Student::getFirstName).reversed())//Comparator method
                .sorted(Comparator.comparing(Student::getLastName).reversed())//Comparator method
                .forEach(System.out::println);


        ////////////****** TASK 5 ******//////////////
        System.out.println("\n" + "Task 5:" + "\n\n" + "Unique Student last names:");
        studentList
                .stream()
                .map(Student::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }

}
