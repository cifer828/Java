package utility;

public class OOPBox {
	//blank-final
	int vSize=20;
	//initializers
	int hSize = 10;
	String hChar = "*";
	String vChar;
	
	static String boxName;
	
	{vChar = "*";}
	static {boxName = "I am a OOPBOX";}
	
	OOPBox (int h) {
		hSize = h;
		vSize = 10; //default value
	}

	//method overlaoding -- 
	//method overriding 
	//this pointer
	
	public void sethSize (int hSize){
		this.hSize = hSize;
	}
	
	public static void main(String [] args){
		
		final OOPBox defaultBox = new OOPBox(10);
		OOPBox bigBox = new OOPBox(5);
		OOPBox smallBox;
		smallBox = defaultBox;
		//defaultBox = bigBox;  //wrong
		defaultBox.vSize = 20;
		System.out.println("Hello World");
		}
}