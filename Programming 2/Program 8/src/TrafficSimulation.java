import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * http://websites.delta.edu/teklingl/cs2/programs/program08.html
 * 
 * Main class for running the traffic simulation
 * 
 * @author Richard Nader
 */
public class TrafficSimulation {

	// Time light stays green in minutes
	final int GREEN_TIME_MINUTES = 4;
	final int YELLOW_TIME_SECONDS = 3;

	// To track light states
	public enum LightState {
		RED, YELLOW, GREEN
	};

	// Random Object
	Random random = new Random();

	// Queues
	LinkedQueue<Vehicle> nQueue = new LinkedQueue<>(); // North queue
	LinkedQueue<Vehicle> sQueue = new LinkedQueue<>(); // South queue
	LinkedQueue<Vehicle> eQueue = new LinkedQueue<>(); // East queue
	LinkedQueue<Vehicle> wQueue = new LinkedQueue<>(); // West queue

	// Queue arrival rates
	final double N_ARRIVAL_RATE = 1.0 / 2.0;
	final double S_ARRIVAL_RATE = 1.0 / 2.0;
	final double E_ARRIVAL_RATE = 1.0 / 2.0;
	final double W_ARRIVAL_RATE = 1.0 / 2.0;

	// Light states
	LightState NS_LightState;
	LightState EW_LightState;

	// Timing
	final int SIM_TIME_HOURS = 10; // Set simulation time in hours

	final int SIM_TIME_MINUTES = SIM_TIME_HOURS * 60;
	final int SIM_TIME_SECONDS = SIM_TIME_MINUTES * 60;
	int time = 0; // Simulation clock in seconds.

	final int TIME_THOUGH_LIGHT = 2; // Time for a vehicle to get through the light.

	// Timings based on time of day in minutes
	// M = Morning, A = Afternoon, N = Night
	// Morning (First 2 hours)
	final int NS_M_TRAFFIC_SECONDS = 4;
	final int EW_M_TRAFFIC_SECONDS = 20;

	// Midday (Next 6 hours)
	final int NS_A_TRAFFIC_SECONDS = 8;
	final int EW_A_TRAFFIC_SECONDS = 15;

	// Night (Last 2 hours)
	final int NS_N_TRAFFIC_SECONDS = 4;
	final int EW_N_TRAFFIC_SECONDS = 20;

	// Track current traffic rate/load
	int NS_CurrentTrafficLoad;
	int EW_CurrentTrafficLoad;

	// Totals
	int totalVehiclesEnqueued = 0;
	int totalVehiclesDnqueued = 0;
	int totalWaitTime = 0;

	// Constructor
	public TrafficSimulation() {
		// ------- Setup -------

		// Setup start light state
		boolean beginState = random.nextBoolean();
		if (beginState) {
			NS_LightState = LightState.GREEN;
			EW_LightState = LightState.RED;
		} else {
			NS_LightState = LightState.RED;
			EW_LightState = LightState.GREEN;
		}

		// Run Simulation
		runSimulation();
	}

	private void runSimulation() {
		// Main loop every minute
		for (time = 0; time <= SIM_TIME_SECONDS; time++) {
			setTrafficLoad(); // Update traffic load
			tickVehicleEnqueue(); // Enqueue new vehicles
			tickTrafficLightCycle(); // Change traffic lights and dequeue vehicles
		}

		JOptionPane.showMessageDialog(null, buildString());

	}

	// Method for changing the light based on times
	int 
	NS_GreenStartTime = 0,
	NS_YellowStartTime = 0,
	NS_RedStartTime = 0,
	EW_GreenStartTime = 0,
	EW_YellowStartTime = 0,
	EW_RedStartTime = 0;

	int lastVehicleTime = 0;
	private void tickTrafficLightCycle() {

		if (NS_LightState == LightState.GREEN) {
			
			// If it has passed the time to get through the light
			if (simulationCurrentSeconds() - lastVehicleTime >= TIME_THOUGH_LIGHT) {

				if (!nQueue.isEmpty()) {
					totalWaitTime += simulationCurrentSeconds() - nQueue.dequeue().getArrivalTime();
					totalVehiclesDnqueued++;
				}

				if (!sQueue.isEmpty()) {
					totalWaitTime += simulationCurrentSeconds() - sQueue.dequeue().getArrivalTime();
					totalVehiclesDnqueued++;
				}

				lastVehicleTime = simulationCurrentSeconds();
			}

			// If it has been green light interval change the light
			if (simulationCurrentSeconds() - NS_GreenStartTime >= (GREEN_TIME_MINUTES * 60)) {
				NS_LightState = LightState.YELLOW;
				NS_YellowStartTime = simulationCurrentSeconds();
			}

			// Change yellow light after time
		} else if (NS_LightState == LightState.YELLOW) {
			
			if (simulationCurrentSeconds() - NS_YellowStartTime >= YELLOW_TIME_SECONDS) {
				NS_LightState = LightState.RED;
				EW_LightState = LightState.GREEN;
				NS_RedStartTime = simulationCurrentSeconds();
			}

			// Repeat above for E and W lights
		} else if (EW_LightState == LightState.GREEN) {
			
			if (simulationCurrentSeconds() - lastVehicleTime >= TIME_THOUGH_LIGHT) {
				if (!eQueue.isEmpty()) {
					totalWaitTime += simulationCurrentSeconds() - eQueue.dequeue().getArrivalTime();
					totalVehiclesDnqueued++;
				}

				if (!wQueue.isEmpty()) {
					totalWaitTime += simulationCurrentSeconds() - wQueue.dequeue().getArrivalTime();
					totalVehiclesDnqueued++;
				}
				lastVehicleTime = simulationCurrentSeconds();
			}
			
			if (simulationCurrentSeconds() - EW_GreenStartTime >= (GREEN_TIME_MINUTES * 60)) {
				EW_LightState = LightState.YELLOW;
				EW_YellowStartTime = simulationCurrentSeconds();
			}
			
			
		} else if (EW_LightState == LightState.YELLOW) {
			
			if (simulationCurrentSeconds() - EW_YellowStartTime >= YELLOW_TIME_SECONDS) {
				EW_LightState = LightState.RED;
				NS_LightState = LightState.GREEN;
				NS_RedStartTime = simulationCurrentSeconds();
			}
			
		}

	}

