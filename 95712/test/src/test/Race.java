package test;

public class Race {
	static int raceDistance = 100000000;
	static volatile boolean raceOverFlag = false;
	public static void main(String[] args) {
		Thread hareThread = new Thread(new Hare(10, 10));
		Thread tortoiseThraed = new Thread(new Tortoise());
		
		tortoiseThraed.setPriority(Thread.MIN_PRIORITY);
		hareThread.setPriority(Thread.MAX_PRIORITY);
		hareThread.setName("Hare");
		tortoiseThraed.setName("tortoise");
		
		hareThread.start();
		tortoiseThraed.start();
		
	}
}
class Hare implements Runnable{
	int napTime;
	int speed;
	static int step;
	public Hare(int napTime, int speed) {
		this.napTime = napTime;
		this.speed = speed;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		Race.raceDistance;
		step = 0;
		while(step < Race.raceDistance && !Race.raceOverFlag) {
			if (step > 0 && step / 100 * speed == 0) {
				try {
					Thread.sleep(napTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			step += speed;
		}
		if(Race.raceOverFlag) {
			return;
		}
		Race.raceOverFlag = true;
		System.out.println("Hare win");
		System.out.printf("hare at %d, tortoise at %d\n", Hare.step, Tortoise.step);
		
		
	}
}

class Tortoise implements Runnable{
	static int step;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		step = 0;
		while (step < Race.raceDistance && !Race.raceOverFlag) {
			step++;
		}
		if(Race.raceOverFlag) {
			return;
		}
		Race.raceOverFlag = true;
		System.out.println("Tortoise win");
		System.out.printf("hare at %d, tortoise at %d\n", Hare.step, Tortoise.step);
	}
}