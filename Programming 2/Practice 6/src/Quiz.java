
public class Quiz extends GradedActivity {

	/**
	 * This method grades the exam. The number missed is passed in and used as a
	 * parameter.
	 * 
	 * @param missed
	 *            The number of questions missed.
	 */
	public void assess(int missed) {
		double numericScore; // To hold a numeric score

		if (missed <= 5) {
			// Calculate numerical score
			if (missed == 0 || missed == 1) {
				setScore(90);
			} else if (missed == 2 || missed == 3) {
				setScore(70);
			} else if (missed >= 4) {
				setScore(50);
			}

		}


	}
	
}