	// Method for adding vehicles to queue randomly
	int lastNorthQueueTime = 0, lastSouthQueueTime = 0, lastEastQueueTime = 0, lastWestQueueTime = 0;
	private void tickVehicleEnqueue() {
		// North Queue
		if (simulationCurrentSeconds() - lastNorthQueueTime >= NS_CurrentTrafficLoad) {

			// Random enqueue
			if (random.nextDouble() <= N_ARRIVAL_RATE) {
				Vehicle newVehicle = new Vehicle(Vehicle.IntersectionDirection.N, simulationCurrentSeconds());
				nQueue.enqueue(newVehicle);
				totalVehiclesEnqueued++;
			}
			
			// Keep track of last time
			lastNorthQueueTime = simulationCurrentSeconds();
		}

		// South Queue
		if (simulationCurrentSeconds() - lastSouthQueueTime >= NS_CurrentTrafficLoad) {

			// Random enqueue
			if (random.nextDouble() <= S_ARRIVAL_RATE) {
				Vehicle newVehicle = new Vehicle(Vehicle.IntersectionDirection.S, simulationCurrentSeconds());
				sQueue.enqueue(newVehicle);
				totalVehiclesEnqueued++;
			}

			lastSouthQueueTime = simulationCurrentSeconds();
		}

		// East Queue
		if (simulationCurrentSeconds() - lastEastQueueTime >= EW_CurrentTrafficLoad) {

			// Random enqueue
			if (random.nextDouble() <= E_ARRIVAL_RATE) {
				Vehicle newVehicle = new Vehicle(Vehicle.IntersectionDirection.E, simulationCurrentSeconds());
				eQueue.enqueue(newVehicle);
				totalVehiclesEnqueued++;
			}

			lastEastQueueTime = simulationCurrentSeconds();
		}

		// West Queue
		if (simulationCurrentSeconds() - lastWestQueueTime >= EW_CurrentTrafficLoad) {

			// Random enqueue
			if (random.nextDouble() <= W_ARRIVAL_RATE) {
				Vehicle newVehicle = new Vehicle(Vehicle.IntersectionDirection.W, simulationCurrentSeconds());
				wQueue.enqueue(newVehicle);
				totalVehiclesEnqueued++;
			}

			lastWestQueueTime = simulationCurrentSeconds();
		}

	}

	// Method to set traffic loads
	private void setTrafficLoad() {
		if (simulationCurrentHours() <= 2) {
			NS_CurrentTrafficLoad = NS_M_TRAFFIC_SECONDS;
			EW_CurrentTrafficLoad = EW_M_TRAFFIC_SECONDS;
		} else if (simulationCurrentHours() > 2 && simulationCurrentHours() <= 6) {
			NS_CurrentTrafficLoad = NS_A_TRAFFIC_SECONDS;
			EW_CurrentTrafficLoad = EW_A_TRAFFIC_SECONDS;
		} else if (simulationCurrentHours() > 6) {
			NS_CurrentTrafficLoad = NS_N_TRAFFIC_SECONDS;
			EW_CurrentTrafficLoad = EW_N_TRAFFIC_SECONDS;
		}
	}

	// Build output String
	private String buildString() {
		String outputString = "";
		
		DecimalFormat decimal = new DecimalFormat("#.##");
		String avgString = "";

		double avgWaitTime = ((double) totalWaitTime / (double) totalVehiclesDnqueued);

		if (avgWaitTime / 60.0 >= 1) {
			avgWaitTime /= 60;
			avgString = decimal.format(avgWaitTime) + " minutes\n";
		} else {
			avgString = decimal.format(avgWaitTime) + " seconds\n";
		}
		

		outputString += "Simulation time: " + SIM_TIME_HOURS + " hours \n";
		outputString += "Green Light/Red Light Time: " + GREEN_TIME_MINUTES + " minutes\n";
		outputString += "Yellow Light Time: " + YELLOW_TIME_SECONDS + " seconds\n";
		outputString += "Through Light Time: " + TIME_THOUGH_LIGHT + " seconds\n";
		outputString += "Total Vehicles Queued: " + totalVehiclesEnqueued + "\n";
		outputString += "Total Vehicles Passed through light: " + totalVehiclesDnqueued + "\n";
		outputString += "Average wait time: " + avgString;
		
		return outputString;
	}

	// Method to get time in seconds
	private int simulationCurrentSeconds() {
		return time;
	}

	// Method to get time in minutes
	private int simulationCurrentMinutes() {
		return simulationCurrentSeconds() / 60;
	}

	// Method to get time in hours
	private int simulationCurrentHours() {
		return simulationCurrentMinutes() / 60;
	}

	// Main runnable
	public static void main(String[] args) {
		new TrafficSimulation();
	}

}
