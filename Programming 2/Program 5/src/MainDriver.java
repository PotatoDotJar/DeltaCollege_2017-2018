/**
 * Main runnable driver class.
 * 
 * @author Richard Nader
 */
public class MainDriver {

	public static void main(String[] args) {
		DataManager dataManager = new DataManager();

		for (int i = 0; i < dataManager.getAlertList().getSize(); i++) {
			System.out.println(dataManager.getAlertList().get(i).toString());
		}

	}

}
