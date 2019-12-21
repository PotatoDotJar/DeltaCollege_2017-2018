/**
 * This class determines the grade for a final-exam.
 */
public class FinalExam extends Exam {

	private int possibleBonusPoints;

	public FinalExam(int questions, int possibleBonusPoints) {
		super(questions);

		this.possibleBonusPoints = possibleBonusPoints;
	}

	/**
	 * This method grades the exam. The number missed is passed in and used as a
	 * parameter as well as the number of bonus points recived.
	 * 
	 * @param missed
	 *            The number of questions missed.
	 * @param bonusPoints
	 *            got
	 */
	public void assess(int missed, int bonusPointsGot) {
		double numericScore; // To hold a numeric score

		setNumMissed(missed);

		// Calculate numerical score
		numericScore = (100.0 - (missed * getPointsEach()) + bonusPointsGot);

		// Call the inherited setScore method to set the numeric score.
		setScore(numericScore);
	}

	/**
	 * @return the possibleBonusPoints
	 */
	public int getPossibleBonusPoints() {
		return possibleBonusPoints;
	}

	/**
	 * @param possibleBonusPoints
	 *            the possibleBonusPoints to set
	 */
	public void setPossibleBonusPoints(int possibleBonusPoints) {
		this.possibleBonusPoints = possibleBonusPoints;
	}

}
