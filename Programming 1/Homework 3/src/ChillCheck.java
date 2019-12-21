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
		temp = Double.parseDouble(
				JOptionPane.showInputDialog("Enter temperature (deg F):"));
		// Check if temp is over 40.
		if(temp > 40) {
			JOptionPane.showMessageDialog(null, "Temperature is out of range! Must be under 40F");
		} else {

			wind = Double.parseDouble(
					JOptionPane.showInputDialog("Enter wind speed (mph):"));



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

		System.exit(0);
	}
}