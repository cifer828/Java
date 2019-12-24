// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package finals;

import java.util.Random;

public class Traffic implements Runnable {
	final static int MIN_VEHICLE_DELAY = 10;
	final static int MAX_VEHICLE_DELAY = 100;
	static int maxQLength;
	static int exit_count; // number of exited impatientVehicles
	
	@Override
	public void run() {
		int delay;
		while(Vehicle.vehicleCount < Road.maxVehicles) {
			Random randDelay = new Random();
			Random randomVehicle = new Random();
			delay = randDelay.nextInt(MAX_VEHICLE_DELAY - MIN_VEHICLE_DELAY + 1) + 10; // generate delay
			
			Vehicle vechile;
			

			// lock the vehicleQ
			synchronized (Road.vehicleQ) {
				/* should be in the synchronized block because if it's out of the block, there may be a race condition that
				   -> create the last vehicle but don't enter synchronized block 
				   -> switch to the TrafficLight thread and traffic light change from green to red 
				   -> switch to the Road thread, but since Vehicle.vehicleCount == Road.maxVehicles, it won't enter the while loop and won't print the stream for this vehicle
				   -> switch back to Traffic thread and enter synchronized block, but since the light is green now, it won't print either
				   -> no print for the last vehicle, bad */
				// 1/4 vehicles are impatient
				if (Road.problemPart == 2) {
					if (randomVehicle.nextInt(100) < 25)
						vechile = new ImpatientVehicle();
					else
						vechile = new Vehicle();
				}
				else {
					vechile = new Vehicle();
				}
				
				/* should be in the synchronized block because joinVehicle() add new elements to the shared queue */
				// impatientVehicle exits
				if (!vechile.joinVehicleQ()) {
					String light = TrafficLight.isGreen ? "Green" : "RED"; 
					System.out.printf("********* %s: %s %d exiting. Q length %d\n", light, vechile.getClass().getSimpleName(), vechile.id, Road.vehicleQ.size());
					exit_count++;
					continue;
				}
				
				/* should be in the synchronized block because vehicleQ.size() visits the shared resource */
				// update maxQLength
				maxQLength = Math.max(maxQLength, Road.vehicleQ.size());
				
				// vehicle waits in vehicleQ
				if (!TrafficLight.isGreen) {
					System.out.printf("\tRED: %s %d in Q. Q length %d\n", vechile.getClass().getSimpleName(), vechile.id, Road.vehicleQ.size());
				}
			}
			
			// immediately exit if all vehicles have arrived
			// don't wait for next vehicle
			if (Vehicle.vehicleCount >= Road.maxVehicles)
				break;
			
			// wait for next vehicle
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
