// Qiuchen Zhang
// AndrewID: qiuchenz

package lab5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**95712 Lab5.  
 * This Calculator class provides GUI-based calculator 
 * that performs simple operations +, - *, / 
 */
public class Calculator extends Application{
	GridPane root = new GridPane();
	Button[] numberButtons = new Button[10];		//will hold digits from 0 to 9
	Button[] operatorButtons = new Button[6];		//will hold +, -, *, /, =, and Clear buttons
	Label resultLabel = new Label();	//will display the operands, operators, or result

	StringBuilder op1String = new StringBuilder();	//will hold numeric digits for first operand 
	StringBuilder op2String = new StringBuilder();  //will hold numeric digits for second operand
	String operator;								//will hold the operator 
	boolean operatorPressed;						//set to true when use presses any of the four operator keys +, -, *, /
	boolean operationComplete;						//set to true right after user presses = and result of operation is displayed


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene;
		primaryStage.setTitle("Calculator");
		setupScreen();
		scene = new Scene(root, 300, 290);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}

	private void setupScreen() {
		root.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
		/*loop to create and size the numeric buttons, and attach their event handlers */
		for (int i = 0; i < numberButtons.length; i++) {	
			numberButtons[i] = new Button(String.format("%s", i));
			numberButtons[i].setStyle("-fx-font-size:20");
			if (i==0) numberButtons[i].setPrefSize(180, 60);		//'0' key of triple width
			else numberButtons[i].setPrefSize(60, 60);			//all keys from '1' to '9'
			numberButtons[i].setOnAction(new OperandHandler());	//attach common handler
		}

		/*set resultLabel */
		resultLabel.setPrefSize(300, 100);
		resultLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, new Insets(5,5,5,5))));
		resultLabel.setStyle("-fx-font-size:25");
		root.add(resultLabel, 0, 0, 5, 1);				//add result field to the top spanning 5 columns at the top row
		resultLabel.setAlignment(Pos.CENTER);

		/*add numeric buttons to the grid */
		int col = 0, row = 1;	
		for (int i = 1; i < numberButtons.length; i++) {
			root.add(numberButtons[i], col++, row);			//in each row, add buttons from col 0 to 2
			if (col % 3 ==0) col = 0;						//switch back to column 0 when col reaches 3
			row = (int)(i/3)+1;								//to make row change after every 3 buttons
		}
		root.add(numberButtons[0], 0, 4, 3, 1);				//add '0' button to the bottom 4th row spanning 3 columns

		/*create all operator buttons */
		operatorButtons[0] = new Button("+");		
		operatorButtons[1] = new Button("-");
		operatorButtons[2] = new Button("*");
		operatorButtons[3] = new Button("/");
		operatorButtons[4] = new Button("=");
		operatorButtons[5] = new Button("Clear");

		/*loop to size operator buttons and attach their event handlers */
		for (int i = 0; i < operatorButtons.length; i++) {
			operatorButtons[i].setStyle("-fx-font-size:20");
			if (i <=3) operatorButtons[i].setPrefSize(60, 60);
			else operatorButtons[i].setPrefSize(180, 60);
			if (i == 4) operatorButtons[i].setOnAction(new EqualsHandler()); 	 	//'=' key
			else if (i == 5) operatorButtons[i].setOnAction(new ClearHandler());	//'Clear' key
			else operatorButtons[i].setOnAction(new OperatorHandler());
		}

		/* add operator buttons one by one to the grid */
		root.add(operatorButtons[0], 3, 1);
		root.add(operatorButtons[1], 4, 1);
		root.add(operatorButtons[2], 3, 2);
		root.add(operatorButtons[3], 4, 2);
		root.add(operatorButtons[4], 3, 3, 2, 1);
		root.add(operatorButtons[5], 3, 4, 2, 1);

	}


	/***************************Your code below this line***********************************************************************/

	/** calculate() takes two operands and one operator
	 * It performs the required operation using switch-case on the operator. 
	 * It returns result in a String using the String.format() method.
	 */
	public String calculate(String op1, String op2, String operator) {
		//write your code here
		String result;
		int opInt1 = Integer.parseInt(op1);
		int opInt2 = Integer.parseInt(op2);
		switch (operator.charAt(0)) {
		case '+':
			result = String.format("%d", opInt1 + opInt2);
			break;
		case '-':
			result = String.format("%d",opInt1 - opInt2);
			break;
		case '*':
			result = String.format("%d",opInt1 * opInt2);
			break;
		case '/':
			result = String.format("%f",(double)opInt1 / (double)opInt2);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + operator.charAt(0));
		}
		return result;
	}

	/** OperandHandler extracts the text from the button pressed. 
	 * Basic scenario: Control may come to this handler for two types of input
	 * 1. Digits in the first operand, i.e. operatorPressed is false. In this case, append the button-text to op1String
	 * 2. Digits in the second operand, i.e. operatorPressed is true. In this case, append the button-text to to op2String
	 * The method appends the operand to the resultLabel for display
	 * 
	 * Advanced scenario: There was a previous operation that was completed but not cleared up because user didn't press Clear.  
	 * The operationComplete is still true. 
	 * In this case, the previous operation's data needs to be cleared up before proceeding. 
	 */
	private class OperandHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			//write your code here
			Button clicked = (Button)event.getSource();
			String op = clicked.getText();
			// reset calculator if previous operation is completed
			if (operationComplete) {
				resultLabel.setText("");
				op1String = new StringBuilder();
				op2String = new StringBuilder();
				operatorPressed = false;
				operationComplete = false;
			}
			if (!operatorPressed) 
				op1String.append(op);
			else 
				op2String.append(op);
			resultLabel.setText(resultLabel.getText() + op);
		}
	}

	/** OpeatorHandler extracts the operator symbol on the buttons that was pressed. 
	 * Basic scenario: The control can come to this handler when the user is entering the operator of an expression 
	 * in which case op1String has already been captured
	 * The method appends the operator to the resultLabel for display
	 * It also sets the operatorPressed to true
	 * 
	 * Advanced scenario: User is entering a negative number as the operand  
	 */
	private class OperatorHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			//write your code here
			Button clicked = (Button)event.getSource();
			String newOperator = clicked.getText();
			if (operatorPressed)
				return;
			if (!operationComplete) {
				operator = newOperator;
				resultLabel.setText(resultLabel.getText() + operator);
				operatorPressed = true;
			}
			else if (newOperator.equals("-")) {
				op1String = new StringBuilder("-");
				resultLabel.setText(newOperator);
				op2String = new StringBuilder();
				operatorPressed = false;
				operationComplete = false;
			}
		}
	}

	/** EqualsHandler invokes calculate() method, passing it the operands and the operator. 
	 * It displays the result in resultLabel.  
	 * It also sets the operatorPressed to false as the operation has now been completed
	 * and sets operationComplete to true  
	 */
	private class EqualsHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			//write your code here
			String result = calculate(op1String.toString(), op2String.toString(), operator);
			resultLabel.setText(result);
			operatorPressed = false;
			operationComplete = true;
		}
	}	

	/** ClearHandler clears up data from previous operation
	 * by clearing up the resultLabel, op1String, op2String, and operator
	 * It also resets operatorPressed and operationComplete to false
	 */
	private class ClearHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			//write your code here
			resultLabel.setText("");
			op1String = new StringBuilder();
			op2String = new StringBuilder();
			operatorPressed = false;
			operationComplete = false;
		}
	}
}
