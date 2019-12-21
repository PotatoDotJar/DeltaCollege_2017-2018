import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to represent an Alert
 * 
 * @author Richard Nader
 */
public class Alert {

	// Object variables
	private County county;
	private Date startDate;
	private Date endDate;
	private String warningMessage;
	private int sevarity; // 0 to 3 with 0 being a security threat

	private SimpleDateFormat dateFormat;

	public Alert(County county, Date startDate, Date endDate, String warningMessage,
			int sevarity) {
		dateFormat = new SimpleDateFormat("MMMM dd, yyyy hh:mm aa");
		this.county = county;
		this.startDate = startDate;
		this.endDate = endDate;
		this.warningMessage = warningMessage;
		this.sevarity = sevarity;
	}

	// Method for formating object output.
	@Override
	public String toString() {
		return warningMessage + " for " + county.getCountyName() + "\n" +
				dateFormat.format(startDate) + " - " + dateFormat.format(endDate) + "\n" +
				"Population impact: " + county.getPopulation() + "\n";
	}

	/**
	 * @return the county
	 */
	public County getCounty() {
		return county;
	}

	/**
	 * @param county
	 *            the county to set
	 */
	public void setCounty(County county) {
		this.county = county;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the warningMessage
	 */
	public String getWarningMessage() {
		return warningMessage;
	}

	/**
	 * @param warningMessage
	 *            the warningMessage to set
	 */
	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
	}

	/**
	 * @return the sevarity
	 */
	public int getSevarity() {
		return sevarity;
	}

	/**
	 * @param sevarity
	 *            the sevarity to set
	 */
	public void setSevarity(int sevarity) {
		this.sevarity = sevarity;
	}

}
