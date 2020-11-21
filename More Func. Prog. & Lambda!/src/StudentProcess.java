
// Workshop 8
//**********************************//

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

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

        List<Student> studentList = Arrays.asList(students); // no need "new ArrayList<>()"

        /////////////****** TASK 6 ******/////////////
        System.out.println("Task 6:" + "\n\n" + "Student names in order by last name then first name:");
        studentList
                .stream()
                .sorted(Comparator.comparing(Student::getFirstName)) // must compare before map()
                .sorted(Comparator.comparing(Student::getLastName))
                .map(Student::getName)
                .forEach(System.out::println);


        ////////////****** TASK 7 ******//////////////
        System.out.println("\n\n" + "Task 7:" + "\n\n" + "Students by department:");
        Map<String, List<Student>>  task7 =
        studentList
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartment)); // group by department
        task7.forEach((department, studentObj) -> { //department is the key & studentObj is value of Map<>
            System.out.println(department);
            studentObj.forEach(stu -> System.out.println("\t" + stu));
        });


        ////////////****** TASK 8 ******//////////////
        System.out.println("\n\n" + "Task 8:" + "\n\n" + "Count of Students by department:");
        Map<String, Long> task8 = studentList
                .stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        Map<String, Long> sortedList = new TreeMap<>(task8); // use TreeMap to sort Map naturally
        sortedList.forEach((department, count) ->
                System.out.println(department + " has " + count + " Student(s)"));


        ////////////****** TASK 9 ******//////////////
        System.out.println("\n\n" + "Task 9:" + "\n");
        double sum =
        studentList
                .stream()
                .mapToDouble(Student::getGrade)
                .sum();
        System.out.println("Sum of Students' grades: " + sum);


       ////////////****** TASK 10 ******//////////////
        System.out.println("\n\n" + "Task 10:" + "\n");
        double average =
                studentList
                        .stream()
                        .mapToDouble(Student::getGrade)
                        .average().getAsDouble();
        DecimalFormat df = new DecimalFormat("####.##");
        System.out.println("Average of Students' grades: " + df.format(average));
    }

}
