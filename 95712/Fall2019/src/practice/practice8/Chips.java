package practice.practice8;

public class Chips extends Food{
	private static final int CHIPS_CALORIES = 200;

	/**Chips() increments calories by CHIPS_CALORIES
	 * It then prints the message "Serving Chips"
	 */
	public Chips() {
		calories += CHIPS_CALORIES;
		System.out.println("Serving Chips");
	}

	/**eat() method returns the 
	 * String "crunch crunch"
	 */
	public String eat() {
		return "Crunch Crunch";
	}
}

