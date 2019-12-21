/**
 * @author Richard Nader DAO for holding info for holding Annuity data.
 */
public class Annuity {

	private double investmentAmount; // Monthly amount they are able to invest while working.
	private int investmentYears; // Number of years they wish to invest in the annuity.
	private double interestRate; // Annual interest rate (Decimal percent)
	private int paymentYears; // Number of years they wish to receive funds from the annuity after retirement.

	// Main constructor
	public Annuity(double investmentAmount, int investmentYears, double interestRate, int paymentYears) {
		this.investmentAmount = investmentAmount;
		this.investmentYears = investmentYears;
		this.interestRate = (interestRate / 100);
		this.paymentYears = paymentYears;
	}

	public Annuity() {

	}

	// Calculation methods

	// Method to calculate the monthly amount they will receive until the funds of
	// the annuity run out.
	public double calcInvestTotal() {

		double P = investmentAmount;
		double r = getMonthyInterestRate();
		double n = yearsToMonths(investmentYears);

		return P * ((Math.pow((1 + r), n) - 1) / (r));

	}

	// After retirement payment
	public double calcPayout() {
		double V = calcInvestTotal();
		double r = getMonthyInterestRate();
		double n = yearsToMonths(investmentYears);

		return (V * r) / (1 - (Math.pow((1 + r), -n)));
	}

	// Utility methods
	private int yearsToMonths(int years) {
		return years * 12;
	}

	public double getMonthyInterestRate() {
		double ra = interestRate;
		double n = yearsToMonths(investmentYears);

		return Math.pow((1 + ra), (1 / n)) - 1;
	}

	// To String override
	@Override
	public String toString() {
		return "Annuity [investmentAmount=" + investmentAmount + ", investmentYears=" + investmentYears
				+ ", interestRate=" + interestRate + ", paymentYears=" + paymentYears + "]";
	}

	// Getters and stetters
	/**
	 * @return the investmentAmount
	 */
	public double getInvestmentAmount() {
		return investmentAmount;
	}

	/**
	 * @param investmentAmount
	 *            the investmentAmount to set
	 */
	public void setInvestmentAmount(double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	/**
	 * @return the investmentYears
	 */
	public int getInvestmentYears() {
		return investmentYears;
	}

	/**
	 * @param investmentYears
	 *            the investmentYears to set
	 */
	public void setInvestmentYears(int investmentYears) {
		this.investmentYears = investmentYears;
	}

	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate
	 *            the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	/**
	 * @return the paymentYears
	 */
	public int getPaymentYears() {
		return paymentYears;
	}

	/**
	 * @param paymentYears
	 *            the paymentYears to set
	 */
	public void setPaymentYears(int paymentYears) {
		this.paymentYears = paymentYears;
	}

}
