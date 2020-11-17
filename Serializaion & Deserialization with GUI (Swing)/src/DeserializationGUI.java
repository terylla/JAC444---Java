// Name: Tran Ngoc La (Teryl)
// SID: 150353175
// Workshop 5
// Professor Reza Khojasteh
// JAC444NBB Fall 2020

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationGUI extends JFrame {


    public static void main(String[] args) throws IOException {

        //Create Jframe
        JFrame frame = new JFrame("Deserializing students information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create TextArea
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        //Create button
        JButton des = new JButton("Deserialize");
        //Create panel for button
        JPanel panel = new JPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        panel.add(des);

        // Make the button 'Deserialize' display the serialized input
        des.addActionListener(e -> {
            try {
                FileInputStream fis = new FileInputStream("Student.out");
                ObjectInputStream ois = new ObjectInputStream(fis);

                while(true) {
                    Student  student = (Student) ois.readObject();
                    if (student != null) {
                        textArea.append(student.toString() + "\n");
                    }else{
                        break;
                    }
                }
                ois.close();
            } catch (IOException | ClassNotFoundException err) {
                System.err.println(err);
            }
        });

        frame.setSize(400,400);
        frame.setVisible(true);

    }
}
