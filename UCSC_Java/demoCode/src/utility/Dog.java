package utility;

//Dog is a class which implements IDog inerface
public class Dog implements IDog {

	/**
	 * @param args
	 */
	public void wagTail() {
		System.out.println("Let me wag my tail");
	}
	
	public void fetch(){
		System.out.println("I am fetching");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

//Lab is subclass of Dog class and Implements IK9 interface
class Lab extends Dog implements IK9 {
	public void waitHere() {
		System.out.println("Wait Here");
	}
}