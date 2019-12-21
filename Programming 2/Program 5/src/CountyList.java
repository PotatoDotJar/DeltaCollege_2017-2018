import java.util.Arrays;
import java.util.Comparator;

/**
 * Class to manage an array of Counties
 * 
 * @author Richard Nader
 */
public class CountyList {

	// Array to manage
	private County[] countyList;

	// Main constructor
	public CountyList() {
		countyList = new County[0];
	}

	/**
	 * Add a county to the list.
	 * 
	 * @param county
	 */
	public void add(County county) {
		int currentSize = countyList.length;
		int newSize = currentSize + 1;

		County[] temp = new County[newSize];
		for (int i = 0; i < currentSize; i++) {
			temp[i] = countyList[i];
		}

		temp[newSize - 1] = county;
		countyList = temp;

	}

	/**
	 * Method for searching array by fips code.
	 * 
	 * @param fipsCode
	 * @return County or null if no county found
	 */
	public County getByFipsCode(int fipsCode) {
		for (County county : countyList) {
			if (county.getFipsCode() == fipsCode) {
				return county;
			}
		}
		return null;
	}

	// Get county by index
	public County get(int index) {
		return countyList[index];
	}

	// Get size of array
	public int getSize() {
		return countyList.length;
	}

	// Sort by County name
	public void sort(boolean ASC) {
		Arrays.sort(countyList, new CountySort(ASC));
	}

	// To string to represent obj as string
	@Override
	public String toString() {
		return "CountyList [countyList=" + Arrays.toString(countyList) + "]";
	}

	// Sorting
	private class CountySort implements Comparator<County> {

		private boolean ASC;

		public CountySort(boolean ASC) {
			this.ASC = ASC;
		}

		@Override
		public int compare(County o1, County o2) {
			if (ASC)
				return o1.getCountyName().compareTo(o2.getCountyName());
			else
				return o2.getCountyName().compareTo(o1.getCountyName());
		}
	}

}
