/**
 * General information about the football player.
 * 
 * @author Richard Nader
 */
public class FootBallPlayer extends Player {

	// Base parameters
	private double yard40DashTime;

	// Base constructor
	public FootBallPlayer(String name, double heightInches, double weightPounds, double gpa, double yard40DashTime) {
		super(name, heightInches, weightPounds, gpa);

		this.yard40DashTime = yard40DashTime;

	}

	// Whether the candidate is good
	@Override
	boolean isCandidate() {
		if (isGPAValid() && getHeightInches() > 73 && getWeightPounds() > 190 && getYard40DashTime() < 4.7) {
			return true;
		}
		return false;
	}

	/**
	 * @return the yard40DashTime
	 */
	public double getYard40DashTime() {
		return yard40DashTime;
	}

	/**
	 * @param yard40DashTime
	 *            the yard40DashTime to set
	 */
	public void setYard40DashTime(double yard40DashTime) {
		this.yard40DashTime = yard40DashTime;
	}

	@Override
	public String toString() {
		return this.getName() + "\t" + "Football Candidate";
	}

}
