/**
 * Class for modeling a vehicle at an intersection
 * 
 * @author Richard Nader
 */
public class Vehicle {

	// Enumerator type for direction stopped at intersection
	public static enum IntersectionDirection {
		N, S, E, W
	};

	// Variables for vehicle
	private IntersectionDirection direction;
	private int arrivalTime;

	public Vehicle(IntersectionDirection direction, int arrivalTime) {
		this.direction = direction;
		this.arrivalTime = arrivalTime;
	}

	// Getters and setters

	public IntersectionDirection getDirection() {
		return direction;
	}

	public String getDirectionString() {
		switch (direction) {

		case N:
			return "North";
		case S:
			return "South";
		case E:
			return "East";
		case W:
			return "West";
		default:
			return "null";
		}
	}

	public void setDirection(IntersectionDirection direction) {
		this.direction = direction;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "Vehicle [direction=" + direction + ", arrivalTime=" + arrivalTime + "]";
	}

}
