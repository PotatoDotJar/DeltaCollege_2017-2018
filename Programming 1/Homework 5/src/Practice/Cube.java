package Practice;

public class Cube {
	private double length;
	private double width;
	private double breadth;

	public Cube() {
		length = 0;
		width = 0;
		breadth = 0;
	}

	// Constructor
	public Cube(double len, double w, double b) {
		length = len;
		width = w;
		breadth = b;
	}

	// Mutators
	public void setLength(double len) {
		length = len;
	}
	public void setWidth(double w) {
		width = w;
	}
	public void setBreadth(double b) {
		breadth = b;
	}

	// Accessors
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	public double getBreadth() {
		return breadth;
	}

	// The calcVolume method returns a Cube object's Volume.
	public double calcVolume() {
		return length * width * breadth;
	}

	// The getSfcArea returns a Cube's surface area
	public double getSfcArea() {
		return (2*(width * length)) + (2*(length * breadth)) + (2*(width * breadth));
	}
}
