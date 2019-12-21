import javax.swing.JOptionPane;

public class PoundOunces {

	public static void main(String[] args) {
		// Variable declaration
		int ouncesIn;  
		int pounds, ounces;
		double grams;
		
		final double gramsPerOunce = 28.3495D;
		final int ouncesPerPound = 16;
		
		String tempString;    
		String outputMessage;

		// Get data
		tempString =
				JOptionPane.showInputDialog("Enter a number of ounces");
		ouncesIn = Integer.parseInt(tempString);

		// Calculations
		grams = ouncesIn * gramsPerOunce;
		pounds = ouncesIn / ouncesPerPound;
		ounces = ouncesIn % ouncesPerPound;
		
		// Build output message as String object and then display in dialog box
		outputMessage = ouncesIn + " ounces equals: " + "\n";
		outputMessage += pounds + " lbs and " + ounces + " ounce(s)\n";
		outputMessage += "or " + grams + " gram(s).";

		JOptionPane.showMessageDialog(null,outputMessage);

		System.exit(0); 

	}

}
