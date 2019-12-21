//******************************************************************
// Delta College - CST 183
// This program prompts the user for temperature and a wind speed.
// It calculates the wind chill temperature using the current 
// formula (new) as well as the older, obsolete formula (old).
//******************************************************************

import java.util.Scanner;

public class Chill {
	public static void main(String args[]) {
		// Instantiate scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);

		// Variable declarations
		double oldChill, newChill, temp, wind;

		// Input   
		System.out.print("Enter temperature (deg F): ");
		temp = keyboard.nextDouble();
		System.out.print("Enter wind speed: (mph):   ");
		wind = keyboard.nextDouble();

		// Calculate both wind chill formulas
		oldChill = 91.4 - (91.4 - temp) * (0.478 + 0.301 * Math.sqrt(wind) - 0.02 * wind);

		newChill = 35.74 + (0.6215 * temp) - (35.75 * (Math.pow(wind, 0.16D))) + (0.4275 * temp * (Math.pow(wind, 0.16D)));

		// Output
		System.out.println("\n\n");
		System.out.println("Wind Chill Analysis\n");

		System.out.println("Old chill: " + oldChill + " (deg F)\n");
		System.out.println("New chill: " + newChill + " (deg F)\n");

		System.exit(0);
	}
}