// Name: Qiuchen Zhang
// AndrewID: qiuchenz


package finals;

public class TrafficLight implements Runnable{
	final static int TRAFFIC_LIGHT_DELAY = 500;
	static volatile boolean isGreen = true;  // green at first
	
	@Override
	public void run() {
		while (Vehicle.vehicleCount < Road.maxVehicles) {
			
			// change the traffic light every TRAFFIC_LIGHT_DELAY ms
			try {
				Thread.sleep(TRAFFIC_LIGHT_DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("!!!!light changed");
			isGreen = !isGreen; 
		}
	}
	
}
