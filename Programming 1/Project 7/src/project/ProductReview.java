package project;
/**
 * @author Richard Nader
 * Object for each product review.
 */
public class ProductReview {
	
	
	// Storage variables for a common product review
	private int productNumber;
	private String productName;
	private int rawDate;
	private int rating;
	
	// Formatted date stamp
	private int year;
	private int month;
	private int day;
	
	
	// Basic constructor
	public ProductReview(int productNumber, String productName, int rawDate, int rating) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.rawDate = rawDate;
		formatRawDate(rawDate);
		this.rating = rating;
	}
	
	// Raw date to formatted date variables converter
	private void formatRawDate(int rawDate) {
		year = rawDate / 10000;
		month = (rawDate % 10000) / 100;
		day = (rawDate % 100);
	}
	private static int getYearFromRawDate(int rawDate) {
		return rawDate / 10000;
	}
	private static int getMonthFromRawDate(int rawDate) {
		return (rawDate % 10000) / 100;
	}
	private static int getDayFromRawDate(int rawDate) {
		return (rawDate % 100);
	}
	
	// Error Checking
	
	// Check if date is valid range
	public static boolean isRawDateValid(int rawDate) {
		if(getYearFromRawDate(rawDate) >= 2010 && getYearFromRawDate(rawDate) <= 2017) {
			if(getMonthFromRawDate(rawDate) <= 12 && getMonthFromRawDate(rawDate) > 0) {
				return true;
			}
		}
		return false;
	}
	
	// Check if review rating is valid
	public static boolean isReviewValid(int review) {
		if(review >= 1 && review <= 5) {
			return true;
		}
		return false;
	}
	
	
	
	// Getters and setters
	
	public String getDate() {
		return month + "/" + year;
	}
	
	
	
	public int getProductNumber() {
		return productNumber;
	}


	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}


	public int getRawDate() {
		return rawDate;
	}


	public void setRawDate(int rawDate) {
		this.rawDate = rawDate;
		formatRawDate(rawDate);
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	

	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductReview [productNumber=" + productNumber + ", rawDate=" + rawDate + ", rating=" + rating
				+ ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	
}
