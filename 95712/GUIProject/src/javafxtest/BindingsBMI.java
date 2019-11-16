package javafxtest;

import java.util.Scanner;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class BindingsBMI {
	DoubleProperty weight = new SimpleDoubleProperty();
	DoubleProperty height = new SimpleDoubleProperty();
	// both ways of calculation are allowed
	NumberBinding bmi = Bindings.divide(weight.multiply(703), Bindings.multiply(height, height)); 
	
	void calcBMI(){

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
		BindingsBMI bindingsBMI = new BindingsBMI();
		bindingsBMI.calcBMI();
	}
}
