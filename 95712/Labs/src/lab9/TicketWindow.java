// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package lab9;

public class TicketWindow implements Runnable{
	int totalTicketsSold;
	int ticketProcessingTime;
	int customersServed;
	static volatile boolean isClosed;
	final static int MAX_TICKETS = 10;
	
	public TicketWindow(int ticketProcessingTime) {
		this.ticketProcessingTime = ticketProcessingTime;
	}
	
	@Override
	public void run() {
		while(!isClosed) {
			Customer customer = null;
			synchronized (QueueManager.queue) {
				customer = QueueManager.queue.poll();
			}
			// no customer in the queue
			if (customer == null)
				continue;
			
			System.out.printf("\t\t%s %d buying %d tickets\n", customer.getClass().getSimpleName(), customer.id, customer.ticketCount);
			
			try {
				Thread.sleep(customer.ticketCount * ticketProcessingTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customersServed++;
			totalTicketsSold += customer.ticketCount;
			if (totalTicketsSold >= MovieHall.maxSeats)
				isClosed = true;
		}
		
		
	}
}

