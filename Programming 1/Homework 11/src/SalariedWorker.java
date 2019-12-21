// Delta College - CST 183 - Klingler  
// SalariedEmployee class extends Employee.

public class SalariedWorker extends Employee 
{
	private double weeklySalary;

	// constructor
	public SalariedWorker( String first, String last, double salary )
	{
		super( first, last ); 
		setWeeklySalary( salary );
	} 

	// set salaried employee's salary - with error checking
	public void setWeeklySalary( double salary )
	{
		weeklySalary = salary < 0.0 ? 0.0 : salary;
	} 

	// return salaried employee's salary - with error checking
	public double getWeeklySalary()
	{
		return weeklySalary;
	} 

	// calculate salaried employee's pay;
	// override abstract method earnings in Employee
	public double earnings()
	{
		return getWeeklySalary();
	} 

	// return String representation of SalariedEmployee object
	public String toString()
	{
		return "Salaried worker: " + super.toString();
	} 

}

