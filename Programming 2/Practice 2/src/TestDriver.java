
// Delta College - CST 283 - Klingler
// This application is a test driver for a RightTriangle object.

import javax.swing.JOptionPane;

public class TestDriver {
	public static void main(String[] args) {
		// Instantiate Circle object
		RightTriangle myTriangle = new RightTriangle(10, 20);

		// myTriangle.setHeight(9.5); // Set new height

		// Calculate and return the area
		String output = "Area is " + myTriangle.getArea() + "\n";
		output += "Perimeter is " + myTriangle.getPerimeter() + "\n";

		// Get String representation of updated right triangle object
		output += myTriangle.toString();

		JOptionPane.showMessageDialog(null, output); // Display output

		System.exit(0);

	} // end main

} // end class CircleTest
