// This class implements a data type for storage and manipulation of fractions

public class Rational
{
	private int numerator;
	private int denominator;

	//-------------------------------------------------------------------------
	// Default constructor - set fraction to 1/1
	public Rational(  )
	{
		numerator = 1;
		denominator = 1;
	}

	// Parameterized constructor - set fraction to user data
	public Rational( int n, int d )
	{
		numerator = n;
		denominator = d;
	}

	// Method for subtracting this rational by another rational
	// n1/d1 n2/d2
	public Rational subtract(Rational rational) {
		int n1 = this.numerator;
		int d1 = this.denominator;
		int n2 = rational.numerator;
		int d2 = rational.denominator;

		int num = (n1 * d2) - (n2 * d1);
		int denom = (d1 * d2);
		
		Rational answer = new Rational(num, denom);
		answer.reduce();
		return answer;
	}

	// Method for dividing this rational by another rational
	public Rational divide(Rational rational) {
		int n1 = this.numerator;
		int d1 = this.denominator;
		int n2 = rational.numerator;
		int d2 = rational.denominator;


		int num = (n1 * d2);
		int denom = (n2 * d1);
		Rational answer = new Rational(num, denom);
		answer.reduce();
		return answer;
	}
	
	public int compareTo(Rational rational) {
		double local = (double) this.numerator / (double) this.denominator;
		double param = (double) rational.numerator / (double) rational.denominator;
		
		if(local > param) {
			return 1;
		}
		else if(param > local) {
			return -1;
		}
		else {
			return 0;
		}
		
		
	}



	//-------------------------------------------------------------------------
	/**
	 *  "get" method to access the fraction numerator
	 *  @return integer numerator
	 */
	public int getNumerator( )
	{
		return numerator;
	}

	/**
	 *  "get" method to access the fraction denominator
	 *  @return integer denominator
	 */
	public int getDenominator( )
	{
		return denominator;
	}

	//-------------------------------------------------------------------------
	/**
	 *  "set" method to change the fraction numerator
	 *  @param n numerator
	 *  @return none
	 */
	public void setNumerator( int n )
	{
		numerator = n;
	}

	/**
	 *  "set" method to change the fraction denominator
	 *  @param d denominator
	 *  @return none
	 */
	public void setDenominator( int d )
	{
		denominator = d;
	}

	//-------------------------------------------------------------------------
	/**
	 *  Calculates the decimal equivalent of a fraction
	 *  @return current numerator divided by denominator
	 */
	public double getDecimal( )
	{
		return (double) numerator / (double) denominator;
	}

	//-------------------------------------------------------------------------
	/**
	 *  swaps the current numerator and denominator
	 *  @return none
	 */
	public void reciprocate( )
	{
		int temp = numerator;
		numerator = denominator;
		denominator = temp;
	}

	//-------------------------------------------------------------------------
	/**
	 *  reduce the current fraction by dividing numerator and denominator by GCD
	 *  @return none
	 */
	public void reduce( )
	{
		int divisor = gcd(numerator,denominator);
		numerator = numerator / divisor;
		denominator = denominator / divisor;
	}

	//-------------------------------------------------------------------------
	// Private utility function to return greatest common divisor for two integers
	private int gcd(int m, int n)
	{
		boolean done = false;
		int r;

		if (n  > m)                     // m  must be larger value
		{
			int temp = m;
			m = n;
			n = temp;
		}

		// Algorithm to calculate GCD      
		do
		{
			r  = m % n;
			if (r == 0)
				done = true;
			else
			{
				m  = n;
				n  = r;
			}
		} while ( r != 0 && ! done ); 

		return n;    // Variable n emerges are GCD
	}

}  // end Rational class