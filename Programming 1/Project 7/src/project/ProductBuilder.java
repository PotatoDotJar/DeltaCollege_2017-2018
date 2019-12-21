package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author Richard Nader
 * Handler of the reviews and products file data importing and data validation.
 */
public class ProductBuilder {

	// File paths to be loaded
	private final String PROUDUCT_FILENAME = "products.txt";
	private final String REVIEWS_FILENAME = "reviews.txt";

	// Max size for temp array buffers
	private final int ARRAY_DATA_BUFFER_MAX = 1000;

	// Primary data storage variables
	private String prodData[];
	private String revData[];

	// Product Averages
	private ArrayList<ProductAvg> productAverages = new ArrayList<>();

	// File system objects
	File inFileRef;
	Scanner inputFile;

	// Constructor
	public ProductBuilder() {
		loadProductArray(); // MUST be loaded first
		loadReviewArray();
	}

	// Build a array list of ProductReview objects
	public ArrayList<ProductReview> getProductReviews() {
		ArrayList<ProductReview> productReviews = new ArrayList<>();
		for(String review : revData) {
			String[] reviewParts = review.split(" ");
			productReviews.add(new ProductReview
					(Integer.parseInt(reviewParts[0]), 
							getProductNameByID(Integer.parseInt(reviewParts[0])), 
							Integer.parseInt(reviewParts[1]), 
							Integer.parseInt(reviewParts[2])));
		}

		return productReviews;
	}

	// Build a array list of ProductReview objects
	public ArrayList<ProductReview> getProductReviewsByMonth(int month, int year) {
		ArrayList<ProductReview> productReviews = new ArrayList<>();
		for(String review : revData) {

			String[] reviewParts = review.split(" ");
			ProductReview tempProduct = new ProductReview(Integer.parseInt(reviewParts[0]), getProductNameByID(Integer.parseInt(reviewParts[0])), Integer.parseInt(reviewParts[1]), Integer.parseInt(reviewParts[2]));
			if(tempProduct.getMonth() == month && tempProduct.getYear() == year) {
				productReviews.add(tempProduct);
			}

		}

		return productReviews;
	}

	// Check if the product code is a valid product
	private boolean isProductNumValid(int productNum) {
		for(String product : prodData) {
			String[] productSpit = product.split(" ");
			if(productNum == Integer.parseInt(productSpit[0])) {
				return true;
			}
		}
		return false;

	}

	// Get a product name by ID
	public String getProductNameByID(int ID) {
		for(String product : prodData) {
			String[] productSplit = product.split(" ");
			if(Integer.parseInt(productSplit[0]) == ID) {
				return productSplit[1];
			}
		}
		return "Product Name Not Found";
	}

	// Get a product list by month and year
	public ArrayList<ProductReview> getProductListByMonth(int month, int year) {

		ArrayList<ProductReview> reviews = new ArrayList<>();
		for(ProductReview product : this.getProductReviews()) {
			if(product.getMonth() == month && product.getYear() == year) {
				reviews.add(product);
			}
		}
		return reviews;
	}


	// Method to load the products into an array.
	public void loadProductArray() {
		// Load Products file
		try {
			inFileRef = new File(PROUDUCT_FILENAME);
			inputFile = new Scanner(inFileRef);
		} catch (FileNotFoundException e) {
			System.out.println("Product File not found!");
			System.exit(0);
		}

		String[] temp = new String[ARRAY_DATA_BUFFER_MAX];
		int size = 0;
		// Loop through reviews file
		while (inputFile.hasNext())
		{
			// Read all data on one line
			temp[size] = inputFile.nextLine();
			size++;
		}

		// Set correct class array with correct size
		prodData = new String[size];
		for(int i = 0; i < prodData.length; i++) {
			prodData[i] = temp[i];


			// Add product average object for all products.
			String[] splitString = temp[i].split(" ");
			productAverages.add(new ProductAvg(Integer.parseInt(splitString[0]), splitString[1], 0)); // Avg is zero until loadReviews.
		}

		System.out.println(size + " products loaded.");

	}

	// Method to load the reviews into an array.
	public void loadReviewArray() {
		// Load Reviews file
		try {
			inFileRef = new File(REVIEWS_FILENAME);
			inputFile = new Scanner(inFileRef);
		} catch (FileNotFoundException e) {
			System.out.println("Review File not found!");
			System.exit(0);
		}

		String[] temp2 = new String[ARRAY_DATA_BUFFER_MAX];
		int size2 = 0;
		// Loop through reviews file
		while (inputFile.hasNext())
		{
			temp2[size2] = inputFile.nextLine();

			// Check for invalid dates
			String[] data = temp2[size2].split(" ");
			if(!ProductReview.isRawDateValid(Integer.parseInt(data[1]))) {
				JOptionPane.showMessageDialog(null, "Invalid date (" + data[1] + ") on line " + (size2 + 1) + " in file " + REVIEWS_FILENAME);
				System.exit(0);
			}
			if(!ProductReview.isReviewValid(Integer.parseInt(data[2]))) {
				JOptionPane.showMessageDialog(null, "Invalid review (" + data[2] + ") on line " + (size2 + 1) + " in file " + REVIEWS_FILENAME);
				System.exit(0);
			}
			if(!isProductNumValid(Integer.parseInt(data[0]))) {
				JOptionPane.showMessageDialog(null, "Invalid product ID (" + data[0] + ") on line " + (size2 + 1) + " in file " + REVIEWS_FILENAME);
				System.exit(0);
			}

			for(ProductAvg average : productAverages) {
				if(average.getProductID() == Integer.parseInt(data[0])) {
					average.setRating(average.getRating() + Integer.parseInt(data[2]));
					average.setSurveySize(average.getSurveySize() + 1);

					switch(Integer.parseInt(data[2])) {
					case 5:
						average.setNumRate5(average.getNumRate5() + 1);
						break;
					case 4:
						average.setNumRate4(average.getNumRate4() + 1);
						break;
					case 3:
						average.setNumRate3(average.getNumRate3() + 1);
						break;
					case 2:
						average.setNumRate2(average.getNumRate2() + 1);
						break;
					case 1:
						average.setNumRate1(average.getNumRate1() + 1);
						break;

					}

				}
			}


			size2++;
		}

		// Set correct class array with correct size
		revData = new String[size2];
		for(int i = 0; i < revData.length; i++) {
			revData[i] = temp2[i];
		}

		System.out.println(size2 + " reviews loaded.");

	}



	public ArrayList<ProductAvg> getProductAverages() {
		return productAverages;
	}

	public void setProductAverages(ArrayList<ProductAvg> productAverages) {
		this.productAverages = productAverages;
	}


}
