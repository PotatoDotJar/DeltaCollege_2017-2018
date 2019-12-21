// Delta College - CST 183 - Klingler  
// Abstract base class Employee
// All classes inheriting from this class MUST implement
// the abstract 'earnings' method

public abstract class Employee 
{
	private String firstName;
	private String lastName;

	// Constructor
	public Employee( String first, String last )
	{
		firstName = first;
		lastName = last;
	}

	// Return the first name
	public String getFirstName() 
	{ 
		return firstName; 
	}

	// Return the last name
	public String getLastName() 
	{ 
		return lastName; 
	}

	// Object status returned as String object
	public String toString()
	{ 
		return firstName + ' ' + lastName; 
	}

}
