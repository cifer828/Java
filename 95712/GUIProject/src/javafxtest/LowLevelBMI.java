package javafxtest;

import java.util.Scanner;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class LowLevelBMI {
	DoubleProperty weight = new SimpleDoubleProperty();
	DoubleProperty height = new SimpleDoubleProperty();
	DoubleBinding bmi = new DoubleBinding() {
		{
			super.bind(weight, height);
		}
		@Override
		protected double computeValue() {
			// TODO Auto-generated method stub
			return weight.get() * 703 / height.get() / height.get();
		}
	};
	
	void calcBMI() {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i <= 1; i++) {
			System.out.println("Enter weight in pounds");
			weight.set(input.nextInt());
			System.out.println("Enter weight in inches");
			height.set(input.nextInt());
			System.out.println("BMI = " + bmi.doubleValue());
			System.out.println("************");
		}
		input.close();
		
	}
	
	
	public static void main(String[] args) {
		LowLevelBMI lowLevelBMI = new LowLevelBMI();
		lowLevelBMI.calcBMI();
	}
}
