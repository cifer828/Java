package shoppingCart;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
		Scene scene = new Scene(view.setupScene(), 700, 150);
		setupActions();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Shopping Cart");
		primaryStage.show();
	}
	
	void setupActions() {
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
	}
	
	
}
