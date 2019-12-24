// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab9;

import java.util.Scanner;

public class MovieHall {
	int ticketProcessingTime; //time taken by TicketWindow to process each ticket 
	int customerDelay; //time between customer arrivals
	static int maxSeats;  //max number of tickets that can be sold
	static boolean hasImpatientCustomers;  //flag to indicate part 1 or part 2 
	QueueManager queueManager;  //manages customers entering the queue
	TicketWindow ticketWindow;  //issues tickets to customers
	long saleTime;  //time for which the TicketWindow remains open

	public static void main(String[] args) {
		MovieHall movieHall = new MovieHall();
		movieHall.getInputs();
		movieHall.startThreads();
		movieHall.printOutputs();
	}

	//do not change this method
	//getInputs() initializes hasImpatientCustomers, ticketProcessingTime,
	//maxSeats, and customerDelay
	void getInputs() {
		Scanner input = new Scanner(System.in);
		System.out.println("********* Welcome to the Movie Hall ************");
		System.out.println("Want to handle impatient customers?");
		char response = input.next().charAt(0);
		if (response == 'y') hasImpatientCustomers = true;  
		System.out.println("Enter single ticket processing time");
		ticketProcessingTime = input.nextInt();
		System.out.println("Enter max seats in the hall");
		maxSeats = input.nextInt();
		System.out.println("Enter max customer delay");
		customerDelay = input.nextInt();
		input.close();
	}


	//startThreads() creates threads for QueueManager and TicketWindow, 
	//starts them, waits for them to join, and updates elapsed saleTime. 
	void startThreads() {
		queueManager = new QueueManager(customerDelay);
		ticketWindow = new TicketWindow(ticketProcessingTime);
		Thread t1 = new Thread(queueManager);
		Thread t2 = new Thread(ticketWindow);
		long startTime = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		saleTime = endTime - startTime;
	}

	//do not change this method
	//printOutputs() prints the output as shown in the handout 
	void printOutputs() {
		System.out.println("--------------------------------------------------------");
		System.out.println("Ticket window open duration:\t\t" + saleTime + " ms");
		System.out.println("Total customers: \t\t\t" + Customer.totalCustomerCount);
		System.out.println("Customers in queue after window closed:\t" + QueueManager.queue.size());
		System.out.println("Total tickets sold: \t\t\t" + ticketWindow.totalTicketsSold);
		System.out.println("--------------------------------------------------------");
		System.out.println("Customers who bought tickets:\t\t" + ticketWindow.customersServed);
		if (hasImpatientCustomers) {
			System.out.println("Customers who balked: \t\t\t" + queueManager.balkCount);
			System.out.println("Impatient customer count:\t\t" + ImpatientCustomer.impatientCustomerCount);
		}
		System.out.println("--------------------------------------------------------");
		int count = 0;
		System.out.println("Customer queue");
		if (QueueManager.queue.size() > 0) {
			for (Customer c: QueueManager.queue) {
				System.out.printf("%3d. %s %d needed %d tickets%n", ++count, c.getClass().getSimpleName(), c.id, c.ticketCount);
			}
		} else System.out.println("No customers in queue");
	}
}
