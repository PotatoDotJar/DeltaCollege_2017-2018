

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * @author Richard Nader
 * Program that calculates monthly payment, total payoff, and recommended monthly income for a loan
 * using a AutoLoan object.
 */
public class Driver {

	public static void main(String[] args) {
		// Used for formating data to 00.00
		DecimalFormat format = new DecimalFormat("0.00");

		// Make loan object with constructor values
		AutoLoan loan = new AutoLoan(); // Can also Use init values instead of prompting.

		// Method to prompt user for input.
		try {
			loan.getPromptForUserInput(loan);
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid input!");
			System.exit(0);
		}
		// Build summary
		String summary = "Loan Summary:\n";
		summary += "Loan Term: " + loan.getTermYears() + " years\n";
		summary += "Loan Annual Interest Rate: " + loan.getAnnualInterestRate() + "%\n";
		summary += "Loan Principal: $" + loan.getPrincipal() + "\n\n";
		summary += "Monthly payment: $" + format.format(loan.calculateMonthlyPayment()) + "/month \n";
		summary += "Total Payoff: $" + format.format(loan.calculateTotalPayoff()) + "\n";
		summary += "Recommended monthly income for loan: At least $" + format.format(loan.calculateMinMonthlyIncomeToPayoff()) + "/month \n";

		// Show summary
		JOptionPane.showMessageDialog(null, summary);
	}

}
