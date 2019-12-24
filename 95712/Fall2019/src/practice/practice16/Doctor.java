package practice.practice16;

public class Doctor implements Runnable{
	int consultationTime;
	
	public Doctor(int consultationTime) {
		this.consultationTime = consultationTime;
	}
	
	@Override
	public void run() {
		int patientConsulted = 0;
		while(patientConsulted < ClinicManager.maxPatientCount) {
			Patient patient;
			synchronized (Clinic.patientQ) {
				patient = Clinic.patientQ.poll();
			}
			if (patient != null) {
				System.out.printf("Consulting patient %d\n", patient.id);
				try {
					Thread.sleep(consultationTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				patient.endTime = System.currentTimeMillis();
				ClinicManager.patientWaitTime += patient.endTime - patient.startTime;
				patientConsulted++;
			}
		}
		
	}

}
