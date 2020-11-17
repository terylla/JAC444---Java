//**********************************************
// Name: Tran Ngoc La (Teryl)
// SID: 150353175
// JAC444NBB Fall 2020
// Professor Reza Khojasteh
//
// WORKSHOP 6
//**********************************************

import java.text.DecimalFormat;

public class Circle implements Shape {

	private double radius;

	//Constructor
	public Circle(double radius) throws CircleException {
		if (radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}

							//***** Setters and getters *****//

	// Setter
	public void setRadius(double radius) throws CircleException {
		if (radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}
	// Getter
	public double getRadius() {
		return radius;
	}
						//***** Perimeter and toString() *****//

	// Circle perimeter: 2 * pi * radius
	@Override
	public double perimeter() {
		return 2 * Math.PI * getRadius();
	}

	// Calculate area
	private Area area = () -> Math.PI * getRadius() * getRadius();

	// toString()
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("##0.00000");
		return String.format( this.getClass().getSimpleName() + " {r=" + getRadius() + "}"
				+ " Perimeter = " + df.format(perimeter()) + "\n"
				+ "Area = " + df.format(area.area()) + "\n");
	}


}

