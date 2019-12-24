// Name: Qiuchen Zhang
// AndrewID: qiuchenz


package finals;

public class Vehicle {
	static int vehicleCount;
	int id;
	
	public Vehicle() {
		id = ++vehicleCount;
		System.out.println("Class Vehicle " + id);
	}
	
	boolean joinVehicleQ() {
		// normal vehicle always joins the vechileQ
		Road.vehicleQ.offer(this);
		return true;
	}
}
