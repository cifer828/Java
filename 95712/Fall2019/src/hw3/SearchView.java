/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Views of the search board.
 * 
 */


package hw3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellDataFeatures;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.scene.text.Text;

public class SearchView{

	/* Class Members */
	ComboBox<String> gameComboBox = new ComboBox<>(); //shows drop down for filtering the tableView data
	TextField searchTextField = new TextField();  //for entering search letters
	TableView<Score> searchTableView = new TableView<>();  //displays data from scores.csv
	final static String [] GAME_NAME = {"All games", "Hangman", "Twister"};
	
	/**
	 * Sets up the GUI components for Search functionality
	 */
	void setupView() {
		
		VBox searchVBox = new VBox();  //searchVBox contains searchLabel and searchHBox
		Text searchLabel = new Text("Search");
		searchVBox.getChildren().add(searchLabel);

		HBox searchHBox = new HBox();  //searchHBox contain gameComboBox and searchTextField
		searchHBox.getChildren().add(gameComboBox);
		searchHBox.getChildren().add(new Text("Search letters"));
		searchHBox.getChildren().add(searchTextField);
		searchVBox.getChildren().add(searchHBox);
		
		searchLabel.setStyle( "-fx-font: 30px Tahoma;" + 
				" -fx-fill: linear-gradient(from 0% 50% to 50% 100%, repeat, lightgreen 0%, lightblue 50%);" +
				" -fx-stroke: gray;" +
				" -fx-background-color: gray;" +
				" -fx-stroke-width: 1;") ;
		searchHBox.setPrefSize(WordNerd.GAME_SCENE_WIDTH, WordNerd.GAME_SCENE_HEIGHT / 3);
		gameComboBox.setPrefWidth(200);
		searchTextField.setPrefWidth(300);
		searchHBox.setAlignment(Pos.CENTER);
		searchVBox.setAlignment(Pos.CENTER);
		searchHBox.setSpacing(10);
		
		// Setup comboBox
		gameComboBox.getItems().addAll(GAME_NAME[0], GAME_NAME[1], GAME_NAME[2]);
		gameComboBox.getSelectionModel().selectFirst();
		
		setupSearchTableView();
		
		WordNerd.root.setPadding(new Insets(10, 10, 10, 10));
		WordNerd.root.setTop(searchVBox);
		WordNerd.root.setCenter(searchTableView);
		WordNerd.root.setBottom(WordNerd.exitButton);
	}
	
	/**
	 * Sets columns in the tableView
	 */
	@SuppressWarnings("unchecked")
	void setupSearchTableView() {
		
		TableColumn<Score, String> gameColumn = new TableColumn<>("Game");
		TableColumn<Score, String> scoreColumn = new TableColumn<>("Game");
		
		// Set callback methods for the gameColumn, convert gameId to gameName
		Callback<CellDataFeatures<Score, String>, ObservableValue<String>> gameCallback = 
				new Callback<TableColumn.CellDataFeatures<Score,String>, ObservableValue<String>> () {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Score, String> param) {
						StringProperty gameName = new SimpleStringProperty();
						if (param.getValue().getGameId() == 0)
							gameName.set(GAME_NAME[1]);
						else if (param.getValue().getGameId() == 1)
							gameName.set(GAME_NAME[2]);
						return gameName;
					}
		};
		
		// format the score value 
		Callback<CellDataFeatures<Score, String>, ObservableValue<String>> scoreCallback = 
				new Callback<TableColumn.CellDataFeatures<Score,String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Score, String> param) {
						StringProperty formatScore = new SimpleStringProperty();
						formatScore.set(String.format("%.2f", param.getValue().getScore()));
						return formatScore;
					}
			
		};
		
		gameColumn.setCellValueFactory(gameCallback);
		scoreColumn.setCellValueFactory(scoreCallback);
		
		// Set other columns to the table view
		TableColumn<Score, String> puzzleWordColumn = new TableColumn<>("Word");
		puzzleWordColumn.setCellValueFactory(new PropertyValueFactory<Score, String>("puzzleWord"));
		TableColumn<Score, Integer> timeColumn = new TableColumn<>("Time(sec)");
		timeColumn.setCellValueFactory(new PropertyValueFactory<Score, Integer>("timeStamp"));

		searchTableView.getColumns().setAll(gameColumn, puzzleWordColumn, timeColumn, scoreColumn);
		
		// Adjust layout and style
		searchTableView.setPrefWidth(720);
		for (int i = 0; i < 4; i++) {
			searchTableView. getColumns().get(i).setPrefWidth(170);
		} 
		
		
		
	}
}
