package project;

import java.text.DecimalFormat;
/**
 * @author Richard Nader
 * Object for keeping track of rating averages of each product.
 */
public class ProductAvg {

	// Variable storage
	private int productID;
	private String productName;
	private int ratings;
	private int surveySize;
	
	// Track Ratings
	private int numRate5;
	private int numRate4;
	private int numRate3;
	private int numRate2;
	private int numRate1;
	

	// Decimal format for avg output
	DecimalFormat format = new DecimalFormat("00.0");

	// Main constructor
	public ProductAvg(int productID, String productName, int ratings) {
		this.productID = productID;
		this.productName = productName;
		this.ratings = ratings;
	}

	// Gets average of each product.
	public double getAverageRating() {
		return Double.parseDouble(format.format((double) ratings / (double) surveySize));
	}

	// Getters and setters.
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getRating() {
		return ratings;
	}
	public void setRating(int ratings) {
		this.ratings = ratings;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getSurveySize() {
		return surveySize;
	}


	public void setSurveySize(int surveySize) {
		this.surveySize = surveySize;
	}

	public int getNumRate5() {
		return numRate5;
	}

	public void setNumRate5(int numRate5) {
		this.numRate5 = numRate5;
	}

	public int getNumRate4() {
		return numRate4;
	}

	public void setNumRate4(int numRate4) {
		this.numRate4 = numRate4;
	}

	public int getNumRate3() {
		return numRate3;
	}

	public void setNumRate3(int numRate3) {
		this.numRate3 = numRate3;
	}

	public int getNumRate2() {
		return numRate2;
	}

	public void setNumRate2(int numRate2) {
		this.numRate2 = numRate2;
	}

	public int getNumRate1() {
		return numRate1;
	}

	public void setNumRate1(int numRate1) {
		this.numRate1 = numRate1;
	}
}
