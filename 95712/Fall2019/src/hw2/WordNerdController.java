/*
 * Author  : Qiuchen Zhang
 * AndrewID: qiuchenz
 */

package hw2;

/* WordNerdModel: Abstract father class of HangmanController and TwisterController. */
public abstract class WordNerdController {
	
	WordNerdModel wordNerdModel = new WordNerdModel();
	
	// 
	abstract void startController();

	abstract void setupBindings();
	

}
