/**
 * Delta College - CST 283 - Klingler & Gaddis text This class determines the
 * grade for an exam.
 */

public class Exam extends GradedActivity {
	private int numQuestions; // Number of questions
	private double pointsEach; // Points for each question
	private int numMissed; // Questions missed

	/**
	 * The constructor sets the number of questions on the exam.
	 */

	public Exam(int questions) {
		// Set the numQuestions and numMissed fields.
		numQuestions = questions;

		// Calculate the points for each question
		pointsEach = 100.0 / questions;

	}

	/**
	 * This method grades the exam. The number missed is passed in and used as a
	 * parameter.
	 * 
	 * @param missed
	 *            The number of questions missed.
	 */
	public void assess(int missed) {
		double numericScore; // To hold a numeric score

		setNumMissed(missed); // Capture number missed

		// Calculate numerical score
		numericScore = 100.0 - (missed * pointsEach);

		// Call the inherited setScore method to set the numeric score.
		setScore(numericScore);
	}

	/**
	 * The getPointsEach method returns the number of points each question is worth.
	 * 
	 * @return The value in the pointsEach field.
	 */

	public double getPointsEach() {
		return pointsEach;
	}

	/**
	 * The getNumMissed method returns the number of questions missed.
	 * 
	 * @return The value in the numMissed field.
	 */

	public int getNumMissed() {
		return numMissed;
	}

	public void setNumMissed(int numMissed) {
		this.numMissed = numMissed;
	}
}