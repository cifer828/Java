// Qiuchen Zhang
// qiuchenz


package exam2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WordWhiz extends Application{

	TextField wordTextField = new TextField();
	TextArea resultTextArea = new TextArea();
	Button dictionaryButton = new Button("Dictionary");
	Button thesaurusButton = new Button("Thesaurus");
	Button clearButton = new Button("Clear");

	//do not change this method
	public static void main(String[] args) {
		launch(args);
	}

	//do not change this method
	@Override
	public void start(Stage arg0) throws Exception {
		GridPane root = new GridPane();
		setupScene(root);
		setupAction();
		Scene scene = new Scene (root, 700, 400);
		arg0.setScene(scene);
		arg0.setTitle("Word Whiz");
		arg0.show();
	}

	//do not change this method
	void setupScene(GridPane root) {
		Label label = new Label ("Enter a word");
		label.setAlignment(Pos.BASELINE_RIGHT);
		//set styles
		label.setStyle("-fx-font-size: 20");
		wordTextField.setStyle("-fx-font-size: 20");
		dictionaryButton.setStyle("-fx-font-size: 20");
		thesaurusButton.setStyle("-fx-font-size: 20");
		clearButton.setStyle("-fx-font-size: 20");
		resultTextArea.setStyle("-fx-font-size: 15");

		//set sizes
		label.setPrefSize(250, 50);
		dictionaryButton.setPrefSize(350, 50);
		thesaurusButton.setPrefSize(350, 50);
		clearButton.setPrefSize(700, 50);
		resultTextArea.setPrefSize(700, 200);

		//set gaps
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setVgap(20);
		root.setHgap(10);

		//add to root
		root.add(label, 0, 0);
		root.add(wordTextField, 1, 0);
		root.add(dictionaryButton, 0, 1);
		root.add(thesaurusButton, 1, 1);
		root.add(clearButton, 0, 2, 2, 1);
		root.add(resultTextArea, 0, 3, 2,1);

		resultTextArea.setWrapText(true);
	}


	//setupAction() 
	void setupAction() {
		//write your code here
		dictionaryButton.setOnAction(new ButtonHandler(new Dictionary("Dictionary.txt")));
		thesaurusButton.setOnAction(new ButtonHandler(new Thesaurus("Thesaurus.txt")));
		clearButton.setOnAction(new ClearButtonHandler());
		
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent>{
		WordReference wordReference;
		public ButtonHandler(WordReference wordReference) {
			// TODO Auto-generated constructor stub
			this.wordReference = wordReference;
		}
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			resultTextArea.setText("");
			String [] lookUpResult = wordReference.lookup(wordTextField.getText());
			if (lookUpResult == null)
				resultTextArea.setText("Word not found");
			else{
				for (int i = 0; i < lookUpResult.length; i++) {
					resultTextArea.appendText(String.format("%d.%s\n", i+1, lookUpResult[i]));
				}
			}
			
			
		}
		
	}
	private class ClearButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			resultTextArea.setText("");
			wordTextField.setText("");
		}
		
	}

}
