package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QSeater implements Runnable {
	static Queue<Person2> personQ = new LinkedList<>();
	static int maxPersons, sitTime; 
	int queuedCount, delay ;

	@Override
	public void run() {
		while (queuedCount < maxPersons)
			try {
				synchronized (personQ) {
					personQ.offer(new Person2());
					queuedCount++;
				}
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		QSeater qs = new QSeater();
		Scanner input = new Scanner (System.in); 
		System.out.println("How many persons to seat?");
		maxPersons = input.nextInt();
		System.out.println("Enter delay (ms)");
		qs.delay = input.nextInt();
		System.out.println("How long to sit (ms)?");
		sitTime = input.nextInt();
		input.close();
		Thread t1 = new Thread(qs);
		Thread t2 = new Thread(new HotSeat()); 
		long startTime = System.currentTimeMillis();
		t1.start();
		t2.start();

		try {
			t1.join();	//wait for thread to join back
			t2.join();	//wait for thread to join back
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.printf("Done in %d ms!", 
				(endTime - startTime));
	} //end main
} //end QSeater


class HotSeat implements Runnable{
	int seatedCount = 0;

	@Override
	public void run() {
		Person2 p;
		while (seatedCount < QSeater.maxPersons) {
			synchronized (QSeater.personQ) {
				p = QSeater.personQ.poll();	
			}
			if (p != null) {
				try {
					System.out.printf("Person %d sitting%n", p.id);
					Thread.sleep(QSeater.sitTime);
					System.out.printf("Person %d leaving%n", p.id);
					seatedCount++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Queue not ready");
			} //end if
		} //end while
	} //end run 
}

class Person2 {
	int id;
	static int count;

	Person2() {
		id = count++;
	}
}

