package practice.practice8;

public class IceCream extends Food{
	private final static int ICECREAM_CALORIES = 500;
	public IceCream() {
		// add calories
		Food.calories += ICECREAM_CALORIES;
		System.out.println("Serving Ice Ceam");
	}
	
	@Override
	public String eat() {
		return "Slurp Slurp";
	}
}
