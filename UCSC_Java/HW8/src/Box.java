import java.util.InputMismatchException;
import java.util.Scanner;

public class Box {
	private char hChar, vChar;
	private int height, width;
	char answer = 'y';
	private void drawHorizontalLine() {
		// draw horizontal line
		int count = 0;
		while (count++ < width)
			System.out.print(hChar);
		System.out.printf("\n");
	}
	private void drawVerticalLines() {
		// draw vertical line
		int count = 0, count2 = 0;
		while (count++ < height) {
			System.out.print(vChar);
			count2 = 0;
			while (count2++ < width - 2)
				System.out.printf(" ");
			System.out.printf(vChar + "\n");
		}
	}
	public void getPara(){
		// ask user to enter width, height, vertical and horizontal char
		Scanner userInput = new Scanner(System.in);
		while(true){
			try{
				System.out.print("Please enter width and height of a box(2 Integers splited by space):");
				width = userInput.nextInt();
				height = userInput.nextInt();
				break;
			}
			catch(final InputMismatchException e){
				System.out.println("You entered an invalid number, please re-enter.");
				userInput.nextLine();
			}
		}
		userInput.nextLine();
		System.out .print("Please enter the horizontal charcters to draw box: ");
		hChar = userInput.nextLine().charAt(0);
		System.out .print("Please enter the vertical charcters to draw box: ");
		vChar = userInput.nextLine().charAt(0);
		userInput.close();
	}
	public void drawBox(){
		// draw box
		drawHorizontalLine();
		drawVerticalLines();
		drawHorizontalLine();
	}
	public static void main(String[] args){
		Box myBox = new Box();
		myBox.getPara();
		myBox.drawBox();
	}

}
