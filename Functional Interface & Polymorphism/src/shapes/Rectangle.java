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

public class Rectangle implements Shape {
	
	private double width;
	private double height;
	
	// Constructor //
	public Rectangle(double width, double height) throws Exception{
		if (width > 0 && height > 0) {
			this.width = width;
			this.height = height;
		} else {
			throw new Exception("Invalid side(s)!");
		}
	}

						//***** Setters and getters *****//
	// Width setter
	public void setWidth(double width) throws Exception {
		if (width > 0) {
			this.width = width;
		} else {
			throw new Exception("Invalid side(s)!");
		}
	}
	// Width getter
	public double getWidth() {
		return width;
	}



	// Height setter
	public void setLength(double height) throws Exception {
		if (height > 0) {
			this.height = height;
		} else {
			throw new Exception("Invalid side(s)!");
		}
	}
	// Height getter
	public double getHeight() {
		return height;
	}


					//***** Perimeter and toString() *****//

	//Rectangle perimeter = 2l * 2w
	@Override
	public double perimeter() {
		return 2 * getWidth() + 2 * getHeight();
	}

	// toString()
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("##0.0000");
		return String.format(this.getClass().getSimpleName() + " {w=" + getWidth() + ", h=" + getHeight() + "}" + " perimeter = " + df.format(perimeter()) + "\n");
	}
}
