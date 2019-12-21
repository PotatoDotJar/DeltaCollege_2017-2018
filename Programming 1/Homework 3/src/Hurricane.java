
import javax.swing.JOptionPane;

public class Hurricane 
{
    public static void main( String args[] )
    {
        int windSpeed;
        String stormType;
        
        // Input storm wind speed
        windSpeed = Integer.parseInt(
                    JOptionPane.showInputDialog("Storm Wind Speed?"));
          
        if ( windSpeed > 0 )
        {
            String outputMessage = "Storm Classification: ";
        
            // Add if-logic here to append storm name to end of
            // object outputMessage
            if ((windSpeed >= 0) && (windSpeed <= 38)) {
            	outputMessage += "Tropical depression";
            }
            else if ((windSpeed >= 39) && (windSpeed <= 73)) {
            	outputMessage += "Tropical Storm";
            }
            else if ((windSpeed >= 74) && (windSpeed <= 95)) {
            	outputMessage += "Category 1";
            }
            else if ((windSpeed >= 96) && (windSpeed <= 110)) {
            	outputMessage += "Category 2";
            }
            else if ((windSpeed >= 111) && (windSpeed <= 130)) {
            	outputMessage += "Category 3";
            }
            else if ((windSpeed >= 131) && (windSpeed <= 155)) {
            	outputMessage += "Category 4";
            }
            else if (windSpeed >= 156) {
            	outputMessage += "Category 5";
            }
              
        
        
            JOptionPane.showMessageDialog( null, outputMessage,
                  "Hurricane Classification", JOptionPane.INFORMATION_MESSAGE );
            
        }
        else
            JOptionPane.showMessageDialog( null, "Invalid Wind Speed",
                  "Hurricane Classification", JOptionPane.ERROR_MESSAGE );

        System.exit( 0 );  

    } // end main

} // end class 