import javax.swing.JOptionPane;

public class Series {

	public static void main(String[] args) {
		int numTerms;               // Number of terms for series
		int numerator,denominator;  // Work variables for fraction
		double sum;                 // Summation variable
		String inputString;  

		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		// Input number of terms
		inputString =
				JOptionPane.showInputDialog("Enter number of terms ");
		numTerms = Integer.parseInt(inputString);

		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

		sum = 0; // Initialize accumulator to zero
		numerator = 1; // Start numerator to 1
		int iterations = 0; // Keeps track of numTerms and runs.
		for (denominator = 3; iterations < numTerms; denominator += 2)  
		{
			sum += (double)numerator / (double)denominator;
			System.out.println(numerator + "/" + denominator);
			numerator += 2;
			iterations++;
		}

		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		// Output
		JOptionPane.showMessageDialog(null, "The sum is: " + sum + " Iterations:" + iterations);
		
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		// For max calulations.
		
		double targetValue = Double.parseDouble(JOptionPane.showInputDialog("Please input max number "));
		
		
		sum = 0; // Initialize accumulator to zero
		numerator = 1; // Start numerator to 1
		iterations = 0; // Keeps track of numTerms and runs.
		for (denominator = 3; sum < targetValue; denominator += 2)  
		{
			sum += (double)numerator / (double)denominator;
			numerator += 2;
			iterations++;
		}
		
		JOptionPane.showMessageDialog(null, "It takes " + iterations + " iterations to get to " + targetValue);

		System.exit(0);

	}

}
