package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

class Item {
	protected String itemName;
	protected int qty;
	protected float unitPrice;
	protected String unit;
//	protected float price;
}
public class Grocer {
	private Item[] readFile() {
		Scanner input = null;
		List<Item> items = new ArrayList<>();
		try {
			input = new Scanner(new File("Groceries.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(input.hasNextLine()) {
			Item i = new Item();
			String [] temp = input.nextLine().split(",");
			i.itemName = temp[0].trim();
			i.qty = Integer.parseInt(temp[1].trim());
			i.unit = temp[2].trim();
			i.unitPrice = Float.parseFloat(temp[3].trim());
//			i.price = i.qty * i.unitPrice;
			items.add(i);
		}
//		System.out.println(items.get(0).itemName);
		return items.toArray(new Item[items.size()]);
	}
	private void generateBill(Item[] items) {
		int count = 0;
		float total = 0;
//		System.out.println(items[0].itemName);
		System.out.println("#\tItem\t\tQty\tUnit\t\tUnit price\tTotal price");
		System.out.println("---------------------------------------------------------------------------------");
		for (Item item: items) {
			float totalPrice = item.qty * item.unitPrice;
			System.out.printf("%-8d%-16s%-8d%-16s$%-16.2f$%-16.2f%n", ++count, item.itemName, item.qty, item.unit,
					item.unitPrice, totalPrice);
			total += totalPrice;
		}
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Total amount: $%.2f\n", total);
		System.out.println("---------------------------------------------------------------------------------");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grocer g = new Grocer();
		g.generateBill(g.readFile());

	}

}
