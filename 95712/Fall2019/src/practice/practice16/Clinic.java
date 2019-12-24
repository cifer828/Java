package practice.practice16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Clinic implements Runnable{
	static Queue<Patient> patientQ = new LinkedList<>();;
	int patientCount;
	long clinicOpenTime;
	int maxPatientArrivalGap;
	
	public Clinic(int maxPatientArrivalGap) {
		this.maxPatientArrivalGap = maxPatientArrivalGap;
	}
	
	@Override
	public void run() {
		clinicOpenTime = System.currentTimeMillis();
		Random rand = new Random();
		
		for (; patientCount < ClinicManager.maxPatientCount; patientCount++) {
			try {
				
				synchronized (patientQ) {
					patientQ.offer(new Patient());
				}
				
				Thread.sleep(rand.nextInt(maxPatientArrivalGap));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
