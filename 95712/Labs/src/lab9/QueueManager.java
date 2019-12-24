// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueManager implements Runnable{
	static Queue<Customer> queue;
	int customerDelay;
	int balkCount;
	
	public QueueManager(int customerDelay) {
		this.customerDelay = customerDelay;
		queue = new LinkedList<>();
	}

	@Override
	public void run() {
		Random randDelay = new Random();
		Random randCustomer = new Random();
		
		while(!TicketWindow.isClosed) {
			Customer customer;
			
			// half customers are regular and half are impatient
			if (MovieHall.hasImpatientCustomers)
				if (randCustomer.nextInt(2) == 0)
					customer = new Customer();
				else
					customer = new ImpatientCustomer();
			else
				customer = new Customer();
			
			
			int delay = randDelay.nextInt(customerDelay + 1);
			
			// customer arrive at random intervals
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// lock the queue
			synchronized (QueueManager.queue) {
//				System.out.println(QueueManager.queue.size());
				if(customer.joinQueue())
						System.out.printf("%s %d joined\n", customer.getClass().getSimpleName(), customer.id);
				else {
					System.out.printf("%s %d balked\n", customer.getClass().getSimpleName(), customer.id);
					balkCount++;
				}
			}
		}
		System.out.println("*** All sold out. Ticket window now closed!! ***");

		
	}
}
