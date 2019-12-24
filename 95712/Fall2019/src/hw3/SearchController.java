/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Extends WordNerdContoller. Implements methods using in search.
 */


package hw3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchController extends WordNerdController {
	
	/* Class Members */
	SearchView searchView;

	/**
	 * Creates new searchView and set up bindings for the tableView
	 */
	@Override
	void startController() {
		searchView = new SearchView();
		searchView.setupView();
		setupBindings();
	}

	/**
	 * Sets up bindings used in gamedComboBox and searchTextField. 
	 * So that the table view shows the search result according to user's selection and input
	 */
	@Override
	void setupBindings() {
		// get all records
		WordNerdModel model = new WordNerdModel();
		model.readScore();
		searchView.searchTableView.setItems(model.scoreList);
		
		// update searchTableView based on selection in the gameComboBox
		searchView.gameComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			ObservableList<Score> filtered = FXCollections.observableArrayList();
			String searchWord = searchView.searchTextField.getText();
			for (Score score: model.scoreList) {
				// add specific Score according to the comboBox selection
				if (isSelected(newValue, score) && isMatched(searchWord, score)){
					filtered.add(score);
				}
			}
			searchView.searchTableView.setItems(filtered);
		});
		
		// update searchTableView based on user's search letter in the serachTextField
		searchView.searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			ObservableList<Score> filtered = FXCollections.observableArrayList();
			String selection = searchView.gameComboBox.getSelectionModel().getSelectedItem();
			for (Score score: model.scoreList) {
				// add specific Score according to the comboBox selection
				if (isMatched(newValue, score) && isSelected(selection, score)){
					filtered.add(score);
				}
			}
			searchView.searchTableView.setItems(filtered);
		});
	}
	
	
	/* Helper Methods*/
	
	/**
	 * Determine if the given record belongs to user's selection in the comboBox
	 * @param selection: user selection in the comboBox
	 * @param score: record to be determined
	 * @return: true if the record is in user's selection, otherwise false
	 */
	private boolean isSelected(String selection, Score score) {
		return selection.equals(SearchView.GAME_NAME[0]) || selection.equals(score.getName());
	}
	
	
	/**
	 * Determine if the given record matches user's search
	 * @param searchWord: search letter
	 * @param score: given record to be determined
	 * @return: true if the puzzle word in the given record matches user's search
	 *          otherwise false
	 */
	private boolean isMatched(String searchWord, Score score) {
		for (char c: searchWord.toCharArray()) {
			if (!score.getPuzzleWord().contains("" + c)) {
				return false;
			}
		}
		return true;
	}

}
