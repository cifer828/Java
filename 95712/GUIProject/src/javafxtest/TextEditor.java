package javafxtest;

import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class TextEditor extends Application {
	Stage stage;
	BorderPane root = new BorderPane(); 
	TextArea fileTextArea = new TextArea(); 
	Label statusLabel = new Label(); 
	StringBuilder fileContent; 
	FileUtilities fileUtilities = new FileUtilities();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		setScreen();
		Scene scene = new Scene(root, 500, 600);
		stage.setTitle("Text Reader");  //has only reading functions
		stage.setScene(scene);
		stage.show();
	}

	public void setScreen() {
		//create menus
		Menu fileMenu = new Menu("File");
		Menu toolsMenu = new Menu("Tools");
		Menu helpMenu = new Menu("Help");

		//create menu items
		MenuItem openFileMenuItem = new MenuItem("Open");
		MenuItem exitFileMenuItem = new MenuItem("Exit");
		MenuItem closeFileMenuItem = new MenuItem("Close");
		MenuItem searchToolsMenuItem = new MenuItem("Search");
		MenuItem replaceToolsMenuItem = new MenuItem("Replace");
		MenuItem wordCountToolsMenuItem = new MenuItem("Word Count");
		MenuItem aboutHelpMenuItem = new MenuItem("About");

		//attach event handlers
		openFileMenuItem.setOnAction(new OpenFileHandler());  
//		searchToolsMenuItem.setOnAction(new SearchToolHandler());
//		replaceToolsMenuItem.setOnAction(new ReplaceToolHandler());
//		wordCountToolsMenuItem.setOnAction(new WordCountToolHandler());
//		aboutHelpMenuItem.setOnAction(new AboutHandler());


		closeFileMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				fileTextArea.clear();
				statusLabel.setText("");
				root.setCenter(null);
			}
		});
		exitFileMenuItem.setOnAction(actionEvent->Platform.exit());  //lambda expression
		//set status bar width and color
		statusLabel.setPrefWidth(this.stage.getMaxWidth()); //occupy entire width of the window
		statusLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		//add menu items to menus and menus to menubar
		MenuBar menuBar = new MenuBar();
		fileMenu.getItems().addAll(openFileMenuItem, closeFileMenuItem, new SeparatorMenuItem(), exitFileMenuItem);
		toolsMenu.getItems().addAll(searchToolsMenuItem, replaceToolsMenuItem, 
				new SeparatorMenuItem(),wordCountToolsMenuItem);
		helpMenu.getItems().addAll(aboutHelpMenuItem);
		menuBar.getMenus().addAll(fileMenu, toolsMenu, helpMenu);

		//set root children
		root.setTop(menuBar);
		root.setBottom(statusLabel);

	} //end setScreen()


	private class OpenFileHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Select file");
			fileChooser.setInitialDirectory(new File("/Users/qiuchenzhang")); //local path 
			fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text Files", "*.txt"),
					new ExtensionFilter("All Files", "*.*"));
			File file = null;
			if ((file = fileChooser.showOpenDialog(stage)) != null){
				fileContent = fileUtilities.readFile(file.getAbsolutePath());
				fileTextArea.clear();
				fileTextArea.appendText(fileContent.toString());
				fileTextArea.setWrapText(true);
				fileTextArea.positionCaret(0);
				root.setCenter(fileTextArea);
			} //end if
		} //end handle()
	} //end OpenFileHandler
} //end TextReader
