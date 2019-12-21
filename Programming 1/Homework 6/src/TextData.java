// This class stores and manages a set of data related to a text message

public class TextData
{
	private String name;
	private String phone;
	private String message;

	//-------------------------------------------------------------------------
	// No-Arg Constructor
	public TextData( )
	{
		name    = "";
		phone   = "";
		message = "";
	}

	// Parameterized constructor - set from predetermined data
	public TextData( String n, String p, String m )
	{
		name = n;
		phone = p;
		message = m;
	}

	// Parameterized constructor - set from raw input line
	public TextData( String input )
	{      
		String[] splitMessage = input.split(",");
		
		
		
		name    = splitMessage[0].trim();
		phone   = splitMessage[1].trim();
		message = splitMessage[2].trim();
		
		StringBuilder formattedPhoneNumber = new StringBuilder(phone);
		formattedPhoneNumber.deleteCharAt(0);
		formattedPhoneNumber.deleteCharAt(3);
		formattedPhoneNumber.insert(3, '-');
		formattedPhoneNumber.insert(7, '-');
		
		phone = formattedPhoneNumber.toString();
	}

	//-------------------------------------------------------------------------
	// Getters and setters

	public String getName( )
	{  return name;  }
	public void setName( String n )
	{  name = n;  }

	public String getPhone( )
	{  return phone;  }
	public void setPhone( String p )
	{  phone = p;  }

	public String getMessage( )
	{  return message;  }
	public void setMessage( String m )
	{  message = m;  }

	//-------------------------------------------------------------------------
	// Send class data to String return value

	public String toString( )
	{
		return "To: <" + name + ">\nat: <" + phone + ">\n==> <" + message + ">";
	}


}  // end TextData class