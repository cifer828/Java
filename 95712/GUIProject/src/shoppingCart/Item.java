package shoppingCart;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
	private StringProperty name = new SimpleStringProperty();
	private StringProperty unit = new SimpleStringProperty();
	private DoubleProperty unitQuantity = new SimpleDoubleProperty();
	private DoubleProperty unitPrice = new SimpleDoubleProperty();
	
	public Item() {
		name.set("");
		unit.set("");
		unitQuantity.set(0);
		unitPrice.set(0);
	}
	
	public Item(String name, String unit, double quantity, double unitPrice) {
		this.name.set(name);
		this.unit.set(unit);
		this.unitQuantity.set(quantity);
		this.unitPrice .set(unitPrice);
	}
	
	public final String getName() {return name.get();}
	public final String getUnit() {return unit.get();}
	public final double getUnitQuantity() {return unitQuantity.get();}
	public final double getUnitPrice() {return unitPrice.get();}
	
	public final void setName(String name) {this.name.set(name);}
	public final void setUnit(String unit) {this.unit.set(unit);}
	public final void setUnitQuantity(double unitQuantity) {this.unitQuantity.set(unitQuantity);}
	public final void setUnitPrice(double unitPirce) {this.unitPrice.set(unitPirce);}
	
	public final StringProperty nameProperty() {return name;}
	public final StringProperty unitProperty() {return unit;}
	public final DoubleProperty unitQuantityProperty() {return unitQuantity;}
	public final DoubleProperty unitPriceProperty() {return unitPrice;}
	
	@Override
	public String toString() {
		return name.get();
	}
 }
