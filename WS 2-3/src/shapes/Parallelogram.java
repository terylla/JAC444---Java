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

public class Parallelogram extends Rectangle {
	
	public Parallelogram(double width, double height) throws Exception {
		super(width, height);
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("##0.0000##");
		return String.format( this.getClass().getSimpleName() + " {w=" + getWidth() + ", h=" + getHeight() + "}" + " perimeter = " + df.format(perimeter()) + "\n");
	}
}
