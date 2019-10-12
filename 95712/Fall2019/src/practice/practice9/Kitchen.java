package practice.practice9;

class Kitchen {
	private int [] stock;
	final static String [] ITEMS = {"Drink", "Soup", "Salad", "Entree", "Dessert"};
	Kitchen() {
		stock = new int[] {120, 75, 75, 120, 65};
	}
	void updateStock(Guest g) {
		for(int i = 0; i < stock.length; i++)
			stock[i] -= g.servings[i];
	}
	boolean checkStock(){
		for(int s: stock) {
			if (s <= 4)
				return false; // out of stock
		}
		return true;
	}
	void printStock() {
		for (int i = 0; i < ITEMS.length; i++)
			System.out.println(ITEMS[i] + ": " + stock[i]);
	}
}
