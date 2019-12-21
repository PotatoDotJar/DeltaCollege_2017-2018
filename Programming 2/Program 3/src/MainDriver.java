/**
 * @author Richard Nader
 * Main runnable class
 */
public class MainDriver {

	public MainDriver() {
		// Make data manager and pass to interface
		DataManager dataManager = new DataManager();
		new Interface(dataManager);
	}

	public static void main(String[] args) {
		new MainDriver();
	}

}
