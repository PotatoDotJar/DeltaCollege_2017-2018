//******************************************************************
// Delta College - CST 183
// This program prompts the user for temperature and a wind speed.
// It thencalculates the wind chill temperature and returns a sumamry
// of the weather data via an output dialog box.
//******************************************************************

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class ChillCheck 
{
	public static void main(String args[]) 
	{
		// Variable declarations
		double windChill, temp, wind;
		String outString;

		// Set up for numerical formatting
		DecimalFormat onePlace  = new DecimalFormat( "0.0" ); 
		DecimalFormat noDecimal = new DecimalFormat( "0" ); 

		// Input
		try {
			temp = Double.parseDouble(
					JOptionPane.showInputDialog("Enter temperature (deg F):"));
			wind = Double.parseDouble(
					JOptionPane.showInputDialog("Enter wind speed (mph):"));

			if(!(temp < 40)) {
				JOptionPane.showMessageDialog(null, "Temperature must be less than 40F.");
			} else if (!(wind >= 0)) {
				JOptionPane.showMessageDialog(null, "Wind speed can't be negative");
			} else {
				// Calculate wind chill
				windChill = 35.74 + 0.6215 * temp - 35.75 
						* Math.pow(wind, 0.16) + 0.4275 * temp * Math.pow(wind, 0.16);

				// Formulate output string and display output dialog
				outString = "Wind Chill Analysis:\n";
				outString += "    Temperature: " + noDecimal.format(temp) + "\n";
				outString += "    Wind:        " + noDecimal.format(wind) + "\n";
				outString += "    Wind Chill:  " + noDecimal.format(windChill);
				JOptionPane.showMessageDialog(null, outString);
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid number\n" + e.getMessage() );
		}

		System.exit(0);
	}
}