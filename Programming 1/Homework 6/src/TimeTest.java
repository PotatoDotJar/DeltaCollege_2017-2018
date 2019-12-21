// Delta College - CST 183 - Klingler
// This application acts as a test driver for the Time class

public class TimeTest 
{
    public static void main( String args[] )
   { 
        Time time1 = new Time();
        System.out.println(time1.toString());
        
        // Test "max" and "zero" actions
        Time time2 = new Time();
        time2.toZero();
        System.out.println(time2.toString());
        time2.setMax();
        System.out.println(time2.toString());
        
        // Test copy constructor
        Time time3 = new Time(time2);
        System.out.println(time3.toString());
        
        // test standard time feature
        System.out.println(time3.toStandardString());
       
        // Test "tick" action
        Time time4 = new Time(23,59,55);
        for (int i = 1; i <= 1000; i++)
        {
            time4.tick();
            System.out.println(time4.toString());
        }
   }
} 
