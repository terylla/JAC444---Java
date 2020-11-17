// Name: Tran Ngoc La (Teryl)
// SID: 150353175
// Workshop 4
// Professor Reza Khojasteh
// JAC444NBB Fall 2020

import jdk.nashorn.internal.ir.debug.ASTWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Deserialization  {

    public static void main(String[] args) throws IOException {
        ArrayList<Student> student = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("Student.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            student = (ArrayList<Student>) ois.readObject();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}


