import javax.swing.JOptionPane;

public class MPG {

	public static void main(String[] args) {
		double miles = 0, gallons = 0, mpg = 0;
		String inputString;      // Reusable string for input
		String outputString;     // String for final output
		String continueCheck;
		
		do {
		
		// Collect input
		inputString = JOptionPane.showInputDialog("Miles driven?");
		miles       += Double.parseDouble(inputString);
		inputString = JOptionPane.showInputDialog("Gallons of gas consumed?");
		gallons     += Double.parseDouble(inputString);
		
		continueCheck = JOptionPane.showInputDialog("Would you like to enter another trip? (-1 + ENTER to end, ENTER to continue)");
		
		
		} while (!continueCheck.equals("-1"));
		
		
		// Calculate MPG
		mpg = miles / gallons;

		// Format numerical output and display
		outputString = String.format("Your average mileage: %4.1f mpg",mpg);
		JOptionPane.showMessageDialog(null, "" + outputString);

		System.exit(0);
	}

}
