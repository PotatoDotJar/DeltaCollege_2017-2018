
/**
 * @author Richard Nader
 * Utilities class handles some basic unit conversions and output handling
 */
public class Utilities {
	
	
	// Used to convert inches to centimeters
	public static double inchesToCentimeters(double inches) {
		return inches * 2.54;
	}
	
	// Used to convert pounds to kilograms
	public static double poundsTokilograms(double pounds) {
		return pounds * 2.2;
	}
	
	// Used to get distance based on duration and speed
	public static double getDistance(int timeMinutes, double speedMPH) {
		return speedMPH * (timeMinutes/ 60);
	}
	
	// Methods used to convert activity enums to strings (Not used)
	public static String activityEnumToString(HealthLog.activityType activity) {
		if(activity == HealthLog.activityType.RUNNING) {
			return "Running";
		}
		else if(activity == HealthLog.activityType.WALKING) {
			return "Walking";
		}
		return "Invalid";
	}
	
	// Methods used to convert gender enums to strings (Not used)
	public static String genderEnumToString(HealthLog.gender gen) {
		if(gen == HealthLog.gender.MALE) {
			return "Male";
		}
		else if(gen == HealthLog.gender.FEMALE) {
			return "Female";
		}
		return "Invalid";
	}
	
}
