/**
 * @author  : Qiuchen Zhang
 * @andrewID: qiuchenz
 * 
 * Extends WordNerdController. Implements methods using in score board.
 * 
 */


package hw3;

import java.util.List;
import javafx.scene.chart.LineChart;

public class ScoreController extends WordNerdController{
	
	ScoreView scoreView;
	
	/**
	 * Creates new socreView and adds scoreChart of Hangman and Twister to the scoreGrid
	 */
	@Override
	void startController() {
		scoreView = new ScoreView();
		scoreView.setupView();
		
		// create scoreChart for Hangman and Twister
		WordNerdModel model = new WordNerdModel();
		model.readScore();
		List<LineChart<Number,Number>> scoreChart = new ScoreChart().drawChart(model.scoreList);
	
		scoreView.scoreGrid.add(scoreChart.get(0), 0, 1, 2, 1);
		scoreView.scoreGrid.add(scoreChart.get(1), 0, 2, 2, 1);
		WordNerd.root.setCenter(scoreView.scoreGrid);
		
		setupBindings();

	}

	@Override
	void setupBindings() {
		// do nothing
	}
	
	

}
