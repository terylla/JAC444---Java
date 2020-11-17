//**********************************************
// Name: Tran Ngoc La (Teryl)
// SID: 150353175
// JAC444NBB Fall 2020
// Professor Reza Khojasteh
//
// WORKSHOP 2
//**********************************************

package shapes;

import java.text.DecimalFormat;

public class Triangle implements Shape {

    private double side1;
    private double side2;
    private double side3;

    // Constructor
    public Triangle(double s1, double s2, double s3) throws Exception {
        if (s1 < (s2 + s3) && s2 < (s1 + s3) && s3 < (s1 + s2)){
            this.side1 = s1;
            this.side2 = s2;
            this.side3 = s3;
        } else {
            throw new Exception("Invalid side(s)!");
        }
    }

                                //***** Setters and getters *****//
    // Side 1 getter
    public double getSide1() {
        return side1;
    }
    // Side 1 setter
    public void setSide1(double s1) throws Exception {
        if (s1 > 0) {
            this.side1 = s1;
        } else {
            throw new Exception("Invalid side(s)!");
        }
    }


    // Side 2 getter
    public double getSide2() {
        return side2;
    }
    // Side 2 setter
    public void setSide2(double s2) throws Exception {
        if (s2 > 0) {
            this.side2 = s2;
        } else {
            throw new Exception("Invalid side(s)!");
        }
    }


    // Side 3 getter
    public double getSide3() {
        return side3;
    }
    // Side 3 setter
    public void setSide3(double s3) throws Exception {
        if (s3 > 0) {
            this.side3 = s3;
        } else {
            throw new Exception("Invalid side(s)!");
        }
    }

                        //***** Perimeter and toString() *****//
    // Triangle perimeter = a + b + c
    @Override
    public double perimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    // toString()
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##0.0000");
        return String.format( this.getClass().getSimpleName()
                + " {s1=" + getSide1() + ", s2=" + getSide2() + ", s3=" + getSide3() + "}"
                + " perimeter = " + df.format(perimeter()) + "\n");

    }

}
