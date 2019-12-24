package test;

class SubThread extends Thread{
	@Override	
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " running");
		}
	}
}


public class MyClass {
	public static void main(String[] args) {
//		SubThread st = new SubThread();
//		st.start();
//		for (int i = 0; i < 3; i++) {
//			System.out.println(Thread.currentThread().getName() + " running");
//		}
		
		SleepThread sleepThread = new SleepThread();
		sleepThread.start();
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " running");
		}
		sleepThread.interrupt();
		
	}

}

class SleepThread extends Thread{
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " running " + i);
			try {
				System.out.println("Going to sleep!" + i);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Sleep interrupted!");
			}
		}
	}
}

