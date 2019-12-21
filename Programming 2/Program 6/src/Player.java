/**
 * General information about the athlete.
 * 
 * @author Richard Nader
 */
public abstract class Player {

	// Base parameters
	private String name;
	private double heightInches;
	private double weightPounds;
	private double gpa;

	// Base constructor
	public Player(String name, double heightInches, double weightPounds, double gpa) {
		this.name = name;
		this.heightInches = heightInches;
		this.weightPounds = weightPounds;
		this.gpa = gpa;
	}

	abstract boolean isCandidate();

	public boolean isGPAValid() {
		if (this.gpa >= 2.3) {
			return true;
		}
		return false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the heightInches
	 */
	public double getHeightInches() {
		return heightInches;
	}

	/**
	 * @param heightInches
	 *            the heightInches to set
	 */
	public void setHeightInches(double heightInches) {
		this.heightInches = heightInches;
	}

	/**
	 * @return the weightPounds
	 */
	public double getWeightPounds() {
		return weightPounds;
	}

	/**
	 * @param weightPounds
	 *            the weightPounds to set
	 */
	public void setWeightPounds(double weightPounds) {
		this.weightPounds = weightPounds;
	}

	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @param gpa
	 *            the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", heightInches=" + heightInches + ", weightPounds=" + weightPounds + ", gpa="
				+ gpa + "]";
	}

}
