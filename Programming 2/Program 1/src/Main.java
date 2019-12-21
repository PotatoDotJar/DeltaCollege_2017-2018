/**
 * @author Richard Nader
 * Main runnable class.
 */
public class Main {

	public static void main(String[] args) {
		// Run File parse and decode.
		FileParser fp = new FileParser();

		// Output results
		for (PressReadyMessage p : fp.getPressReadyMessages()) {
			System.out.println(p.toString());
			System.out.println();
		}

	}

}
