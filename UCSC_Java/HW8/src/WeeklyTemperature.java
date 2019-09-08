import java.util.InputMismatchException;
import java.util.Scanner;

public class WeeklyTemperature {
	private int weeklyTemp[] = new int[7];
	private int maxTemp;
	private int minTemp;
	private float avgTemp;
	
	final String weekday[] = {"Monday", "Tuesday", "Wednsday", "Thursday", "Friday", "Saturday", "Sunday"};
	public void getTemperatures(){
		// ask user to enter 7 temperatures for the week
		Scanner getInput = new Scanner (System.in);
		 //this resource will be leaked, must close it
		int myDay;
		for (myDay = 0; myDay < this.weeklyTemp.length; myDay++){
			System.out.printf("The tempetatures on %s was :\t", this.weekday[myDay]);
			try
			{
				weeklyTemp[myDay] = getInput.nextInt();
			}
			catch(final InputMismatchException e){
				System.out.println("You entered an invalid temparature, please re-enter.");
				getInput.nextLine();
				myDay--;
			}
		}
		getInput.close();
		calTemp(); // calculate statistic
	}
	private void calTemp(){
		// calculate the statistic result of weekly temperature (include max, min, avg)
		this.minTemp = this.maxTemp = this.weeklyTemp[0];
		float total = 0;
		for (int myDay = 0; myDay < 7; myDay++) {
			this.maxTemp = this.maxTemp > this.weeklyTemp[myDay] ? this.maxTemp:this.weeklyTemp[myDay];
			this.minTemp = this.minTemp < this.weeklyTemp[myDay] ? this.minTemp:this.weeklyTemp[myDay];
			total += this.weeklyTemp[myDay];
		}
		this.avgTemp = total / this.weeklyTemp.length;
	}
	public void printTemperatures(){
		// print the 7 temperatures for the week
		for (int myDay = 0; myDay < this.weeklyTemp.length; myDay++){
			System.out.printf("The temperature on %s was %d degree\n", this.weekday[myDay], this.weeklyTemp[myDay]);
		}
	}
	public int getMax(){
		// return the max temperature 
		return this.maxTemp;
	}
	public int getMin(){
		// return the min temperature
		return this.minTemp;
	}
	public float getAverage(){
		// return the average temperature
		return this.avgTemp;
	}
	public void printStatistics(){
		//print min, max and avg temperature
		System.out.printf("The Maxixmum temperature is %d\n", getMax());
		System.out.printf("The Minimum temperature is %d\n", getMin());
		System.out.printf("The Average temperature is %.1f\n", getAverage());
	}
	public static void main(String[] args){
		WeeklyTemperature wt = new WeeklyTemperature();
		wt.getTemperatures();
		wt.printTemperatures();
		System.out.printf("getMax() method's output is %d\n", wt.getMax());
		System.out.printf("getMin() method's output is %d\n", wt.getMin());
		System.out.printf("getAverage() method's output is %.1f\n", wt.getAverage());
		System.out.println("------printStatistic() method's output------");
		wt.printStatistics();
	}
}
	
