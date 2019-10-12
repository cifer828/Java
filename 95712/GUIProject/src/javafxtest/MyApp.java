package javafxtest;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MyApp extends Application {
	public void start(Stage stage) {
		Circle circ = new Circle(40, 40, 30);    //create circle of radius = 30 at x=40, y=40  
		Group root = new Group(circ);			     //add circle to a new Group named root
		Scene scene = new Scene(root, 250, 100); //create scene with root and size 250 x 100  

		stage.setTitle("My JavaFX Application"); //set the stage
		stage.setScene(scene);					 //add scene to the stage
		stage.show();								 //made stage visible
	}
	public static void main(String[] args) {
		launch(args);								//launch the application 
	}
}
