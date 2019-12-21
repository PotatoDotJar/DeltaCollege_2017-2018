/**
 * General information about the Hockey player.
 * 
 * @author Richard Nader
 */
public class HockeyPlayer extends Player {

	// Base parameters
	private int goalsPerSeason;
	private double penaltyMinutesPerSeason;
	private int plusMinusNumber;

	// Base constructor
	public HockeyPlayer(String name, double heightInches, double weightPounds, double gpa, int goalsPerSeason,
			double penaltyMinutesPerSeason, int plusMinusNumber) {
		super(name, heightInches, weightPounds, gpa);

		this.goalsPerSeason = goalsPerSeason;
		this.penaltyMinutesPerSeason = penaltyMinutesPerSeason;
		this.plusMinusNumber = plusMinusNumber;

	}

	// Whether the candidate is good
	@Override
	boolean isCandidate() {
		if (isGPAValid() && getGoalsPerSeason() >= 15 && getPenaltyMinutesPerSeason() < 12
				&& getPlusMinusNumber() > 8) {
			return true;
		}
		return false;
	}

	/**
	 * @return the goalsPerSeason
	 */
	public int getGoalsPerSeason() {
		return goalsPerSeason;
	}

	/**
	 * @param goalsPerSeason
	 *            the goalsPerSeason to set
	 */
	public void setGoalsPerSeason(int goalsPerSeason) {
		this.goalsPerSeason = goalsPerSeason;
	}

	/**
	 * @return the penaltyMinutesPerSeason
	 */
	public double getPenaltyMinutesPerSeason() {
		return penaltyMinutesPerSeason;
	}

	/**
	 * @param penaltyMinutesPerSeason
	 *            the penaltyMinutesPerSeason to set
	 */
	public void setPenaltyMinutesPerSeason(double penaltyMinutesPerSeason) {
		this.penaltyMinutesPerSeason = penaltyMinutesPerSeason;
	}

	/**
	 * @return the plusMinusNumber
	 */
	public int getPlusMinusNumber() {
		return plusMinusNumber;
	}

	/**
	 * @param plusMinusNumber
	 *            the plusMinusNumber to set
	 */
	public void setPlusMinusNumber(int plusMinusNumber) {
		this.plusMinusNumber = plusMinusNumber;
	}

	@Override
	public String toString() {
		return this.getName() + "\t" + "Hockey Candidate";
	}

}
