import java.util.Arrays;
import java.util.Comparator;

/**
 * Class to manage an array of Alerts
 * 
 * @author Richard Nader
 */
public class AlertList {

	// Array
	private Alert[] alertList;

	// Main constructor
	public AlertList() {
		alertList = new Alert[0];
	}

	// Add obj to array
	public void add(Alert alert) {
		int currentSize = alertList.length;
		int newSize = currentSize + 1;

		Alert[] temp = new Alert[newSize];
		for (int i = 0; i < currentSize; i++) {
			temp[i] = alertList[i];
		}

		temp[newSize - 1] = alert;
		alertList = temp;

	}

	// Get object with index
	public Alert get(int index) {
		return alertList[index];
	}

	// Get size of array
	public int getSize() {
		return alertList.length;
	}

	// Sort list
	public void sort() {
		Arrays.sort(alertList, new AlertSort(true));
	}

	// To string for representation
	@Override
	public String toString() {
		return "AlertList [alertList=" + Arrays.toString(alertList) + "]";
	}

	// Class for sorting list by severity
	private class AlertSort implements Comparator<Alert> {

		private boolean ASC;

		public AlertSort(boolean ASC) {
			this.ASC = ASC;
		}

		@Override
		public int compare(Alert o1, Alert o2) {
			if (ASC)
				return o1.getSevarity() - o2.getSevarity();
			else
				return o2.getSevarity() - o1.getSevarity();
		}
	}

}
