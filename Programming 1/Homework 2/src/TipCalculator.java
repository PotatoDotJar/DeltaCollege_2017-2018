// Delta College - CST 183
// This program prompts the user for a meal cost.  It then adds
// tax and an 18% gratuity before tallying cost of the overall meal.

import java.text.DecimalFormat;
import java.util.Scanner;   

public class TipCalculator {
	public static void main( String args[] ) {
		
		final double taxPercent = 0.06D;
		final double gratuity = 0.18D;
		
		double mealCost, tip, tax, finalCost;   // Work variables
		
		DecimalFormat format = new DecimalFormat("##.##");

		// Instantiate scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);

		// Prompt for and read user input
		System.out.print("Enter meal cost: ");
		mealCost = keyboard.nextDouble();

		// Calculate tax and tip.  Add to total.
		tax = taxPercent * mealCost;
		tip = gratuity * mealCost;
		
		finalCost = mealCost + tip + tax;
		// Write output to console
		String output = "Meal Cost: $" + format.format(mealCost) + "\n";
		output += "Tax: $" + format.format(tax) + "\n";
		output += "Tip: $" + format.format(tip) + "\n";
		output += "Total: $" + format.format(finalCost);
		
		System.out.print(output);
		System.exit( 0 );   
	}
}

