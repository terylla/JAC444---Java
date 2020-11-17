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

public class Square extends Rectangle {
	//private static DecimalFormat formatter = new DecimalFormat("##.#####");
	// Constructor
	public Square(double side) throws Exception {
		super(side, side);		
	}

	//******** Setters and Getters are inherited from Rectangle *********//


							//***** Perimeter and toString() *****//
	// Square perimeter = 4 * side
	@Override
	public double perimeter() {
		return 4 * getWidth() ;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("##0.0000##");
		return String.format( this.getClass().getSimpleName() + " {s=" + getWidth() + "}" + " perimeter = " + df.format(perimeter()) + "\n");
	}

}
