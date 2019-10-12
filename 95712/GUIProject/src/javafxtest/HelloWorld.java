package javafxtest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
	@Override
	public void start(Stage primaryStage) {
		//set the root container
		StackPane root = new StackPane();
		//set the button
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new ButtonHandler());
		//add button to root
		root.getChildren().add(btn);
		//create scene with the root
		Scene scene = new Scene(root, 300, 250);
		//set the stage and add the scene
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	} //end start method
	
	public static void main(String[] args) {
		launch(args); //launch the application
	} //end main method

	//inner class for button event-handler
	private class ButtonHandler implements EventHandler <ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Hello World!");
		}
	} //end ButtonHandler
} // end HelloWorld
