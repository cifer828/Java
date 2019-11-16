package practice.practice12;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DocAnalyst extends Application{
	
	TextField inputText = new TextField();		//captures filename input by user
	Label resultLabel = new Label(); 			//displays result
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(setupScreen(), 400, 225);
		primaryStage.setTitle("Doc Analyst");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	BorderPane setupScreen() {
		BorderPane root = new BorderPane();
		Button csvButton = new Button("CSV");
		Button regularButton = new Button("Regular");

		GridPane docTypeGrid = new GridPane();	//holds buttons
		GridPane inputGrid = new GridPane();	//holds inputText and inputLabel
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		Label inputLabel = new Label("Enter file name:");
		inputLabel.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
		inputLabel.setFont(Font.font(20));
		inputLabel.setPrefSize(200, 75);
		inputText.setFont(Font.font(20));
		inputText.setAlignment(Pos.CENTER);
		inputText.setPrefSize(200, 75);
		inputGrid.add(inputLabel, 0, 0);
		inputGrid.add(inputText, 1, 0);
		inputGrid.setStyle("-fx-border-color: grey");

		resultLabel.setFont(Font.font(20));
		resultLabel.setPrefSize(600,75);
		resultLabel.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
		resultLabel.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(resultLabel, Pos.CENTER);

		csvButton.setPrefSize(200, 75);
		csvButton.setFont(Font.font(30));
		docTypeGrid.add(csvButton,  0, 0);
		regularButton.setPrefSize(200, 75);
		regularButton.setFont(Font.font(30));
		docTypeGrid.add(regularButton,  1, 0);
		
		csvButton.setOnAction(new ButtonHandler(new CSVDoc()));
		regularButton.setOnAction(new ButtonHandler(new RegularDoc()));

		root.setTop(docTypeGrid);	
		root.setCenter(inputGrid);
		root.setBottom(resultLabel);

		return root;
	}
	private class ButtonHandler implements EventHandler<ActionEvent>{
		Document document;
		ButtonHandler(Document document) {
			// TODO Auto-generated constructor stub
			this.document = document;
		}
		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			document.readFile(inputText.getText());
			resultLabel.setText(document.getDocInfo());
		}
	}

}
