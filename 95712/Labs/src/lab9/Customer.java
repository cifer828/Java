// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab9;

import java.util.Random;

public class Customer {
	int id;
	int ticketCount;
	static int totalCustomerCount;
	
	public Customer() {
		this.id = ++totalCustomerCount;
		Random rand = new Random();
		this.ticketCount = rand.nextInt(TicketWindow.MAX_TICKETS) + 1;
	}
	
	boolean joinQueue() {
		QueueManager.queue.offer(this);
		return true;
	}
}
