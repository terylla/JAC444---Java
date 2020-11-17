// Name: Tran Ngoc La (Teryl)
// SID: 150353175
// Workshop 5
// Professor Reza Khojasteh
// JAC444NBB Fall 2020

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationGUI extends JFrame {


    public static void serializeStudent(String firstName, String lastName, int sid, String courses, ObjectOutputStream oos) throws IOException {

        Student student = new Student();

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setStdID(sid);
        String[] temp = courses.split(",");
        for (String s : temp) {
            student.setCourses(s);
        }

        oos.writeObject(student);
        oos.flush();
    }

    public static void main(String[] args) throws IOException {


        //Creating the frame
        JFrame frame = new JFrame("Serializing students information");

        // Labels
        JLabel firstN = new JLabel();
        firstN.setText("Enter First Name: ");
        firstN.setBounds(30,5,100,100);
        JLabel lastN = new JLabel();
        lastN.setText("Enter Last Name: ");
        lastN.setBounds(30, 55, 100, 100);
        JLabel iden = new JLabel();
        iden.setText("Enter Student ID: ");
        iden.setBounds(30, 105, 100, 100 );
        JLabel crs = new JLabel();
        crs.setText("Enter courses: ");
        crs.setBounds(30, 155, 100, 100);

        //Create Text field
        JTextField first = new JTextField(20); // accepts up to 40 char
        first.setBounds(180, 40, 300, 30);
        JTextField last = new JTextField(20);
        last.setBounds(180,90,300,30);
        JTextField id = new JTextField(9);
        id.setBounds(180, 140, 300, 30);
        JTextField courses = new JTextField(50);
        courses.setBounds(180, 190, 300, 30);


        //Create buttons
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(300,250,140,20);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150,250,140,20);

        // Add to frame
        frame.add(firstN); //label
        frame.add(first); // textfield
        frame.add(lastN);
        frame.add(last);
        frame.add(iden);
        frame.add(id);
        frame.add(crs);
        frame.add(courses);
        frame.add(submitButton); // button
        frame.add(cancelButton);
        frame.setLayout(null);
        frame.setSize(600,370);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        FileOutputStream fos = new FileOutputStream("Student.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // Submitting student
        submitButton.addActionListener(e -> {

            try {

                String fName = first.getText();
                String lName = last.getText();
                int sid = Integer.parseInt(id.getText());
                String courseList = courses.getText();
                serializeStudent(fName, lName, sid, courseList, oos);
                oos.flush();

                // set back to blank each time after submitButton is clicked
                first.setText("");
                last.setText("");
                id.setText("");
                courses.setText("");

                //Add successful submission message
                JLabel submission = new JLabel();
                submission.setText("Student added!");
                submission.setBounds(235, 250, 100,100);
                frame.add(submission);

            } catch (IOException err) {
                System.err.println(err);
            }
        });

        //Cancel submission
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
}
