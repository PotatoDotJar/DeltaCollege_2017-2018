// Delta College - CST 183 - Klingler  
// Definition of class HourlyWorker

public final class HourlyWorker extends Employee 
{
	private double wage;   // wage per hour
	private double hours;  // hours worked for week

	// Constructor for class HourlyWorker
	public HourlyWorker( String first, String last, 
			double w, double h )
	{
		super( first, last );   // call superclass constructor
		setWage( w );
		setHours( h );
	}

	// Set the wage - with error checking
	public void setWage( double w )
	{ 
		wage = ( w > 0 ? w : 0 ); 
	}

	// Set the hours worked - with error checking
	public void setHours( double h )
	{
		hours = ( h >= 0 && h < 168 ? h : 0 ); 
	}

	// Get the HourlyWorker's pay
	public double earnings() 
	{ 
		return wage * hours; 
	}

	// Object status returned as String object
	public String toString() 
	{
		return "Hourly worker: " + super.toString();
	}
}
