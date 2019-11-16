package javafxtest;

import java.util.Scanner;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class FluentBMI {
	DoubleProperty weight = new SimpleDoubleProperty();
	DoubleProperty height = new SimpleDoubleProperty();
	DoubleProperty bmi = new SimpleDoubleProperty();
	
	void calcBMI() {
		bmi.bind(weight.multiply(703).divide(height.multiply(height)));
		
		Scanner input = new Scanner(System.in);
		for (int i = 0; i <= 1; i++) {
			System.out.println("Enter weight in pounds");
			weight.set(input.nextInt());
			System.out.println("Enter weight in inches");
			height.set(input.nextInt());
			System.out.println("BMI = " + bmi.get());
			System.out.println("************");
		}
		input.close();
	}
	
	public static void main(String[] args) {
		FluentBMI fluentBMI = new FluentBMI();
		fluentBMI.calcBMI();
	}
}
