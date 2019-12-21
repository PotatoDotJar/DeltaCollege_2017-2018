// Delta College - CST 183 - Klingler 
// Time class declaration to manage a time value
// with hours-minutes-seconds on a 24-hour clock

import java.text.DecimalFormat;  

public class Time 
{
	private int hour;     // 0 - 23
	private int minute;   // 0 - 59
	private int second;   // 0 - 59

	// Time constructor initializes each instance variable to zero;
	// ensures that Time object starts in a consistent state
	public Time() 
	{ 
		this( 0, 0, 0 ); 
	}

	// Time constructor: hour, minute and second supplied
	public Time( int h, int m, int s ) 
	{ 
		setTime( h, m, s ); 
	}

	// Time constructor: another Time object supplied
	public Time( Time time )
	{
		// invoke Time constructor with three arguments
		this( time.getHour(), time.getMinute(), time.getSecond() );
	}

	// Set Methods
	// Set a new time value using universal time; perform 
	// validity checks on data; set invalid values to zero
	public void setTime( int h, int m, int s )
	{
		setHour( h );   // set the hour
		setMinute( m ); // set the minute
		setSecond( s ); // set the second
	}

	// Validate and set hour 
	public void setHour( int h ) 
	{ 
		hour = ( ( h >= 0 && h < 24 ) ? h : 0 ); 
	}

	// Validate and set minute 
	public void setMinute( int m ) 
	{ 
		minute = ( ( m >= 0 && m < 60 ) ? m : 0 ); 
	}

	// Validate and set second 
	public void setSecond( int s ) 
	{ 
		second = ( ( s >= 0 && s < 60 ) ? s : 0 ); 
	}

	// Get Methods
	// Get hour value
	public int getHour() 
	{ 
		return hour; 
	}

	// Get minute value
	public int getMinute() 
	{ 
		return minute; 
	}

	// Get second value
	public int getSecond() 
	{ 
		return second; 
	}

	// Convert to String in universal-time format
	public String toString()
	{
		DecimalFormat twoDigits = new DecimalFormat( "00" );

		return twoDigits.format( getHour() ) + ":" +
		twoDigits.format( getMinute() ) + ":" +
		twoDigits.format( getSecond() );
	}

	// Convert to String in standard-time format
	public String toStandardString()
	{
		DecimalFormat twoDigits = new DecimalFormat( "00" );

		return ( ( getHour() == 12 || getHour() == 0 ) ? 
				12 : getHour() % 12 ) + ":" + twoDigits.format( getMinute() ) +
				":" + twoDigits.format( getSecond() ) + 
				( getHour() < 12 ? " AM" : " PM" );
	}

	// Set time to maximum
	public void setMax()
	{
		setHour(23);
		setMinute(59);
		setSecond(59);

	}

	// Set time to zero
	public void toZero()
	{
		setHour(0);
		setMinute(0);
		setSecond(0);

	}

	// Set time to zero
	public void tick()
	{
		
		second++;
		
		if(second > 59) {
			second = 0;
			minute++;
		}
		if(minute > 59) {
			minute = 0;
			hour++;
		}
		if(hour > 23) {
			hour = 0;
		}
		
	}


} // end class Time
