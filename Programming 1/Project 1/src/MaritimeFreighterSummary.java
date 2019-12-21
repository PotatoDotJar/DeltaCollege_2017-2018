import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class MaritimeFreighterSummary {

	public static void main(String[] args) {
		
		DecimalFormat format = new DecimalFormat("##.#");
		
		// Inputs
		int timeSeconds;
		double fuelLiters, distanceMeters, freshWaterQuarts;
		
		String summary;
		
		// Quarts to gallons = 1quart to 0.25gal
		// Liters to gallons = 1liters to 0.264172gal
		// Meters to miles = 1meter to 0.000621371miles
		final double galInOneQuart = 0.25D;
		final double galInOneLiter = 0.264172D;
		final double milesInOneMeter = 0.000621371D;
		final int secondsInOneDay = 86400;
		final int secondsInOneHour = 3600;
		final int secondsInOneWeek = 604800;
		
		// Get the input
		freshWaterQuarts = Double.parseDouble(JOptionPane.showInputDialog
				("How much fresh water was used on the trip(in quarts)?"));
		
		timeSeconds = Integer.parseInt(JOptionPane.showInputDialog
				("How many seconds did the trip last?"));
		
		fuelLiters = Double.parseDouble(JOptionPane.showInputDialog
				("How much fuel was used for the duration of the trip(in liters)?"));
		
		distanceMeters = Double.parseDouble(JOptionPane.showInputDialog
				("How far did the freighter travel over the course of the trip(in meters)?"));
		
		// Convert values
		double freshWaterGallons = freshWaterQuarts * galInOneQuart;
		double fuelGallons = fuelLiters * galInOneLiter;
		double distanceMiles = distanceMeters * milesInOneMeter;
		double avgSpeed = distanceMiles / (timeSeconds/secondsInOneHour);
		
		// Convert time
		int weeks = timeSeconds / secondsInOneWeek;
		timeSeconds = timeSeconds % secondsInOneWeek;
		int days = timeSeconds / secondsInOneDay;
		timeSeconds = timeSeconds % secondsInOneDay;
		int hours = timeSeconds / secondsInOneHour;
		
		// Stitch a summary together
		summary = "TRIP SUMMARY:\n";
		summary += "Trip duration: " + weeks + " weeks, " + days + " days, and " + hours + " hours\n";
		summary += "Distance traveled: " + format.format(distanceMiles) + " miles\n";
		summary += "Average speed: " + format.format(avgSpeed) + " mph\n";
		summary += "Fuel used: " + format.format(fuelGallons) + " gallons\n";
		format.applyPattern("##.##");
		summary += "Fuel efficiency: " + format.format((distanceMiles/fuelGallons)) + " miles per gallon\n";
		format.applyPattern("###");
		
		summary += "Fresh water used: " + format.format(freshWaterGallons) + " gallons " + format.format(freshWaterQuarts) + " quarts.";
		
		JOptionPane.showMessageDialog(null, summary);

	}

}
