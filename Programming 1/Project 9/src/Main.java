/**
 * @author Richard Nader
 * Main runnable class
 */
public class Main {

	public static void main(String[] args) {
		DataHandler mainHandler = new DataHandler();
		new MainGUI(mainHandler);
	}

}
