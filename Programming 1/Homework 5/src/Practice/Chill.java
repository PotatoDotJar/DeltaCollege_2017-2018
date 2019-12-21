package Practice;

//******************************************************************
//This program prompts the user for temperature and a wind speed.
//It calculates the wind chill temperature using the current 
//formula (new) as well as the older, obsolete formula (old).
//******************************************************************

import javax.swing.JOptionPane;

public class Chill {

	// Variable declarations
	static String tempStr, windStr;
	static double temp, wind;

	public static void main(String args[]) {
		// Input   
		tempStr = JOptionPane.showInputDialog("Enter temperature (deg F): ");
		temp = Double.parseDouble(tempStr);
		windStr = JOptionPane.showInputDialog("Enter wind speed: (mph):   ");
		wind = Double.parseDouble(windStr);
		
		if(isTemperatureInRange(temp) && isWindInRange(wind)) {
		
			// Do calculations
			double oldChill = oldWindChillCalculation(temp, wind);
			double newChill = newWindChillCalculation(temp, wind);
			
			// Output
			showOutput(oldChill, newChill);
			
		} else {
			// If variables are in range
			JOptionPane.showMessageDialog(null, "Invalid range");
		}
		


		System.exit(0);
	}

	// Method for oldWindChillCalculations
	public static double oldWindChillCalculation(double tempeture, double windSpeed) {
		return Math.round(91.4 - (91.4 - tempeture) 
				* (0.478 + 0.301 * Math.sqrt(windSpeed) - 0.02 * windSpeed));
	}

	// Method for newWindChillCalculations
	public static double newWindChillCalculation(double tempeture, double windSpeed) {
		return Math.round(35.74 + 0.6215 * tempeture - 35.75 
				* Math.pow(windSpeed, 0.16) + 0.4275 * tempeture * Math.pow(windSpeed, 0.16));
	}
	
	// Method for validating temperature ranges.
	public static boolean isTemperatureInRange(double temperature) {
		if(temperature < 40) {
			return true;
		}
		return false;
	}
	
	// Method for validating wind ranges.
		public static boolean isWindInRange(double wind) {
			if(wind >= 0) {
				return true;
			}
			return false;
		}

	// Output
	public static void showOutput(double oldChill, double newChill) {
		String outputString;
		outputString = "Wind Chill Analysis\n";
		outputString += "Old chill: " + oldChill + "\n";
		outputString += "New chill: " + newChill + "\n";
		JOptionPane.showMessageDialog(null, outputString);
	}
}