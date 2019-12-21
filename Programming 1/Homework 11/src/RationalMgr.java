// This application provides a dialog-based user interface for
// basic fraction manipulation

import javax.swing.*;       	// import package javax.swing

public class RationalMgr
{   
	private static Rational aFraction;      // Declare class-wide variable (object)

	//---------------------------------------------------------
	public static void main(String args[]) 
	{
		char menuChoice = 0;
		aFraction = new Rational();    // Create object instance
		boolean choiceOK = true;

		// Continuation loop - resume until exit menu choice made
		do
		{  
			// Menu choice and validation of user choice
			do
			{
				menuChoice = menu();
				if (! validMenuChoice(menuChoice))
				{
					choiceOK = false;
					JOptionPane.showMessageDialog(null,
							"Invalid choice - Please re-enter",
							"Error Notification", 
							JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					choiceOK = true;
					handleMenuChoice(menuChoice);
				}
			} while (! choiceOK );

		} while (menuChoice != '8');

		System.exit( 0 );  // Exit application

	}  // end main

	//---------------------------------------------------------
	// This method displays the menu and accepts a user choice
	public static char menu()
	{
		String inputChar;

		inputChar = JOptionPane.showInputDialog(null, 
				"CURRENT FRACTION: " + aFraction.getNumerator() + "/" +
						aFraction.getDenominator() + "\n" +
						"1) Enter a new fraction" + "\n" +
						"2) Reduce current fraction" + "\n" +
						"3) Reciprocate current fraction" + "\n" +
						"4) Convert current fraction to decimal" + "\n" +
						"5) Subtract current fraction by new fraction" + "\n" +
						"6) Divide current fraction by new fraction" + "\n" +
						"7) Compare to new fraction" + "\n" +
						"8) Exit application" + "\n\n" +
						"ENTER SELECTION: ",
						"Fraction Manager", 
						JOptionPane.PLAIN_MESSAGE );

		return inputChar.charAt(0);  // Return first character of input string
	}

	//---------------------------------------------------------
	// This method displays the menu and accepts a user choice
	public static boolean validMenuChoice(char choice)
	{
		if (choice != '1' && choice  != '2' && 
				choice != '3' && choice  != '4' && choice  != '5' && choice  != '6' && choice  != '7' && choice  != '8')
			return false;
		else
			return true;
	}

	//---------------------------------------------------------
	// This method handles the user selection by manipulating
	// the class-wide fraction object
	public static void handleMenuChoice(char choice)
	{
		int newNum,newDen;

		switch (choice)
		{
		case '1': newNum = Integer.parseInt(
				JOptionPane.showInputDialog(null, 
						"Enter New Numerator"));
		aFraction.setNumerator(newNum);
		newDen = Integer.parseInt(
				JOptionPane.showInputDialog(null, 
						"Enter New Denominator"));
		aFraction.setDenominator(newDen);
		break;

		case '2': aFraction.reduce();
		break;

		case '3': aFraction.reciprocate();
		break;

		case '4': JOptionPane.showMessageDialog(null, 
				aFraction.getNumerator() + "/" +
						aFraction.getDenominator() + " = " +
						aFraction.getDecimal());
		break;

		case '5': 
			newNum = Integer.parseInt(
					JOptionPane.showInputDialog(null, 
							"Enter New Numerator"));
			aFraction.setNumerator(newNum);
			newDen = Integer.parseInt(
					JOptionPane.showInputDialog(null, 
							"Enter New Denominator"));
			Rational answer  = aFraction.subtract(new Rational(newNum, newDen));
			JOptionPane.showMessageDialog(null, answer.getNumerator() + "/" +
					answer.getDenominator());
			break;

		case '6':
			newNum = Integer.parseInt(
					JOptionPane.showInputDialog(null, 
							"Enter New Numerator"));
			aFraction.setNumerator(newNum);
			newDen = Integer.parseInt(
					JOptionPane.showInputDialog(null, 
							"Enter New Denominator"));
			Rational answer2  = aFraction.divide(new Rational(newNum, newDen));
			JOptionPane.showMessageDialog(null, answer2.getNumerator() + "/" +
					answer2.getDenominator());
			break;

		case '7':
			newNum = Integer.parseInt(
					JOptionPane.showInputDialog(null, 
							"Enter New Numerator"));
			newDen = Integer.parseInt(
					JOptionPane.showInputDialog(null, 
							"Enter New Denominator"));
			int result = aFraction.compareTo(new Rational(newNum, newDen));
			switch (result) {
			case 1:
				JOptionPane.showMessageDialog(null, "First fraction is greater than new fraction.");
				break;

			case -1:
				JOptionPane.showMessageDialog(null, "First fraction is less than new fraction.");
				break;

			case 0:
				JOptionPane.showMessageDialog(null, "Fractions are equal.");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Error! Invalid fraction.");
				break;
			}
			
			break;

		};  // end switch
	}  // end method
} // end class
