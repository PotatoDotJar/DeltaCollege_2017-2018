import java.text.DecimalFormat;
/**
 * @author Richard Nader
 * Data object for storing user health information as well as 
 * including methods for various calculations.
 */
public class HealthLog {

	DecimalFormat format = new DecimalFormat("#.##");
	
	// Data values
	private int age;
	private int height;
	private double weight;
	public static enum gender {
		MALE,
		FEMALE
	}
	public static enum activityType {
		RUNNING,
		WALKING
	}
	public static enum BMIClassification {
		UNDERWEIGHT,
		NORMAL,
		OVERWEIGHT,
		OBESE
	}
	private double speed;
	private int workoutTimeMinutes;

	private activityType typeOfActivity;
	private gender gen;

	// Class constructor
	public HealthLog(int age, double weight, int height, gender gen, activityType typeOfActivity, double speed, int workoutTimeMinutes) {
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.gen = gen;
		this.setTypeOfActivity(typeOfActivity);
		this.speed = speed;
		this.workoutTimeMinutes = workoutTimeMinutes;
	}

	// Get calorie needs to maintain a weight
	public double calculateBaseCalorieNeedsToMaintainWeight() {

		if(gen == gender.MALE) {
			// 66.5 + (13.75 x weight in kg) + (5.003 x height in cm) - (6.775 x age)
			return Double.parseDouble(format.format(66.5 + (13.75 * Utilities.poundsTokilograms(weight)) + (5.003 * Utilities.inchesToCentimeters(height)) - (6.775 * age)));
		}
		else if(gen == gender.FEMALE) {
			return Double.parseDouble(format.format(655.1 + (9.563 * Utilities.poundsTokilograms(weight)) + (1.850 * Utilities.inchesToCentimeters(height)) - (4.676 * age)));
		}

		return 0;
	}

	// Get body mass index
	public double calculateBMI() {
		return Double.parseDouble(format.format((703.0 * weight)/Math.pow(height, 2)));
	}

	// Get body mass index classification
	public BMIClassification calculateBMIClassification() {

		if(this.calculateBMI() < 18.5) {
			return BMIClassification.UNDERWEIGHT;
		}
		else if(this.calculateBMI() > 18.5 && this.calculateBMI() < 24.99) {
			return BMIClassification.NORMAL;
		}
		else if(this.calculateBMI() > 25.0 && this.calculateBMI() < 29.99) {
			return BMIClassification.OVERWEIGHT;
		}
		else if(this.calculateBMI() > 30.0) {
			return BMIClassification.OBESE;
		}
		return null;
	}

	// Get body mass index classification
	public double calculateCaloriesBurned() {

		if(typeOfActivity == activityType.WALKING)
			return Double.parseDouble(format.format((weight * 0.53 * Utilities.getDistance(workoutTimeMinutes, speed))));
		else if(typeOfActivity == activityType.RUNNING)
			return Double.parseDouble(format.format((weight * 0.75 * Utilities.getDistance(workoutTimeMinutes, speed))));
		return -1;
		
	}

	// Error checking

	// Check if weight is valid
	public static boolean isWeightValid(HealthLog health) {
		if(health.getWeight() > 20 && health.getWeight() < 400)
			return true;
		return false;
	}

	// Check if height is valid
	public static boolean isHeightValid(HealthLog health) {
		if(health.getHeight() > 24 && health.getHeight() < 96)
			return true;
		return false;
	}

	// Check if age is valid
	public static boolean isAgeValid(HealthLog health) {
		if(health.getAge() > 1 && health.getAge() < 112)
			return true;
		return false;
	}

	// Check if walking/running speed is valid
	public static boolean isWorkoutPaceValid(HealthLog health) {
		if(health.getSpeed() > 0 && health.getSpeed() < 35)
			return true;
		return false;
	}

	// Check if workout time is valid
	public static boolean isWorkoutDurationValid(HealthLog health) {
		if(health.getWorkoutTimeMinutes() > 0 && health.getWorkoutTimeMinutes() < 240)
			return true;
		return false;
	}

	// Get minimum target heart rate
	public int minTargetHeartRate() {
		return (int) ((217 - (0.85 * age)) * 0.60);
	}

	// Get maximum target heart rate
	public int maxTargetHeartRate() {
		return (int) ((217 - (0.85 * age)) * 0.80);
	}


	// Variable getters and setters
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public gender getGender() {
		return gen;
	}


	public void setGender(gender gen) {
		this.gen = gen;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public int getWorkoutTimeMinutes() {
		return workoutTimeMinutes;
	}


	public void setWorkoutTimeMinutes(int workoutTimeMinutes) {
		this.workoutTimeMinutes = workoutTimeMinutes;
	}



	public activityType getTypeOfActivity() {
		return typeOfActivity;
	}



	public void setTypeOfActivity(activityType typeOfActivity) {
		this.typeOfActivity = typeOfActivity;
	}

}
