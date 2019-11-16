/*
 * Author  : Qiuchen Zhang
 * AndrewID: qiuchenz
 * 
 * TwisterController: Controller methods of the game twister.
 *                    Inherits WordNerdController.
 */

package hw2;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class TwisterController extends WordNerdController{
	
	/*
	 ***************************
	 **    Class  Members     **
	 ***************************
	 */
	
	TwisterView twisterView;
	Twister twister;
	
	/*
	 ***************************
	 **     Basic  Methods    **
	 ***************************
	 */
	
	/* 
	 * startController(): creates new Twister, TwisterView, invokes setupRound() to create a new TwisterRound,
	 * 					  refreshes the view for next round, and invokes setupBindings to bind the new
	 *                    Twister properties with GUI components.
	 */
	@Override
	void startController() {
		twisterView = new TwisterView();
		twister = new Twister();
		twister.twisterRound = twister.setupRound();
		twisterView.refreshGameRoundView(twister.twisterRound);
		setupBindings();
		
		VBox lowerPanel = new VBox();
		lowerPanel.getChildren().add(twisterView.bottomGrid);
		lowerPanel.getChildren().add(WordNerd.exitButton);
		lowerPanel.setAlignment(Pos.CENTER);
		
		WordNerd.root.setTop(twisterView.topMessageText);
		WordNerd.root.setCenter(twisterView.topGrid);
		WordNerd.root.setBottom(lowerPanel);
		
		attachButtonsHandles();
		setupBindings();
	}
	
	/*
	 * setupRoundBindings(): binds GUI components with TwisterRound properties and the timer
	 *                       to change smiley button, wordScoreLabels and solutionListViews
	 */
	@Override
	void setupBindings() {
		for (int i = 0; i < Twister.SOLUTION_LIST_COUNT; i++) {
			// Binds submittedWordsList to solutionListView
			twisterView.solutionListViews[i].setItems(twister.twisterRound.getSubmittedListsByWordLength(i));
			
			// Add listeners to submittedList, when it's changed, update wordScoreLabels
			IntegerBinding submittedSize = Bindings.size(twister.twisterRound.getSubmittedListsByWordLength(i));
			IntegerBinding solutionSize = Bindings.size(twister.twisterRound.getSolutionListsByWordLength(i));
			twisterView.wordScoreLabels[i].textProperty().bind(Bindings.format("%d/%d", submittedSize, solutionSize));
			
			// Alternative method using addListener, can't compile, still working on
//			int submittedSize = twister.twisterRound.getSubmittedListsByWordLength(wordLen).size();
//			int solutionSize = twister.twisterRound.getSolutionListsByWordLength(wordLen).size();
//			twister.twisterRound.submittedListsByWordLengthProperty().get(i).addListener((ListChangeListener<String>)list -> {
//				twisterView.wordScoreLabels[i].setText(String.format("%d/%d", submittedSize, solutionSize));
//			});
		}
		
		// When timer runs out, set smiley to sadly, isRoundComplete to true
		GameView.wordTimer.timeline.setOnFinished(event -> { 
			twisterView.smileyButton.setGraphic(twisterView.smileyImageViews[GameView.SADLY_INDEX]);
			twister.twisterRound.setIsRoundComplete(true);
		});
		
		// When a round is complete, three playButtons and clueGrid should be disabled
		BooleanProperty isRoundComplete = twister.twisterRound.isRoundCompleteProperty();
		for (int i = 1; i < 4; i++)
			twisterView.playButtons[i].disableProperty().bind(isRoundComplete);
		
		twisterView.clueGrid.disableProperty().bind(isRoundComplete);
	}
	
	
	/* 
	 * NewButtonHandler: Starts a new round of game, refresh the view,
	 *                   restart the timer, and setup new bindings
	 */
	class NewButtonHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event) {
			twister.twisterRound = twister.setupRound();
			twisterView.refreshGameRoundView(twister.twisterRound);
			GameView.wordTimer.restart(Twister.TWISTER_GAME_TIME);
			setupBindings();
			attachButtonsHandles();
		}
	}
	
	/* 
	 * TwistButtonHandler: Twists the word currently displayed in clueButtons
	 */
	class TwistButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			// Save current clueWord
			StringBuilder oldClueSB = new StringBuilder();
			for (Button clueBtn: twisterView.clueButtons) {
				if (!clueBtn.getText().equals("")) {
					oldClueSB.append(clueBtn.getText());
					clueBtn.setText("");
				}
			}
			
			// Shuffle the clue word
			String newClue = twister.makeAClue(oldClueSB.toString());
			
			// Set the new clueWord to clueButton
			for (int i = 0; i < newClue.length(); i++) {
				twisterView.clueButtons[i].setText(Character.toString(newClue.charAt(i)));
			}	
		}
	}
	
	/* 
	 * ClearButtonHandler: Clears the letters in answerButtons, if any, 
	 *                     and moves them to empty slots in clueButtons
	 */
	class ClearButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			for (Button ansBtn: twisterView.answerButtons) {
				// Skip empty answerButtons
				if (ansBtn.getText().equals("")) continue;
				clearOneButton(ansBtn, twisterView.clueButtons);
			}
		}
	}
	
	/* 
	 * SubmitButtonHandler: Takes chars in ansButton as a guess, submits the guess to Twister.nextTry(), 
	 *                      change smilev button according to the return, and reset answerButton and clueButton
	 */
	class SubmitButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			StringBuilder guess = new StringBuilder();
			// Add button value to guess, skips the empty ansButtons
			for (Button ansBtn: twisterView.answerButtons) {
				if (!ansBtn.getText().equals("")) {
					guess.append(ansBtn.getText());
				}
				
			}
			int index = twister.nextTry(guess.toString());
			twisterView.smileyButton.setGraphic(twisterView.smileyImageViews[index]);
			// Reset answerButton if guess is right
			if (index == GameView.THUMBS_UP_INDEX) {
				for (Button ansBtn: twisterView.answerButtons) {
					if (!ansBtn.getText().equals("")) {
						clearOneButton(ansBtn, twisterView.clueButtons);
					}					
				}
			}
			if (index == GameView.SMILEY_INDEX) {
				GameView.wordTimer.timeline.stop();
				twister.twisterRound.setIsRoundComplete(true);
			}
			twisterView.topMessageText.setText(twister.getScoreString());
		}
	}
	
	
	/* 
	 * AnswerButtonHandler: Takes the char in clicked answerButton, finds the first empty clueButton, 
	 *                      put the char into it and clears the clicked answerButton 
	 */
	class AnswerButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			Button ansBtn = (Button)event.getSource();
			clearOneButton(ansBtn, twisterView.clueButtons);
		}
	}
	
	/* 
	 * ClueButtonHandler: Takes the char in clicked clueButton, finds the first empty ansButton, 
	 *                     put the char into it and clears the clicked clueButton 
	 */
	class ClueButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			Button clueBtn = (Button)event.getSource();
			clearOneButton(clueBtn, twisterView.answerButtons);
		}
	}
	
	/*
	 ***************************
	 **     Helper Methods    **
	 ***************************
	 */
	
	/* 
	 * attachButtonsHandles(): Helper function of startConroller(),
	 *                         attaches handlers to various buttons
	 */
	private void attachButtonsHandles() {
		// Attach handlers to clueButtons
		for (int i = 0; i < twisterView.clueButtons.length; i++) {
			twisterView.clueButtons[i].setOnAction(new ClueButtonHandler());
		}
		// Attach handlers to answerButtons
		for (int i = 0; i < twisterView.clueButtons.length; i++) {
			twisterView.answerButtons[i].setOnAction(new AnswerButtonHandler());
		}
		
		// Attach handler to the new word, twist, clear and submit button
		twisterView.playButtons[0].setOnAction(new NewButtonHandler());
		twisterView.playButtons[1].setOnAction(new TwistButtonHandler());
		twisterView.playButtons[2].setOnAction(new ClearButtonHandler());
		twisterView.playButtons[3].setOnAction(new SubmitButtonHandler());
	}
	
	/* 
	 * clearOneButton: Helper function of button handlers.
	 *                 Takes the char in the srcButton, finds the first empty button in dstButtons, 
	 *                 put the char into it and clears the srcButton
	 */
	private void clearOneButton(Button srcButton, Button [] dstButtons) {
		for (Button dstB: dstButtons) {
			if (dstB.getText().equals("")) {
				dstB.setText(srcButton.getText());
				break;
			}
		}
		srcButton.setText("");
	}
}
