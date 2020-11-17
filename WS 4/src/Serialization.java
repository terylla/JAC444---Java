// Name: Tran Ngoc La (Teryl)
// SID: 150353175
// Workshop 4
// Professor Reza Khojasteh
// JAC444NBB Fall 2020

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization {


    public static void main(String[] args) throws IOException {

        // Create Student objects
        Student student = new Student();
        ArrayList<Student> list = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do {

            // First Name
            System.out.print("Enter Student First Name: ");
            String firstName1 = in.readLine();
            // Last Name
            System.out.print("Enter Student Last Name: ");
            String lastName1 = in.readLine();
            // ID
            System.out.print("Enter Student ID: ");
            int sid = Integer.parseInt(in.readLine());
            // Courses
            System.out.print("Enter Student Courses (add extra courses after comma): ");
            String input= in.readLine();

            // create new student object so you can add more every time
            student = new Student();

            // Pass input to student object
            String[] temp = input.split(",");
            for (int i = 0; i < temp.length; i++) {
                student.setCourses(temp[i]);
            }
            student.setFirstName(firstName1);
            student.setLastName(lastName1);
            student.setStdID(sid);

            // add object to list to serialize
            list.add(student);


            try {
                FileOutputStream fos = new FileOutputStream("Student.out");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
                oos.flush();
                fos.close();

            } catch (IOException e) {
                System.err.println(e);
            }

            System.out.println("Exit by pressing 0 or press Enter to continue.");
            String inp = in.readLine();
            if (inp.equals("0")) {
                System.exit(0);

            }

        } while (true);



    }


}