//**********************************************
// Name: Tran Ngoc La (Teryl)
// SID: 150353175
// JAC444NBB Fall 2020
// Professor Reza Khojasteh
//
// WORKSHOP 6
//**********************************************


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        Shape[] shapes = new Shape[50];
        int size = 0;

        /*System.out.println("------->JAC 444 Assignment 1<-------");
        System.out.println("------->Task 1 ... <-------");*/


        try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                String[] tokens = s.split(",");

                //your code

                String name = tokens[0];

                // Circle
                if (name.equals("Circle") && tokens.length == 2) {
                    try {
                        shapes[size] = new Circle(Double.parseDouble(tokens[1]));
                        size++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                // Triangle
                if (name.equals("Triangle") && tokens.length == 4) {
                    try {
                        shapes[size] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                        size++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                // Square
                if (name.equals("Square") && tokens.length == 2) {
                    try {
                        shapes[size] = new Square(Double.parseDouble(tokens[1]));
                        size++;
                    } catch (Exception e) {
                        System.out.println("Invalid side!");
                    }
                }

                // Parallelogram
                if (name.equals("Parallelogram") && tokens.length == 3) {
                    try {
                        shapes[size] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                        size++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                // Rectangle
                if (name.equals("Rectangle") && tokens.length == 3) {
                    try {
                        shapes[size] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                        size++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            /*// Print out how many shapes were created
            System.out.printf("\n" + size + " shapes were created: ");
            // Print out created and stored shapes
            for (int i = 0; i < size; i++) {
                System.out.println();
                System.out.println(shapes[i]);
            }*/

                        //***********************************************//
                        //***************** TASK 2 *********************//
                        //*********************************************//

            double max = 0;
            double min = 0;

            //Assign max and min value to specific perimeter of "Circle" or "Triangle"
            for (int i = 0; i < size; i++) {
                String name = shapes[i].getClass().getSimpleName();
                double perimeter = shapes[i].perimeter();
                if (name.equals("Circle")) {
                    if (max <= perimeter) {
                        max = perimeter;
                    }
                    min = max;
                }
                if (name.equals("Triangle")) {
                    if (min >= perimeter) {
                        min = perimeter;
                    }
                }
            }


            System.out.println("------->Task 2 ... <-------");

            //Iterate over array again to check for max Circle and min Triangle to skip
            for (int i = 0; i < size; i++) {
                String name = shapes[i].getClass().getSimpleName();
                double perimeter = shapes[i].perimeter();
                if (name.equals("Circle") || name.equals("Triangle")) {
                    if ((perimeter == max) || (perimeter == min)) {
                        continue; //skip the line
                    }
                }
                // Print
                System.out.println(shapes[i]);
                System.out.println();
            }

                    //***********************************************//
                    //***************** TASK 3 *********************//
                    //*********************************************//

            double parSum = 0;
            double triSum = 0;

            for (int i = 0; i < size; i++) {
                String name = shapes[i].getClass().getSimpleName();
                double perimeter = shapes[i].perimeter();

                if (name.equals("Parallelogram")) {
                    parSum += perimeter;
                }
                if (name.equals("Triangle") && perimeter != min) {
                    triSum += perimeter;
                }
            }

            // Print the output
            System.out.println("------->Task 3 ... <-------");
            System.out.println("Total perimeter of Parallelogram is: " + parSum);
            System.out.println("Total perimeter of Triangle is: " + triSum);

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

