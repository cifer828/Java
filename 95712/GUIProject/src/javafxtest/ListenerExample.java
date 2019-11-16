package javafxtest;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ListenerExample {
	public static void main(String[] args) {
		IntegerProperty squareSide = new SimpleIntegerProperty();
		IntegerBinding squareAreaBinding = new IntegerBinding() {
			{
				super.bind(squareSide);
			}
			@Override
			protected int computeValue() {

				return squareSide.get() * squareSide.get();
			}
		};
		
		// invalidation listener to print squareArea invalid!
		squareAreaBinding.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable arg0) {
				System.out.println("SquareArea Invalid!");
			}
		});
		
		
		//changeListener to print squareArea's doubleValue
		squareAreaBinding.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println("Square area: " + squareAreaBinding.doubleValue());
			}
		});
		
		// set squareSide value to 10
		squareSide.set(10);
		squareSide.set(20);
		squareSide.set(30);
		squareSide.set(40);
	}
	
}
