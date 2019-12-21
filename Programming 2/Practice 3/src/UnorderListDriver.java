/************************************************************/
/* Delta College - CST 283 - Klingler                       */
/* This program demonstrates basic functionality by driving */
/* an object of the unordered list class                    */
/************************************************************/

import javax.swing.JOptionPane;

public class UnorderListDriver {
	public static void main(String args[]) {
		UnorderList theList = new UnorderList("data.txt");

		// Check of list constructored OK and report
		if (theList.statusOK() == true) {
			JOptionPane.showMessageDialog(null, "Initial list:\n" + theList.toString());

			theList.insertFrontRand("Field,Gwendolyn");
			JOptionPane.showMessageDialog(null, "After first insert:\n" + theList.toString());

			theList.insertFrontFixed("Doe,Jane");
			JOptionPane.showMessageDialog(null, "After second insert:\n" + theList.toString());

			theList.reverse();
			JOptionPane.showMessageDialog(null, "After reverse:\n" + theList.toString());
		} else
			JOptionPane.showMessageDialog(null, "Problem with File");

		System.exit(0);
	}
}