/**
 * Class to represent a County.
 * 
 * @author Richard Nader
 */
public class County {

	// Variables
	private int fipsCode;
	private String countyName;
	private int population;

	// Main constructor
	public County(int fipsCode, String countyName, int population) {
		this.fipsCode = fipsCode;
		this.countyName = countyName;
		this.population = population;
	}

	/**
	 * @return the fipsCode
	 */
	public int getFipsCode() {
		return fipsCode;
	}

	/**
	 * @param fipsCode
	 *            the fipsCode to set
	 */
	public void setFipsCode(int fipsCode) {
		this.fipsCode = fipsCode;
	}

	/**
	 * @return the countyName
	 */
	public String getCountyName() {
		return countyName;
	}

	/**
	 * @param countyName
	 *            the countyName to set
	 */
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @param population
	 *            the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	// To string method for output
	@Override
	public String toString() {
		return "County [fipsCode=" + fipsCode + ", countyName=" + countyName + ", population=" + population + "]";
	}


}
