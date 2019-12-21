package project;

import java.util.ArrayList;
/**
 * @author Richard Nader
 * Main runnable class
 */
public class Main {

	
	public static void main(String[] args) {

		ProductBuilder productLoad = new ProductBuilder();
		ArrayList<ProductReview> reviews = productLoad.getProductReviews();
		
		new MainMenu(productLoad).setVisible(true);
	}

}
