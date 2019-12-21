import java.util.Scanner;

public class MilesPerGallon {
	
	public static void main(String[] args) {
		double milesDriven, gallonsOfGasUsed, milesPerGallon;
		
		// User input
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number of miles driven:");
		milesDriven = in.nextDouble();
		
		System.out.println("Enter gallons of gas used:");
		gallonsOfGasUsed = in.nextDouble();
		
		
		// Calculations
		milesPerGallon = milesDriven / gallonsOfGasUsed;
		
		// Output results
		System.out.println("You got " + milesPerGallon + " miles per gallon going " + milesDriven + " miles.");
		
		System.exit(0);
	}
}
