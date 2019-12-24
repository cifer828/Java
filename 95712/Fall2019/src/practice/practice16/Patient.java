package practice.practice16;

public class Patient {
	static int count;
	long startTime;
	long endTime;
	int id;
	public Patient() {
		// TODO Auto-generated constructor stub
		this.id = ++count;
		startTime = System.currentTimeMillis();
	}
}
