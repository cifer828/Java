package practice.practice8;

public class Pizza extends Food implements Heatable{
	private final static int PIZZA_CALORIES = 800;
	public Pizza() {
		Food.calories += PIZZA_CALORIES;
		System.out.println("Serving Pizza");
	}
	@Override
	public String eat() {
		return "Chomp Chomp";
	}

	@Override
	public void heatIt() {
		temperature = Heatable.HOTSERVINGTEMPERATURE;
		System.out.printf("Now its hot @ %d degrees\n", temperature);
	}

}
