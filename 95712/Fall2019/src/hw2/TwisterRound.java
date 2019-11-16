/*
 * Author  : Qiuchen Zhang
 * AndrewID: qiuchenz
 * 
 * TwisterRound: Save specific status used in one round of the game Twister.
 *               Inherits GameRound.
 */

package hw2;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TwisterRound extends GameRound{
	/* Contains all possible words that can be twisted out of the puzzle word. */
	private ObservableList<String> solutionWordsList;
	
	/* Each list in it carries words of a certain size that can be twisted out of the puzzleWord.
	 * the number of lists equals TWISTER_MAX_WORD_LENGTH - TWISTER_MIN_WORD_LENGTH + 1 */
	private ObservableList<ObservableList<String>> solutionListsByWordLength;
	
	/* Similar to solutionListsByWordLength, except that it contains words submitted by the player */
	private ObservableList<ObservableList<String>> submittedListsByWordLength;
	
	/* Constructor */
	public TwisterRound() {
		// Initialize class members
		solutionWordsList = FXCollections.observableArrayList();
		int listLen = Twister.TWISTER_MAX_WORD_LENGTH - Twister.TWISTER_MIN_WORD_LENGTH + 1;
		solutionListsByWordLength = FXCollections.observableArrayList();
		submittedListsByWordLength = FXCollections.observableArrayList();
		// Add empty elements to two lists of lists.
		for (int i = 0; i < listLen; i++) {
			solutionListsByWordLength.add(FXCollections.observableArrayList());
			submittedListsByWordLength.add(FXCollections.observableArrayList());
		}
	}
	
	/****** Methods for solutionWordsList *******/
	
	/* getSolutionWordsList(): Getter for solutionWordsList content */
	public List<String> getSolutionWordsList(){
		return new ArrayList<String>(solutionWordsList);
	}
	
	/* setSolutionWordsList(): Setter for solutionWordsList content */
	public void setSolutionWordsList(List<String> solutionWordsList) {
		this.solutionWordsList = FXCollections.observableArrayList(solutionWordsList);
	}
	
	/* solutionWordsListProperty(): Getter for solutionWordsList property */
	public ObservableList<String> solutionWordsListProperty(){
		return solutionWordsList;
	}
	
	/****** Methods for solutionListsByWordLength *******/
	
	/* getSolutionListsByWordLength(): Getter for solutionListsByWordLength content */
	public List<List<String>> getSolutionListsByWordLength(){
		List<List<String>> returnList = new ArrayList<>();
		for (ObservableList<String> ol : solutionListsByWordLength) {
			returnList.add(new ArrayList<>(ol));
		}
		return returnList;
	}
	
	/* getSolutionListsByWordLength(int letterCount): Overload method, 
	 *                             returns the solution list that contains words of given length */
	public ObservableList<String> getSolutionListsByWordLength(int letterCount){
		return solutionListsByWordLength.get(letterCount);
	}
	
	
	/* setSolutionListsByWordLength(): Adds the word to the solution list that contains words of its length */
	public void setSolutionListsByWordLength(String word) {
		int idx = word.length() - Twister.TWISTER_MIN_WORD_LENGTH;
		solutionListsByWordLength.get(idx).add(word);
		FXCollections.sort(solutionListsByWordLength.get(idx));
	}
	
	/* solutionListsByWordLengthProperty(): Getter of solutionListsByWordLength property */
	public ObservableList<ObservableList<String>> solutionListsByWordLengthProperty(){
		return solutionListsByWordLength;
	}
	
	/****** Methods for submittedListsByWordLength *******/
	
	/* getSubmittedListsByWordLength(): Getter for submittedListsByWordLength content */
	public List<List<String>> getSubmittedListsByWordLength(){
		List<List<String>> returnList = new ArrayList<>();
		for (ObservableList<String> ol : submittedListsByWordLength) {
			returnList.add(new ArrayList<>(ol));
		}
		return returnList;
	}
	
	/* getSubmittedListsByWordLength(int letterCount): Overload method, 
	 *                             returns the submitted list that contains words of given length */
	public ObservableList<String> getSubmittedListsByWordLength(int letterCount){
		return submittedListsByWordLength.get(letterCount);
	}
	
	/* setSubmittedListByWordLength(): Adds the word to the submitted list that contains words of its length */
	public void setSubmittedListsByWordLength(String word) {
		int idx = word.length() - Twister.TWISTER_MIN_WORD_LENGTH;
		submittedListsByWordLength.get(idx).add(word);
		FXCollections.sort(submittedListsByWordLength.get(idx));
	}
	
	/* submittedListByWordLengthProperty(): Getter of submittedListsByWordLength property */
	public ObservableList<ObservableList<String>> submittedListsByWordLengthProperty(){
		return submittedListsByWordLength;
	}
	

}
