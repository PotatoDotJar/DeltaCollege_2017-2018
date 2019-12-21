/**
 * Coordinate object stored positional x and y data for a defined point.
 * This class stores a simply (x,y) coordinate based on the Cartesian system.
 */

public class Coordinate
{
	

	private double x;
	private double y;

	/**
      The setX method stores the x-coordinate.
      @param len The value to store as the x-coordinate.
	 */
	public void setX(double x)
	{
		this.x = x;
	}

	/**
      The setWidth method stores a value in the width field.
      @param y The value to store as the y-coordinate.
	 */
	public void setY(double y)
	{
		this.y = y;
	}

	/**
   	* The set both x and y to zero.
	*/
	public void setToZeros() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * setBoth x and y.
	 * @param x The value to store as the x-coordinate.
	 * @param y The value to store as the y-coordinate.
	 */
	public void setXandY(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
      The getX method returns the x-coordinate.
      @return The x-coordinate.
	 */
	public double getX()
	{
		return x;
	}
	/**
      The getY method returns the y-coordinate.
      @return The y-coordinate.
	 */
	public double getY()
	{
		return y;
	}

	/**
      The distFromOrigin method returns distance between the current
	 * coordinate and the origin (0,0) .
      @return The distance from the origin.
	 */
	public double distFromOrigin()
	{
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	
	/*
	 * Outputs some useful info from the object in a string.
	 */
	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}

}