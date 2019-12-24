/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Throws exception when either the word source file is empty 
 * or has some words with non-alphabet characters.
 * 
 */

package hw3;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

@SuppressWarnings("serial")
public class InvalidWordSourceException extends RuntimeException{
	String message;
		
	/**
	 * Constructor with arguments
	 * 
	 * @param message: text to be displayed in the prompt
	 */
	InvalidWordSourceException(String message) {
		this.message = message;
	}
	
	
	/**
	 * Shows an alert prompt with certain message
	 */
	void showAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Word Source Format Error" );
		alert.setTitle("WordNerd 3.0");
		alert.setContentText(message );
		alert.showAndWait();
	}
}
