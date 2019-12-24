/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 *  Super class of HangmanController, TwisterController, ScoreController and SearchController.
 */

package hw3;

// See child classes for concrete explanations
public abstract class WordNerdController {
	
	WordNerdModel wordNerdModel = new WordNerdModel();
	
	abstract void startController();

	abstract void setupBindings();
	

}
