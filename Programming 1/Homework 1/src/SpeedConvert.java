import javax.swing.JOptionPane;

public class SpeedConvert {

	public static void main(String[] args) {
		// Declaring Variables
		double mph, kph, mPerSec, knots;
		String inputString, outputMessage;

		final double MPHtoKPH = 1.60934;
		final double MPHtoMS = 0.44704;
		final double MPHtoKNOT = 0.868976;
		
		// Input: getting the user input as a string and convert it to decimal value
		inputString = JOptionPane.showInputDialog("Enter speed in mph");
		mph = Double.parseDouble(inputString);
		
		// Perform the speed calculations
		kph = mph * MPHtoKPH;
		mPerSec = mph * MPHtoMS;
		knots = mph * MPHtoKNOT;
		
		// Build the output of the conversions 
		outputMessage = mph + " mph =      \n";
		outputMessage += kph + " kph        \n";
		outputMessage += mPerSec + " meters/sec \n";
		outputMessage += knots + " knots      \n";
		
		JOptionPane.showMessageDialog(null, outputMessage);
	}

}
