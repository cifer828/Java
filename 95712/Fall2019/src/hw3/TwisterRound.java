/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Save specific status used in one round of the game Twister.
 * Inherits GameRound.
 */

package hw3;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TwisterRound extends GameRound{
	/* Class Members */
	
	// Contains all possible words that can be twisted out of the puzzle word.
	private ObservableList<String> solutionWordsList;
	
	// Each list in it carries words of a certain size that can be twisted out of the puzzleWord.
	// the number of lists equals TWISTER_MAX_WORD_LENGTH - TWISTER_MIN_WORD_LENGTH + 1 
	private ObservableList<ObservableList<String>> solutionListsByWordLength;
	
	// Similar to solutionListsByWordLength, except that it contains words submitted by the player
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
	
	/* Getters */
	
	public List<String> getSolutionWordsList(){
		return new ArrayList<String>(solutionWordsList);
	}
	
	
	/**
	 * @return all solution words
	 */
	public List<List<String>> getSolutionListsByWordLength(){
		List<List<String>> returnList = new ArrayList<>();
		for (ObservableList<String> ol : solutionListsByWordLength) {
			returnList.add(new ArrayList<>(ol));
		}
		return returnList;
	}
	
	/**
	 * @param letterCount: index of the solutionList, equals to length of the solution word - 3
	 * @return solution word list of the specific index
	 */
	public ObservableList<String> getSolutionListsByWordLength(int letterCount){
		return solutionListsByWordLength.get(letterCount);
	}
	
	
	/**
	 * @return all submitted words
	 */
	public List<List<String>> getSubmittedListsByWordLength(){
		List<List<String>> returnList = new ArrayList<>();
		for (ObservableList<String> ol : submittedListsByWordLength) {
			returnList.add(new ArrayList<>(ol));
		}
		return returnList;
	}
	
	/**
	 * @param letterCount:index of the submittedList, equals to length of the submitted word - 3
	 * @return submitted word list of the specific index
	 */
	public ObservableList<String> getSubmittedListsByWordLength(int letterCount){
		return submittedListsByWordLength.get(letterCount);
	}
	
	
	/* Setters */

	public void setSolutionWordsList(List<String> solutionWordsList) {
		this.solutionWordsList = FXCollections.observableArrayList(solutionWordsList);
	}
	
	public void setSolutionListsByWordLength(String word) {
		int idx = word.length() - Twister.TWISTER_MIN_WORD_LENGTH;
		solutionListsByWordLength.get(idx).add(word);
		FXCollections.sort(solutionListsByWordLength.get(idx));
	}
	
	public void setSubmittedListsByWordLength(String word) {
		int idx = word.length() - Twister.TWISTER_MIN_WORD_LENGTH;
		submittedListsByWordLength.get(idx).add(word);
		FXCollections.sort(submittedListsByWordLength.get(idx));
	}
	
	/* Getters for property*/
	public ObservableList<String> solutionWordsListProperty(){ return solutionWordsList; }
	public ObservableList<ObservableList<String>> solutionListsByWordLengthProperty(){ return solutionListsByWordLength; }
	public ObservableList<ObservableList<String>> submittedListsByWordLengthProperty(){ return submittedListsByWordLength; }
	

}
