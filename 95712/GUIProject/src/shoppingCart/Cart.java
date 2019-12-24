package shoppingCart;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Cart extends Application{
	Model model = new Model();
	View view = new View();
	
	ObjectBinding<Item> itemBinding = new ObjectBinding<Item>() {
		{
			super.bind(view.itemsComboBox.valueProperty());
		}
		@Override
		protected Item computeValue() {
			// TODO Auto-generated method stub
			if (view.itemsComboBox.getSelectionModel().getSelectedIndex() >= 0) {
				return view.itemsComboBox.getSelectionModel().getSelectedItem();
			}
			return new Item();
		}
	};
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		model.loadData(); // this will load itemsMasterList from csv file
		Scene scene = new Scene(view.setupScene(), 700, 550);
		setupActions();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Shopping Cart");
		primaryStage.show();
	}
	
	void setupActions() {
		// bind itemsTableView with data
		view.cartTableView.setItems(model.cartObservableList);
		// bind itemsComboBox with data
		view.itemsComboBox.setItems(model.itemsObservableList);
		
		// attach a listener to itemsComboBox to display unit quantity and price labels
		// and set the quantitySlider back to 0
//		view.itemsComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
//			if (view.itemsComboBox.getSelectionModel().getSelectedIndex() >= 0) {
//				view.unitValueLabel.setText(String.format("%.2f, %s", newValue.unitQuantity, newValue.unit));
//				view.unitPriceValueLabel.setText(String.format("%.2f", newValue.unitPrice));
//				view.quantitySlider.setValue(0);
//			}
//		});
		
		view.unitValueLabel.textProperty().bind(Bindings.format("%.2f %s", Bindings.select(itemBinding, "unitQuantity"), Bindings.select(itemBinding, "unit")));
		view.unitPriceValueLabel.textProperty().bind(Bindings.format("%.2f", Bindings.select(itemBinding, "unitPrice")));
		
		// bind purchase units label with slider value using Fluent API
		view.purchasedUnitsValueLabel.textProperty().bind(Bindings.format("%.0f", view.quantitySlider.valueProperty()));
		
		// cell value factory for Price column in itemsTableVIew
		Callback<CellDataFeatures<ItemInCart, Double>, ObservableValue<Double>> callback = 
				new Callback<CellDataFeatures<ItemInCart,Double>, ObservableValue<Double>> (){

					@Override
					public ObservableValue<Double> call(CellDataFeatures<ItemInCart, Double> param) {
						// TODO Auto-generated method stub
						for (Item item: model.itemsObservableList) {
							if (item.getName().equals(param.getValue().getName())) {
								return (new SimpleDoubleProperty(item.getUnitPrice() * param.getValue().getQuantity())).asObject();
							}
						}
						return null;
					}
			
		};
		
		// set price column's call for factory method
		view.priceColumn.setCellValueFactory(callback);
		
		// event handler for add button
		// creates new ItemInCart with currently selected item name and purchase qty
		// and adds it to cartObservableList
		// it also moves the table selection to he last item just added
		view.addButton.setOnAction(event -> {
			if (view.itemsComboBox.getSelectionModel().getSelectedIndex() >= 0) {
				ItemInCart item = new ItemInCart(view.itemsComboBox.getSelectionModel().getSelectedItem().getName(), 
						view.quantitySlider.getValue());
				model.cartObservableList.add(item);
				view.cartTableView.getSelectionModel().selectLast();
			}
		});
		
		// total binding to add all cell values in the price column of table view
		DoubleBinding totalBinding = new DoubleBinding() {
			{
				super.bind(model.cartObservableList);
			}

			@Override
			protected double computeValue() {
				double total = 0;
				for (int row = 0; row < model.cartObservableList.size(); row++) {
					total += (double)view.cartTableView.getColumns().get(2).getCellObservableValue(row).getValue();
				}
				return total;
			}
		};
		
		// bind totalValueLabel's textProperty to totalBinding
		view.totalPriceValueLable.textProperty().bind(Bindings.format("%.2f", totalBinding));
		
		// listener for item-selection in cartTableView updates item in combo-box, and qty in quantitySlider
		// it looks for the selected item in the tableView in itemsObservableList, sets itemComboBox to that index,
		// and quantitySlider to the newValue's quantity
		view.cartTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
			if (newValue != null) {
				int index = 0;
				for (Item item: model.itemsObservableList) {
					if (item.getName().equals(newValue.getName())) {
						view.itemsComboBox.getSelectionModel().select(index);
						view.quantitySlider.setValue(newValue.getQuantity());
					}
				}
			}
		});
		
		// event handler for remove button
		// checks the current selected index
		// if it's >=0, then removes the item at that index from cartObservableList
		view.removeButton.setOnAction(event -> {
			int index = view.cartTableView.getSelectionModel().getSelectedIndex();
			if (model.cartObservableList.size() > index) model.cartObservableList.remove(index);
			if (model.cartObservableList.size() == 0)  view.itemsComboBox.getSelectionModel().clearSelection();
		});
		
		
	}
	
	
}
