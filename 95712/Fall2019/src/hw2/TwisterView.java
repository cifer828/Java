/*
 * Author  : Qiuchen Zhang
 * AndrewID: qiuchenz
 * 
 * TwisterView: Build interface of the game Twister.
 */



package hw2;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TwisterView extends GameView{
	
	static final int PLAY_BUTTON_COUNT = 4; //New word, Twist, Clear, and Submit buttons
	Label[] wordLengthLabels;  //shows letter count on the left of each solution list 
	Label[] wordScoreLabels; //shows score for a letter count on the right of each solution list
	Button[] clueButtons ;  //clue buttons on the top
	Button[] answerButtons; //empty buttons below clue buttons
	Button[] playButtons;  //buttons for New Word, Twist, Clear, and Submit
	ListView<String>[] solutionListViews;  //lists that show he correct guesses made by the player
	
	/* Constructor */
	TwisterView() {
		
		//initialize member variables
		wordLengthLabels = new Label[Twister.SOLUTION_LIST_COUNT];
		wordScoreLabels = new Label[Twister.SOLUTION_LIST_COUNT];
		playButtons = new Button[TwisterView.PLAY_BUTTON_COUNT];  
		
		setupTopGrid();
		setupBottomGrid();
		setupSizesAlignmentsEtc();
	}
	
	/* setupTopGrid(): Sets up elements in topGrid */
	@Override
	void setupTopGrid() {
		topGrid.add(clueGrid, 0, 0);
		topGrid.add(playButtonsGrid, 0, 2);
		
		//setup play buttons grid
		playButtons[0] = new Button("New Word");
		playButtons[1] = new Button("Twist");
		playButtons[2] = new Button("Clear");
		playButtons[3] = new Button("Submit");

		for (int col = 0; col < playButtons.length; col++) {
			playButtons[col].setPrefSize(120, 20);
			playButtons[col].setStyle("-fx-background-color: gray," +
					" linear-gradient(lightblue, gray), " +
					" linear-gradient(lightblue 0%, white 49%, white 50%, lightblue 100%);" + 
					" -fx-background-insets: 0,1,2;"); 
			playButtons[col].setTextFill(Color.BLACK);
			playButtons[col].setFont(Font.font(15));

			playButtonsGrid.add(playButtons[col], col + 1, 0);
		}
		
		wordTimer = new WordTimer(Twister.TWISTER_GAME_TIME);
		playButtonsGrid.add(wordTimer.timerButton, 0, 0);
		playButtonsGrid.add(smileyButton, 5, 0);
	}
	
	/* setupBottomGrid(): Sets up elements in bottomGrid */
	@SuppressWarnings("unchecked")
	@Override
	void setupBottomGrid() {
		bottomGrid.getChildren().clear();
		bottomGrid.setAlignment(Pos.CENTER);
		bottomGrid.setVgap(5);
		bottomGrid.setMinSize(700, 300);
		//setup letter count buttons
		for (int i = 0; i < wordLengthLabels.length; i++ ) {
			wordLengthLabels[i] = new Label(String.format("%d", i + 3));  //starting with 3
			wordLengthLabels[i].setPrefSize(50, 50);
			
			wordLengthLabels[i].setStyle( "-fx-font: 15px Tahoma;" + 
					" -fx-background-color: lightgray;");
			wordLengthLabels[i].setTextFill(Color.BLACK);
			wordLengthLabels[i].setAlignment(Pos.CENTER);
			bottomGrid.add(wordLengthLabels[i], 0, i);
		}	
		
		//setup solution lists
		solutionListViews = new ListView[Twister.SOLUTION_LIST_COUNT];
		for (int i = 0; i < solutionListViews.length; i++) {
			solutionListViews[i] = new ListView<>();
			solutionListViews[i].setOrientation(Orientation.HORIZONTAL);
			solutionListViews[i].setPrefSize(525, 50);
		}
		
		//setup word score buttons
		wordScoreLabels = new Label[Twister.SOLUTION_LIST_COUNT];
		for (int i = 0; i < wordScoreLabels.length; i++ ) {
			wordScoreLabels[i] = new Label(String.format("%d", i + 3));  //starting with 3
			wordScoreLabels[i].setPrefSize(50, 50);
			wordScoreLabels[i].setStyle("-fx-font: 15px Tahoma;" + 
					" -fx-background-color: lightgray;");
			wordScoreLabels[i].setTextFill(Color.BLACK);
			wordScoreLabels[i].setAlignment(Pos.CENTER);
			bottomGrid.add(wordScoreLabels[i], 2, i);
		}
	}
	
	/* setupSizesAlignmentsEtc(): Sets up alignments */
	@Override
	void setupSizesAlignmentsEtc() {
		playButtonsGrid.setHgap(10);
		playButtonsGrid.setVgap(10);
		
		topGrid.setMinSize(WordNerd.GAME_SCENE_WIDTH, 200);
		topGrid.setAlignment(Pos.CENTER);
		topGrid.setHgap(10);
		topGrid.setVgap(10);
		
		bottomGrid.setAlignment(Pos.BASELINE_CENTER);
		clueGrid.setAlignment(Pos.CENTER);
	}
	
	
	/*
	 * refreshGameRoundView(): clears up previous game round and 
	 * refreshes all components with info in the new gameRound 
	 */
	void refreshGameRoundView(GameRound twisterRound) {
		int clueLen = twisterRound.getClueWord().length();
		clueButtons = new Button[clueLen];
		answerButtons = new Button[clueLen];
		
		// Clear clueGrid from the previous game round
		clueGrid.getChildren().clear();
		
		// Set up buttons in clueGrid
		String buttonSytle = " -fx-font: 20px Arial;" +
							" -fx-background-insets: 0,1,1;" + 
							" -fx-padding: 3 3 3 3;" + 
							" -fx-background-radius: 5em; " +
							" -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );";
		for (int i = 0; i < clueLen; i++) {
			// Set up clueButtons
			clueButtons[i] = new Button();
			clueButtons[i].setText(Character.toString(twisterRound.getClueWord().charAt(i)));
			clueButtons[i].setStyle("-fx-background-color: white," + 
					" linear-gradient(lightblue, white)," + 
					" linear-gradient(lightblue 0%, white 49%, white 50%, lightblue 100%);" + 
					buttonSytle);
			clueButtons[i].setMinSize(70, 70);
			clueGrid.add(clueButtons[i], i, 0);
			// Set up answerButton
			answerButtons[i] = new Button();
			answerButtons[i].setStyle("-fx-background-color: lightgray," + 
					" linear-gradient(white, lightgrey)," + 
					" linear-gradient(lightgrey 0%, white 49%, white 50%, lightgrey 100%);" + 
					buttonSytle);
			answerButtons[i].setMinSize(70, 70);
			clueGrid.add(answerButtons[i], i, 1);
		}
		
		// Setup elements in bottomGrid
		for (int i = 0; i < Twister.SOLUTION_LIST_COUNT; i++) {
			TwisterRound tr = (TwisterRound)twisterRound;
			// First, add elements not in bottomGrid
			if (!bottomGrid.getChildren().contains(wordLengthLabels[i])) {
				bottomGrid.add(wordLengthLabels[i], 0, i);
			}
			if (!bottomGrid.getChildren().contains(solutionListViews[i])) {
				bottomGrid.add(solutionListViews[i], 1, i);
			}
			if (!bottomGrid.getChildren().contains(wordScoreLabels[i])) {
				bottomGrid.add(wordScoreLabels[i], 2, i);
			}
			// Then, remove elements if correlated solutionList has no words in it
			if (tr.getSolutionListsByWordLength(i).size() == 0) {
				bottomGrid.getChildren().remove(wordLengthLabels[i]);
				bottomGrid.getChildren().remove(solutionListViews[i]);
				bottomGrid.getChildren().remove(wordScoreLabels[i]);
			}
		}
		
		// Setup simley button
		smileyButton.setGraphic(smileyImageViews[SMILEY_INDEX]);
		
		// Setup topMessage
		String InitialTopMessage = String.format("Twist to find %d words!", ((TwisterRound)twisterRound).getSolutionWordsList().size());
		topMessageText.setText(InitialTopMessage);
		
	}
}