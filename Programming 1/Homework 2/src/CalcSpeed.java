import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CalcSpeed {
	public static void main(String[] args) {
		
		double time, distanceMiles;
		
		DecimalFormat format = new DecimalFormat("##.###");
		
		// Get variables
		time = Double.parseDouble(JOptionPane.showInputDialog("Please enter your time to arival in hours:"));
		distanceMiles = Double.parseDouble(JOptionPane.showInputDialog("How far, in miles, was your total trip?"));

		// Calculate average.
		double averageSpeed = distanceMiles / time;
		
		String output = "You went " + distanceMiles + " miles\n";
		output += "in " + time + " hours\n";
		output += "going an average speed of " + format.format(averageSpeed) + " miles per hour.";
		
		// Display the results.
		JOptionPane.showMessageDialog(null, output);

		// End the program.
		System.exit(0);
	}
}