
// WORKSHOP 6
//**********************************************

public class Square extends Rectangle {
	//private static DecimalFormat formatter = new DecimalFormat("##.#####");
	// Constructor
	public Square(double side) throws  SquareException, RectangleException {
		super(side, side);		
	}

	//******** Setters and Getters are inherited from Rectangle *********//


							//***** Perimeter and toString() *****//
	// Square perimeter = 4 * side
	@Override
	public double perimeter() {
		return 4 * getWidth() ;
	}

	// Calculate area
	private Area area = () -> getWidth() * getWidth();

	@Override
	public String toString() {
		return String.format( this.getClass().getSimpleName() + " {s=" + getWidth() + "}"
				+ " Perimeter = " + (new Double(perimeter())).toString() + "\n"
				+ "Area = " + (new Double(area.area())).toString() + "\n");
	}

}
