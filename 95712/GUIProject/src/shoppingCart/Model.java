package shoppingCart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	ObservableList<Item> itemsObservableList = FXCollections.observableArrayList();
	
	void loadData() {
		try(BufferedReader br = new BufferedReader(new FileReader("ItemsMaster.csv"))){
			String line = null;
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				Item item = new Item(values[0].trim(), values[1].trim(), Double.parseDouble(values[2].trim()), Double.parseDouble(values[3].trim()));
				itemsObservableList.add(item);
			}
		}catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
