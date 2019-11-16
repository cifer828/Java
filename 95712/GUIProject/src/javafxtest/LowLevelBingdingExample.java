package javafxtest;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class LowLevelBingdingExample {
	IntegerProperty squareSide = new SimpleIntegerProperty();
	
	IntegerBinding squareArea = new IntegerBinding() {
		{
			super.bind(squareSide);
		}
		@Override
		protected int computeValue() {
			return squareSide.get() * squareSide.get();
		}
		
	};
}
