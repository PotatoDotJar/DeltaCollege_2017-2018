// Delta College - CST 183 - Klingler                        
// This class manages a simple right triangle.

public class RightTriangle {
	private double base;
	private double height;

	// Constructors
	public RightTriangle() {
		base = 0;
		height = 0;
	}

	// Param constructor
	public RightTriangle(int base, int height) {
		this.base = base;
		this.height = height;
	}

	// get Perimeter method
	public double getPerimeter() {
		return Math.sqrt((Math.pow(base, 2) + Math.pow(height, 2))) + height + base;
	}

	// Accessors and mutators
	public void setHeight(double h) {
		height = h;
	}

	public double getHeight() {
		return height;
	}

	public void setBase(double b) {
		base = b;
	}

	public double getBase() {
		return base;
	}

	// Calculate the area of the right triangle
	public double getArea() {
		return 0.5 * base * height;
	}

	// Method toString for this class
	public String toString() {
		return "[Right Triangle | base = " + base + " height = " + height + "] ";
	}
}