package practice.practice9;

abstract class Guest {
	final static int FAMILYNUM = 0;
	final static int COUPLENUM = 1;
	final static int INDIVIDUALNUM = 2;
	final static int GROUPNUM = 3;
	private static  String[] guest = {"Family", "Couple", "Individual", "Group"};
	static int guestCount;
	int [] servings;
	String guestType;
	Guest() {
		guestCount++;
	}
	abstract void placeOrder();
	static void printCount(int type, int count) {
		System.out.println(guest[type] + ": " + count);
	}
}
