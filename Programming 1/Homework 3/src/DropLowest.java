
import javax.swing.JOptionPane;  

public class DropLowest 
{
	public static void main( String args[] )
	{
		// Declare variables
		int test1, test2, test3; 
		String tempString;
		double testAverage = 0;  

		// Input test scores
		tempString = JOptionPane.showInputDialog("Test 1");
		test1 = Integer.parseInt(tempString);
		tempString = JOptionPane.showInputDialog("Test 2");
		test2 = Integer.parseInt(tempString);
		tempString = JOptionPane.showInputDialog("Test 3");
		test3 = Integer.parseInt(tempString);

		// Average top two tests
		if (test1 < test2){
			if (test1 < test3){
				testAverage = (test2 + test3)/2;
			} else { 
				testAverage = (test1 + test2)/2;
			}
		} else { 
			if (test2 < test3) {
				testAverage = (test1 + test3)/2;
			} else {
				testAverage = (test1 + test2)/2;
			}
		}

		// Write output message
		JOptionPane.showMessageDialog(null,"Test Average: " + testAverage);

		System.exit( 0 );   
	}
}