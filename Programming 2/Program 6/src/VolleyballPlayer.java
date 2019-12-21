/**
 * General information about the Volleyball player.
 * 
 * @author Richard Nader
 */
public class VolleyballPlayer extends Player {

	// Base parameters
	private int serviceAcesPerGame;
	private int killsPerGame;

	// Base parameters
	public VolleyballPlayer(String name, double heightInches, double weightPounds, double gpa, int serviceAcesPerGame,
			int killsPerGame) {
		super(name, heightInches, weightPounds, gpa);

		this.serviceAcesPerGame = serviceAcesPerGame;
		this.killsPerGame = killsPerGame;

	}

	// Whether the candidate is good
	@Override
	boolean isCandidate() {
		if (isGPAValid() && getHeightInches() >= 70 && getServiceAcesPerGame() >= 6 && getKillsPerGame() >= 9) {
			return true;
		}
		return false;
	}

	/**
	 * @return the serviceAcesPerGame
	 */
	public int getServiceAcesPerGame() {
		return serviceAcesPerGame;
	}

	/**
	 * @param serviceAcesPerGame
	 *            the serviceAcesPerGame to set
	 */
	public void setServiceAcesPerGame(int serviceAcesPerGame) {
		this.serviceAcesPerGame = serviceAcesPerGame;
	}

	/**
	 * @return the killsPerGame
	 */
	public int getKillsPerGame() {
		return killsPerGame;
	}

	/**
	 * @param killsPerGame
	 *            the killsPerGame to set
	 */
	public void setKillsPerGame(int killsPerGame) {
		this.killsPerGame = killsPerGame;
	}

	@Override
	public String toString() {
		return this.getName() + "\t" + "Volleyball Candidate";
	}

}
