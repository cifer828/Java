package shoppingCart;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemInCart {
	StringProperty name = new SimpleStringProperty();
	DoubleProperty quantity = new SimpleDoubleProperty();
	
	public ItemInCart() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemInCart(String name, double quantity) {
		this.name.set(name);
		this.quantity.set(quantity);
	}
	
	public String getName() {
		return this.name.get();
	}
	
	public double getQuantity() {
		return this.quantity.get();
		
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public void setQuantity(double quantity) {
		this.quantity.set(quantity);
	}
	
}
