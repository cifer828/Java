// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package finals;

public class ImpatientVehicle extends Vehicle{
	final static int Q_TOO_LONG_LENGTH = 5;
	
	@Override
	boolean joinVehicleQ() {
		// don't join the vehicleQ if it's longer or equal to some length
		if (Road.vehicleQ.size() >= Q_TOO_LONG_LENGTH)
			return false;
		else
			return super.joinVehicleQ();
	}
}
