
public class Triangle extends Shape {

	// Obj variables.
	private int base;
	private int height;
	private int side1;
	private int side2;

	// Constructor
	public Triangle(int base, int height, int s1, int s2) {
		super();
		this.base = base;
		this.height = height;
		this.side1 = s1;
		this.side2 = s2;
	}



	public Triangle(int base, int height, int s1, int s2, int x, int y, String c) {
		super(x, y, c);
		this.base = base;
		this.height = height;
		this.side1 = s1;
		this.side2 = s2;
	}

	/**
	 * @return the base
	 */
	public int getBase() {
		return base;
	}

	/**
	 * @param base
	 *            the base to set
	 */
	public void setBase(int base) {
		this.base = base;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the side2
	 */
	public int getSide2() {
		return side2;
	}

	/**
	 * @param side2
	 *            the side2 to set
	 */
	public void setSide2(int side2) {
		this.side2 = side2;
	}

	/**
	 * @return the side1
	 */
	public int getSide1() {
		return side1;
	}

	/**
	 * @param side1
	 *            the side1 to set
	 */
	public void setSide1(int side1) {
		this.side1 = side1;
	}

	// Get area calculation for triangle.
	public double getArea() {
		return 0.5D * base * height;
	}

	// Get perimeter calculation for triangle.
	public double getPerimeter() {
		return side1 + side2 + base;
	}

	// Return String representation of Circle object
	public String toString() {
		return "Triangle" + "\n" + super.toString() + "Dimensions: B[" + this.base + "] H[" + this.height + "]";
	}

}
