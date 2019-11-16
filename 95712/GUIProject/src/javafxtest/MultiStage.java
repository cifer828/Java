package javafxtest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MultiStage extends Application{
	BorderPane helloRoot = new BorderPane();
	BorderPane byeRoot = new BorderPane();
	Stage byeStage = new Stage();
	Scene helloScene, byeScene;
	public static void main(String[] args) { launch(args); }
	@Override
	public void start(Stage helloStage) throws Exception {
		setStages();
		helloStage.setTitle("Hello Stage");
		helloStage.setScene(helloScene);
		helloStage.show();
	}
	void setStages() {
		helloScene = new Scene(helloRoot, 200, 100);
		byeScene = new Scene(byeRoot, 200, 100);
		byeStage.setScene(byeScene);
		
		Button helloButton = new Button("Hello!");
		helloRoot.setCenter(helloButton);
		helloButton.setOnAction(new HelloButtonHandler());

		Button byeButton = new Button("Bye!");
		byeRoot.setCenter(byeButton);
		byeStage.setTitle("Hello Stage");
		byeButton.setOnAction(new ByeButtonHandler());
	}

	private class HelloButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			byeStage.setX(500);
			byeStage.setY(300);
			byeStage.show();
		}
	}
	private class ByeButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			byeStage.close();}
	}
}


