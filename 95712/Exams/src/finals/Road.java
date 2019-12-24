// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package finals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Road implements Runnable{
	static Queue<Vehicle> vehicleQ = new LinkedList<>();
	static int maxVehicles;
	int vehiclesPassed;
	long startTime;
	long endTime;
	static int problemPart;
	
	public static void main(String[] args) {
		Road road = new Road();
		road.getInputs();
		long elapsedTime = road.startThreads(road);
		road.printReport(elapsedTime);
		
	}

	@Override
	public void run() {
		while(Vehicle.vehicleCount < Road.maxVehicles) {
			// let vehicles pass if light is green
			if (TrafficLight.isGreen) {
				
				// need a synchronized block because we visit shared resources by vehicleQ.size().
				synchronized (vehicleQ) {
					if (vehicleQ.size() != 0) {
						Vehicle vehicle = vehicleQ.poll();

						vehiclesPassed++;
						System.out.printf("Green: %s %d passed. Total vehicles passed: %d. Q length: %d\n",
								vehicle.getClass().getSimpleName(), vehicle.id, vehiclesPassed, vehicleQ.size());
					}
				}
				
			}
		}
	}
	
	// get inputs from users
	private void getInputs() {
		Scanner input = new Scanner(System.in);
		System.out.println("Part 1 or 2?");
		problemPart = input.nextInt();
		System.out.println("How many vehicles?");
		maxVehicles = input.nextInt();
		input.close();
	}
	
	// creates threads for Traffic and TrafficLight, start them and wait for them to join
	// returns elapsed time
	private long startThreads(Road road) {
		TrafficLight trafficLight = new TrafficLight();
		Traffic traffic = new Traffic();
		Thread lightThread = new Thread(trafficLight);
		Thread trafficThread = new Thread(traffic);
		Thread roadThread = new Thread(road);
		
		long startTime = System.currentTimeMillis();
		lightThread.start();
		trafficThread.start();
		roadThread.start();
		try {
			lightThread.join();
			trafficThread.join();
			roadThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	// print the report
	private void printReport(long elapsedTime) {
		System.out.println("-----------------TRAFFIC REPORT----------------");
		System.out.println("The program ran for " + elapsedTime + " ms");
		System.out.printf("Max Q length at traffic light was %d\n", Traffic.maxQLength);
		System.out.printf("Final Q length at traffic light was %d\n", vehicleQ.size());
		if (problemPart == 2) {
			System.out.printf("Vehicles passed: %d\n", vehiclesPassed);
			System.out.printf("Vehicles exited: %d\n", Traffic.exit_count);
		}
		
	}
	
}
