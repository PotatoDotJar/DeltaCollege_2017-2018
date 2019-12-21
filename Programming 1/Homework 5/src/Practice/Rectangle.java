package Practice;

//Delta College - CST 183 - Klingler
//This class manages a simple rectangle. 

public class Rectangle {
	private double length;
	private double width;

	public Rectangle () {
		length = 0;
		width = 0;
	}

	// Constructor
	public Rectangle(double len, double w) {
		length = len;
		width = w;
	}

	// Mutators
	public void setLength(double len) {
		length = len;
	}
	public void setWidth(double w) {
		width = w;
	}

	// Accessors
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}

	// The getArea method returns a Rectangle object's area.
	public double getArea() {
		return length * width;
	}

	// The getPerimeter returns a Rectangle's perimeter
	public double getPerimeter() {
		return (2 * length) + (2 * width);
	}

	// The getPerimeter returns a Rectangle's perimeter
	public double getDiagonalLength() {
		return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
	}
}