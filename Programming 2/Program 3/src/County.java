import javax.swing.JOptionPane;

/**
 * @author Richard Nader
 * Class representing the county data imported.
 */
public class County {

	// Stored Variables
	private String name;
	private String seat;
	private int yearCreated;
	private String nameOrigin;
	private int area;
	private int population;
	private int fipscode;
	private String mapFileURI;

	// Main Constructor
	public County(String name, String seat, String yearCreated, String nameOrigin, String area, String population,
			String fipscode, String mapFileURI) {

		try {

			this.name = name;
			this.seat = seat;
			this.yearCreated = Integer.parseInt(yearCreated.trim());
			this.nameOrigin = nameOrigin;
			this.area = Integer.parseInt(area.trim());
			this.population = Integer.parseInt(population.trim());
			this.fipscode = Integer.parseInt(fipscode.trim());
			this.mapFileURI = "countyImages/" + mapFileURI;

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error creating County Object with name " + name
					+ "!\nCheck created, area, population, or fipscode int the data file!\nThey must be integers.");
			System.exit(0);
		}
	}

	// Other Methods

	// Getters and setters

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the seat
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * @param seat
	 *            the seat to set
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}

	/**
	 * @return the yearCreated
	 */
	public int getYearCreated() {
		return yearCreated;
	}

	/**
	 * @param yearCreated
	 *            the yearCreated to set
	 */
	public void setYearCreated(int yearCreated) {
		this.yearCreated = yearCreated;
	}

	/**
	 * @return the nameOrigin
	 */
	public String getNameOrigin() {
		return nameOrigin;
	}

	/**
	 * @param nameOrigin
	 *            the nameOrigin to set
	 */
	public void setNameOrigin(String nameOrigin) {
		this.nameOrigin = nameOrigin;
	}

	/**
	 * @return the area
	 */
	public int getArea() {
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(int area) {
		this.area = area;
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

	/**
	 * @return the fipscode
	 */
	public int getFipscode() {
		return fipscode;
	}

	/**
	 * @param fipscode
	 *            the fipscode to set
	 */
	public void setFipscode(int fipscode) {
		this.fipscode = fipscode;
	}

	/**
	 * @return the mapFileURI
	 */
	public String getMapFileURI() {
		return mapFileURI;
	}

	/**
	 * @param mapFileURI
	 *            the mapFileURI to set
	 */
	public void setMapFileURI(String mapFileURI) {
		this.mapFileURI = mapFileURI;
	}

	/*
	 * Generate String representation of Object
	 */
	@Override
	public String toString() {
		return name + ", " + fipscode;
	}

}
