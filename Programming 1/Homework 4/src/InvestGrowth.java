import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class InvestGrowth {

	public static void main(String[] args) {
		double answer1;
		int answer2;

		DecimalFormat twoDigits = new DecimalFormat( "0.00" );

		// Assuming an investment of $1000 at 4.2% per month, this
		// loop calculates the value of the investment after 5 years
		
		double investment = 1000;
		for(int months = 0; months <= 60; months++) {
			investment += (0.042*investment);
		}
		
		
		// ====> ADD REQUIRED LOOP HERE AND ASSIGN RESULT TO answer1
		answer1 = investment;

		// Assuming an investment of $1000 at 4.2% per month, this
		// loop calculates how long it will take until the investment
		// reaches $1 million.
		int totalInvestment = 1000;
		int months = 0;
		while(totalInvestment < 1000000) {
			totalInvestment += (0.042 * totalInvestment);
			months++;
		}


		// ====> ADD REQUIRED LOOP HERE AND ASSIGN RESULT TO answer1
		answer2 = months;

		JOptionPane.showMessageDialog(null, 
				"$1000 compounding a 4.2% per month is valued at $" +
						twoDigits.format(answer1) + "\n" +
						"It takes " + answer2 + " months to reach $1 million");

		System.exit(0);

	}

}
