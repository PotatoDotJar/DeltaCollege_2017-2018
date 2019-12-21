
import javax.swing.JOptionPane;  // Necessary package for dialog boxes

public class CheckData 
{
	public static void main( String args[] )
	{
		String inputCode;   

		int intCode;
		int plant;         
		int dept;     
		int units;   

		String outputMessage = "";

		// Read in code as a string
		inputCode = JOptionPane.showInputDialog( "Enter coded production input" );
		intCode   = Integer.parseInt(inputCode);

		plant    = intCode / 1000;   // Extract the plan code using integer division\
		intCode  = intCode % 1000;   // Recover the remaining digits
		dept     = intCode / 100;    // Extract department code
		units    = intCode % 100;    // Extract units produced

		System.out.println("Plant: " + plant + " Dept: " + dept + " Units: " + units);
		
		boolean valid = false;
		
		if((plant == 1) || (plant == 3) || (plant == 5)) {
			if(plant == 1) {
				if((dept == 1) || (dept == 2) || (dept == 3)) {
					if(units <= 65) {
						valid = true;
					}
				}
			}
			else if((plant == 3) || (plant == 5)) {
				if((dept == 1) || (dept == 2)) {
					if(((plant == 3) && (units <= 50)) || ((plant == 5) && (units <= 35))) {
						valid = true;
					}
				}
			}
			
		}
		// ADD VALIDATION LOGIC HERE


		if(valid) {
			outputMessage = "Plant: " + plant + " Department: " + dept +
					" produced " + units + " units ";

			// Display result
			JOptionPane.showMessageDialog( null, outputMessage);
		} else {
			JOptionPane.showMessageDialog( null, "Invalid input!");
		}

		System.exit( 0 );   

	} 

} 