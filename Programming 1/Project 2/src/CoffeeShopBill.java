import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class CoffeeShopBill {
	
	static final double TAX = 0.06;
	static final double COFFEE_PRICE = 1.35;
	static final double LATTE_PRICE = 3.15;
	static final double MOCHA_PRICE = 3.45;
	
	static DecimalFormat format = new DecimalFormat("0.00");
	
	static int coffeeThisMonth, latteThisMonth, mochaThisMonth;
	static String customerCode; // S for student and F for faculty/staff.
	static double calculatedTax;

	public static void main(String[] args) {
		
		coffeeThisMonth = Integer.parseInt(JOptionPane.showInputDialog("How many coffees has this person purchaced this month?"));
		if(!(coffeeThisMonth > 0)) {
			JOptionPane.showMessageDialog(null, "Invalid coffee amount!");
			System.exit(0);
		}
		latteThisMonth = Integer.parseInt(JOptionPane.showInputDialog("How many lattes has this person purchaced this month?"));
		if(!(latteThisMonth > 0)) {
			JOptionPane.showMessageDialog(null, "Invalid latte amount!");
			System.exit(0);
		}
		mochaThisMonth = Integer.parseInt(JOptionPane.showInputDialog("How many mochas has this person purchaced this month?"));
		if(!(mochaThisMonth > 0)) {
			JOptionPane.showMessageDialog(null, "Invalid mocha amount!");
			System.exit(0);
		}
		
		
		customerCode = JOptionPane.showInputDialog("Is this person a Student(Type \"S\") or are they part of faculty/staff(Type \"F\")");
		
		if(customerCode.equalsIgnoreCase("S") || customerCode.equalsIgnoreCase("F")) {
			customerCode = customerCode.equals("s") ? "S" : customerCode;
			customerCode = customerCode.equals("f") ? "F" : customerCode;
		} else {
			JOptionPane.showMessageDialog(null, "Invalid customer code.");
			System.exit(0);
		}
		
		double total = (coffeeThisMonth * COFFEE_PRICE) + (latteThisMonth * LATTE_PRICE) + (mochaThisMonth * MOCHA_PRICE);
		
		if(customerCode.equals("S")) {
			calculatedTax = 0.0;
		}
		else {
			calculatedTax = total * TAX;
		}
		
		double totalBeforeDiscounts = total;
		
		// volume discounts
		if(total <= 20) {
			total = (total * 0.03)+total;
		}
		else if((total > 20) && (total <= 40)) {
			total = (total * 0.05)+total;
		}
		else if((total > 40) && (total <= 60)) {
			total = (total * 0.10)+total;
		}
		else if((total > 60) && (total <= 75)) {
			total = (total * 0.15)+total;
		}
		else if(total > 75) {
			total = (total * 0.20)+total;
		}
		
		// power drinkers discount
		if(coffeeThisMonth > 60) {
			total -= 5;
		}
		if(latteThisMonth > 40) {
			total -= 10;
		}
		if(mochaThisMonth > 50) {
			total -= 15;
		}
		
		double totalAfterDiscounts = total;
		
		total += calculatedTax;
		
		String billSummary = "Monthly Bill Summary:\n";
		billSummary += coffeeThisMonth + " Coffees @ $" + COFFEE_PRICE + " per coffee | $" + format.format(COFFEE_PRICE * coffeeThisMonth) + "\n";
		billSummary += latteThisMonth + " Lattes @ $" + LATTE_PRICE + " per latte | $" + format.format(LATTE_PRICE * latteThisMonth) + "\n";
		billSummary += mochaThisMonth + " Mochas @ $" + MOCHA_PRICE + " per mocha | $" + format.format(MOCHA_PRICE * mochaThisMonth) + "\n";
		billSummary += "Base Total (Before Tax and Dicounts): $" + format.format(totalBeforeDiscounts) + "\n";
		billSummary += "Discounts: -$" + format.format((totalAfterDiscounts - totalBeforeDiscounts)) + "\n";
		billSummary += "Tax (Discounts Don't count): $" + format.format(calculatedTax) + "\n";
		billSummary += "Grand Total: $" + format.format(total);
		JOptionPane.showMessageDialog(null, billSummary);
	}

}
