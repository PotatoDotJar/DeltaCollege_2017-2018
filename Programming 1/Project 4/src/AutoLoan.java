import javax.swing.JOptionPane;

/**
 * @author Richard Nader
 * Class for a AutoLoan object.
 * Stores values and includes methods for calculations
 */
public class AutoLoan {

	private int termYears;
	private double annualInterestRate;
	private double initPrincipal;

	public AutoLoan() {
		// Initialize values (Used for getPromptForUserInput()!)
		this.termYears = 1;
		this.annualInterestRate = 1 / 100; // Convert to decimal percent
		this.initPrincipal = 1;
	}

	public AutoLoan(int termYears, double annualInterestRatePercent, double loanAmount) {
		this.termYears = termYears;
		this.annualInterestRate = annualInterestRatePercent / 100; // Convert to decimal percent
		this.initPrincipal = loanAmount;
	}

	// Get user input
	public void getPromptForUserInput(AutoLoan loan) {
		// Get input and validate
		int years = Integer.parseInt(JOptionPane.showInputDialog("Please enter a duration for the loan in years:"));
		while(!loan.isYearValid(years)) {
			years = Integer.parseInt(JOptionPane.showInputDialog("Invalid year! Please enter a valid duration for the loan in years(> 0):"));
		}
		loan.setTermYears(years);

		double intrestRate = Double.parseDouble(JOptionPane.showInputDialog("Please enter a percent annual interest rate for the loan:"));
		while(!loan.isAnnualInterestRateValid(intrestRate)) {
			intrestRate = Double.parseDouble(JOptionPane.showInputDialog("Invalid percent! Please enter a valid percent annual interest rate for the loan(0 - 100):"));
		}
		loan.setAnnualInterestRate(intrestRate);

		double loanPrincipal = Double.parseDouble(JOptionPane.showInputDialog("Please enter the principal of the loan:"));
		while(!loan.isLoanPrincipalValid(loanPrincipal)) {
			loanPrincipal = Double.parseDouble(JOptionPane.showInputDialog("Invalid principal! Please enter a valid principal for the loan (> 0):"));
		}
		loan.setPrincipal(loanPrincipal);
	}

	// Returns whether or not the year amount is a valid amount.
	public boolean isYearValid(int year) {
		if(year > 0)
			return true;

		return false;
	}

	// Returns whether or not the interest rate is valid.
	public boolean isAnnualInterestRateValid(double annualInterestRate) {
		if(annualInterestRate >= 0 && annualInterestRate <= 100)
			return true;

		return false;
	}

	// Returns whether or not the loan principal is a valid.
	public boolean isLoanPrincipalValid(double loanPrincipal) {
		if(loanPrincipal > 0)
			return true;

		return false;
	}

	// Calculates the monthly payment.
	public double calculateMonthlyPayment() {
		double monthlyPayment = ((annualInterestRate / 12) * initPrincipal) / (1 - (Math.pow(1 + (annualInterestRate / 12), -(termYears * 12))));
		return monthlyPayment;

	}

	// Calculates the total payment of loan for the duration.
	public double calculateTotalPayoff() {
		return calculateMonthlyPayment() * (termYears * 12);

	}

	// 
	public double calculateMinMonthlyIncomeToPayoff() {
		return calculateMonthlyPayment() + (0.70 * calculateMonthlyPayment());

	}

	/**
	 * @return the termYears
	 */
	public int getTermYears() {
		return termYears;
	}

	/**
	 * @param termYears the termYears to set
	 */
	public Boolean setTermYears(int termYears) {
		if(isYearValid(termYears)) {
			this.termYears = termYears;
			return true;
		}
		return false;
	}

	/**
	 * @return the annualInterestRate
	 */
	public double getAnnualInterestRate() {
		return annualInterestRate * 100;
	}

	/**
	 * @param annualInterestRate the annualInterestRate to set
	 */
	public Boolean setAnnualInterestRate(double annualInterestRate) {
		if(isAnnualInterestRateValid(annualInterestRate)) {
			this.annualInterestRate = annualInterestRate / 100;
			return true;
		}
		return false;
	}

	/**
	 * @return the initPrincipal
	 */
	public double getPrincipal() {
		return initPrincipal;
	}

	/**
	 * @param initPrincipal the initPrincipal to set
	 */
	public Boolean setPrincipal(double initPrincipal) {
		if(isLoanPrincipalValid(initPrincipal)) {
			this.initPrincipal = initPrincipal;
			return true;
		}
		return false;
	}

}
