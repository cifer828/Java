package practice.practice9;

import java.util.Random;

class Diner {
	private final static int [] PRICE = {2, 3, 5, 7, 4}; 
	private int income = 0;
	public static void main(String[] args) {
		Diner diner = new Diner();
		Kitchen kitchen = new Kitchen();
		diner.runDiner(kitchen);
		diner.printReport(kitchen);
	}
	void runDiner(Kitchen kitchen) {
		Random rand = new Random();
		Guest guest;
		// here comes a guest randomly
		while (kitchen.checkStock()) {
			switch (rand.nextInt(4)) {
			case Guest.FAMILYNUM:
				guest = new Family();
				break;
			case Guest.COUPLENUM:
				guest = new Couple();
				break;
			case Guest.INDIVIDUALNUM:
				guest = new Individual();
				break;
			case Guest.GROUPNUM:
				guest = new Group();
				break;
			default:
				guest = null;
			}
			guest.placeOrder();
			kitchen.updateStock(guest);
			income += calculateBill(guest);
		}
	}
	int calculateBill(Guest g){
		// calculate one guest bill
		int bill = 0;
		for (int i = 0; i < PRICE.length; i++)
			bill += PRICE[i] * g.servings[i];
		return bill;
	}
	void printReport(Kitchen kitchen) {
		System.out.printf("******* Total income for the day: $%,d *********\n", income);
		System.out.println("** Guest type count **");
		Guest.printCount(Guest.FAMILYNUM, Family.familyCount);
		Guest.printCount(Guest.COUPLENUM, Couple.coupleCount);
		Guest.printCount(Guest.INDIVIDUALNUM, Individual.individualCount);
		Guest.printCount(Guest.GROUPNUM, Group.groupCount);
		System.out.printf("\n******** Total number of orders: %d *********\n", Guest.guestCount) ;
		System.out.println("** Closing stock **\n");
		kitchen.printStock();
	}
}
