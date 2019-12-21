// Delta College - CST 183 - Klingler  
// Driver for Employee hierarchy - Calculate earnings for employees
// of a variety of job classifications

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class PayrollSystemTest
{
	public static void main( String args[] )
	{
		String output = "";

		HourlyWorker worker1    = new HourlyWorker( "Karen", "Price", 13.75, 40 );

		SalariedWorker worker2  = new SalariedWorker( "Jane", "Doe", 2512.56 );

		PieceWorker worker3 	= new PieceWorker( "Don", "Joe", 75, 1.23);

		DecimalFormat precision2 = new DecimalFormat( "0.00" );

		output += worker1.toString() + " earned $" +
				precision2.format( worker1.earnings() ) + "\n";
		output += worker2.toString() + " earned $" +
				precision2.format( worker2.earnings() ) + "\n";
		output += worker3.toString() + " earned $" +
				precision2.format( worker3.earnings() ) + "\n";

		JOptionPane.showMessageDialog( null, output, "Payroll", 
				JOptionPane.INFORMATION_MESSAGE );

		System.exit( 0 );
	}
}
