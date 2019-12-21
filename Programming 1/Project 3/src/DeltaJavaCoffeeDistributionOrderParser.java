import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Program for the DeltaJava Coffee Company distrabution center.
 * Program is designed to parse, sort, and calculate shipping, 
 * tax and totals based on data from the date file (or orderSourceFile)
 * 
 * @author Richard Nader, Jr.
 *
 */
public class DeltaJavaCoffeeDistributionOrderParser {


	// Path to orderSourceFile
	public static String orderSourceFile = "coffeeOrders.txt";

	public static void main(String[] args) {

		DecimalFormat format = new DecimalFormat("0.00");

		// Setting final prices and values
		final double singleCoffeeBagPrice = 9.50;
		final double largeBoxShipping = 4.80;
		final double mediumBoxShipping = 3.20;
		final double smallBoxShipping = 1.60;

		final double salesTAX = 0.06;
		
		// Format for end output
		
		String summary = String.format("%-18s%12s%12s%12s%12s%12s%12s%4s%4s%4s\n\n", "Customer", "Base", "Discount", "Tax", "Shipping", "Total", "Boxes: ", "Sm", "Md", "Lg");
		Scanner orderFileIn = null;

		// Order File Reading
		try {
			File ordersFile = new File(orderSourceFile);
			orderFileIn = new Scanner(ordersFile);
		} catch (FileNotFoundException e) {
			System.err.println("Error Reading File!");
			e.printStackTrace();
		}

		// I am going to use array lists to make things easier :)
		ArrayList<String> customerName = new ArrayList<>();
		ArrayList<Boolean> rushed = new ArrayList<>();
		ArrayList<Boolean> taxExempt = new ArrayList<>();
		ArrayList<Integer> bags = new ArrayList<>();
		ArrayList<Integer> dayRush = new ArrayList<>();
		ArrayList<Double> totals = new ArrayList<>();


		// Iterate through file and parse data into array lists.
		for(int column = 1; orderFileIn.hasNext(); column++) {
			String data = orderFileIn.next();
			//System.out.println(column + " Data:" + data);

			switch (column) {
			case 1:
				customerName.add(data);
				break;
			case 2:
				rushed.add(data.equalsIgnoreCase("r") ? true : false);
				break;
			case 3:
				taxExempt.add(data.equalsIgnoreCase("n") ? true : false);
				break;
			case 4:
				bags.add(Integer.parseInt(data));
				break;
			case 5:
				if(data.length() > 1) {
					customerName.add(data);
					dayRush.add(0);
					column = 1;
				} else {
					dayRush.add(Integer.parseInt(data));
					column = 0;
				}
				break;
			default:
				column = 0;
				break;
			}

		}
		// Check if the last file entry has a day rush value, if it doesn't add one.
		if(dayRush.size() < customerName.size()) {
			dayRush.add(0);
		}

		int totalLargeBoxes = 0,
			totalMediumBoxes = 0, 
			totalSmallBoxes = 0;
		
		double orderTotal = 0, 
				taxTotal = 0;
		for(int order = 0; order < customerName.size(); order++) {

			// Shipping calculations
			int totalBags = bags.get(order);

			int numLargeBoxes = totalBags / 20;
			int numMediumBoxes = (totalBags % 20) / 10;
			int numSmallBoxes = ((totalBags % 20) % 10);

			totalLargeBoxes += numLargeBoxes;
			totalMediumBoxes += numMediumBoxes;
			totalSmallBoxes += numSmallBoxes;

			// Shipping cost calculations
			double shippingCost = (numLargeBoxes * largeBoxShipping) + (numMediumBoxes * mediumBoxShipping) + (numSmallBoxes * smallBoxShipping);

			// Add rush price (If any)
			if(rushed.get(order)) {
				if(dayRush.get(order) == 1) {
					shippingCost += 40;
				}
				else if(dayRush.get(order) == 2) {
					shippingCost += 25;
				}
			}

			// Base Cost
			double baseItemCost = totalBags * singleCoffeeBagPrice;

			// Discounts
			double discounts = 0;
			if(totalBags >= 300) {
				discounts = 0.30 * baseItemCost;
			}
			else if(totalBags >= 200) {
				discounts = 0.25 * baseItemCost;
			}
			else if(totalBags >= 150) {
				discounts = 0.20 * baseItemCost;
			}
			else if(totalBags >= 100) {
				discounts = 0.15 * baseItemCost;
			}
			else if(totalBags >= 50) {
				discounts = 0.10 * baseItemCost;
			}
			else if(totalBags >= 25) {
				discounts = 0.05 * baseItemCost;
			}
			
			// Tax calculations
			double tax = taxExempt.get(order).equals(false) ? (salesTAX * baseItemCost) : 0;
			taxTotal += tax;
			
			
			// Final Total
			double finalTotal = (baseItemCost - discounts) + tax + shippingCost;
			orderTotal += finalTotal;
			
			// Order Printing
			summary += String.format("%-18s%12s%12s%12s%12s%12s%12s%4s%4s%4s\n", customerName.get(order), "$" + format.format(baseItemCost), "-$" + format.format(discounts), "$" + format.format(tax), 
					"$" + format.format(shippingCost), "$" + format.format(finalTotal), "", numLargeBoxes, numMediumBoxes, numLargeBoxes);
			
			


		}
		
		// Totals Print
		summary += String.format("\n%-18s%12s%12s%12s%12s%12s%12s%4s%4s%4s\n", "TOTALS:", "", "", "$"+format.format(taxTotal), "", "$"+format.format(orderTotal), "", totalSmallBoxes, totalMediumBoxes, totalLargeBoxes);
		
		System.out.println(summary);
		// TODO: Add totals

		/*
		System.out.println("\n\nArrayData:");
		System.out.println("Customer Names: " + customerName);
		System.out.println("Rushed: " + rushed);
		System.out.println("Tax Exempt: " + taxExempt);
		System.out.println("Number of bags: " + bags);
		System.out.println("Days for rush shipping: " + dayRush);
		*/
	}

}
