import java.util.Scanner;

public class Homework4 {

	public static void excercise_4_1(){
		// homework 4.1
//		int i = 0;
//		while (i++ < 10) {
//		System.out.println("Hello World: " + i);
//		}
//
//		i = 0;
//		while (++i < 10) {
//			System.out.println("Hello World: " + i);
//		}
//		
//		while (++i < 10) {
//			System.out.println("Hello World: " + i);
//		}
		System.out.println("Answers:");
		System.out.println("loop is executed 10 times in #a");
		System.out.println("loop is executed 9 times in #b");
		System.out.println("loop is executed 0 times in #c");
	}
	
	public static void excercise_4_2(){
		//homework 4.2, use while loop
		int width = 20;
		int height = 10;
		int total_num = width * height;
		int i = 0;
		while(i++ < total_num){
			if(i < width + 1 || i > width * (height - 1)){
				System.out.print('-');
			}
			else if(i % width == 0 || i % width == 1){
				System.out.print('|');
			}
			else{
				System.out.print(' ');
			}
			if (i % width == 0){
				System.out.print('\n');
			}
		}
	}
	
	public static void excercise_4_3(){
		//homework 4.3 use do-while loop
		int width = 20;
		int height = 10;
		int total_num = width * height;
		int i = 1;
		do{
			if(i < width + 1 || i > width * (height - 1)){
				System.out.print('-');
			}
			else if(i % width == 0 || i % width == 1){
				System.out.print('|');
			}
			else{
				System.out.print(' ');
			}
			if (i % width == 0){
				System.out.print('\n');
			}
		} while(i++ < total_num);
	}
	
	
	public static void excercise_4_4(){
		//homework 4.4, use for loop
		int width = 20;
		int height = 10;
		int total_num = width * height;
		for(int i=1; i<=total_num; i++){
			if(i < width + 1 || i > width * (height - 1)){
				System.out.print('-');
			}
			else if(i % width == 0 || i % width == 1){
				System.out.print('|');
			}
			else{
				System.out.print(' ');
			}
			if (i % width == 0){
				System.out.print('\n');
			}
		}
	}
	
	public static void excercise_4_5(){
		//homework 4.5
		char cont;
		int width;
		int height;
		char horChar;
		char vertChar;
		Scanner readInput = new Scanner(System.in);
		System.out.println("Enter the width and height of the box, separated by space: ");
		width = readInput.nextInt();
		height = readInput.nextInt();
		int total_num = width * height;
		System.out.println("Enter the horizontal and vertical characters, separated by space: ");
		horChar = readInput.next().charAt(0);
		vertChar = readInput.next().charAt(0);
		for(int i=1; i<=total_num; i++){
			if(i < width + 1 || i > width * (height - 1)){
				System.out.print(horChar);
			}
			else if(i % width == 0 || i % width == 1){
				System.out.print(vertChar);
			}
			else{
				System.out.print(' ');
			}
			if (i % width == 0){
				System.out.print('\n');
			}
		}

	}
	
	public static void excercise_4_6(){
		//homework 4.6
		char cont;
		int width;
		int height;
		char horChar;
		char vertChar;
		do{
			Scanner readInput = new Scanner(System.in);
			System.out.println("Enter the width and height of the box, separated by space: ");
			width = readInput.nextInt();
			height = readInput.nextInt();
			int total_num = width * height;
			System.out.println("Enter the horizontal and vertical characters, separated by space: ");
			horChar = readInput.next().charAt(0);
			vertChar = readInput.next().charAt(0);
			for(int i=1; i<=total_num; i++){
				if(i < width + 1 || i > width * (height - 1)){
					System.out.print(horChar);
				}
				else if(i % width == 0 || i % width == 1){
					System.out.print(vertChar);
				}
				else{
					System.out.print(' ');
				}
				if (i % width == 0){
					System.out.print('\n');
				}
			}
			System.out.print("Continue? Type 'y' for yes: ");
			cont = readInput.next().charAt(0);
			}
		while(cont == 'y');
		System.out.println("Exit");
	}
	
	public static void main(String[] args) {
		System.out.println("----------Homework 4.1-----------");
		excercise_4_1();
		System.out.println("----------Homework 4.2-----------");
		excercise_4_2();
		System.out.println("----------Homework 4.3-----------");
		excercise_4_3();
		System.out.println("----------Homework 4.4-----------");
		excercise_4_4();
		System.out.println("----------Homework 4.5-----------");
		excercise_4_5();
		System.out.println("----------Homework 4.6-----------");
		excercise_4_6();
	}

}
