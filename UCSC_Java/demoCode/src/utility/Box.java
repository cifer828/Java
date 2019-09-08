package utility;

public class Box {

	// accessibility
	public Box() {
		hSize2 = 10;
	} // everywhere class is accessible

	int hSize; // default accessibility = package
	int vSize; // also knows as Package FRIENDLY memebers
	protected char flChar; // in subclasses as well, private to others
	private String name; // accessible only in the class

	// static variables are called class variable (instead of instance variable)
	// there is only one copy of this variable available for all objects
	// instantiated
	// from this class
	static private int hSize1;

	static public int getStaticHSize() {
		return hSize1;
	}

	static public String name1 = "I am a box";

	// Final - blank final
	final int hSize2; // blank final variable must be defined by all contructors
						// remember only one constructor will be called for
						// instantiating an object
						// so, code ot intialize the blank final will be
						// repeated in all constructors
	int vSize2;

	Box(int h) {
		hSize2 = h; // this is right, you can initialize this blank final
					// variable, only once.
		vSize2 = 10;
	}

	public void SethSize(int h) {
		// hSize2 = h; // wrong ? you have already initalized the blank final by
		// the constructor, so, can't do it
	}

	// final method arguments
	public void setvSize(final Box b) {
		// b = new Box(5); //wrong b is final
		b.vSize = 20; // fine, be is final, not members
	}

	// use this key word for

	// name conflict
	public void sethSize3(int hSize) {
		hSize = hSize; // which hSize? Confusing
		this.hSize = hSize; // avoids name conflict
	}

	// pass this to method
	private void passBoxObject(Box b) {
	}

	public Box(int hSize, int vSize) {
		hSize2 = 10;
		passBoxObject(this); // call another method
	}

	// Intializer in Java

	int height = 10;
	int width = 20;
	String hStr = "-";
	String vStr = "|";
	String fillStr = " ";
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the hStr
	 */
	public String gethStr1() {
		return hStr;
	}

	/**
	 * @param hStr the hStr to set
	 */
	public void sethStr(String hStr) {
		this.hStr = hStr;
	}

	/**
	 * @return the fillChar
	 */
	public String getFillStr() {
		return fillStr;
	}

	/**
	 * @param fillChar the fillChar to set
	 */
	public void setFillStr(String fillChar) {
		this.fillStr = fillChar;
	}

	/**
	 * @param hSize the hSize to set
	 */
	public void sethSize(int hSize) {
		this.hSize = hSize;
	}

	static String boxName;
	// or this - just before constructors
	{
		vStr = "*";
	}
	// static initializer
	static {
		boxName = "Default Box";
	}

	// Method Overloading

	public void changeDimension(String vStr) {
		this.vStr = vStr;
	}

	public void changeDimension(String vStr, int vSize) {
		this.vStr = vStr;
		this.vSize = vSize;
	}

	// constructor overoading

	// public Box() {}; //empty constructor
	// better way to initialize as the user get more choices
	public Box(int hSize, int vSize, String hStr) // overloaded constructor
	{
		height = hSize;
		width = vSize;
		hSize2 = hSize; //because it is static, must be inialized in each constructor 
	}

	public Box(String hStr, String vStr, int hSize, int vSize) // overloaded
																	// constructor
	{
		this(hSize, vSize); // call another constructor, must be first call
		                    //and it initializes the static variables
		this.hStr = hStr; // use this reference to avoid name conflict
		this.vStr = vStr;
	}

	//accessor methods
	public String gethStr(){
		return hStr;
	}
	public String getvStr(){
		return vStr;
	}
	public String getFillerStr(){
		return fillStr;
	}
	public int gethSize(){
		return hSize;
	}
	public int getvSize(){
		return vSize;
	}
	
	//from OldBox
    //more methods which describes the behavior
	protected void drawHLine(int h, String hStr){
		int i = 0;
		while (i++  < h)
			System.out.print(hStr);
	}

	protected void drawVLine(int h, int v, String hStr, String vStr) {
		int i = 0, j=0;
		while (i++ < v - 2) {
			System.out.print(vStr);
			drawHLine(h-2, hStr);
			System.out.println(vStr);
		}
	}
	
	public void drawYourSelf()
	{
		//default box
		drawHLine(height, hStr);
		System.out.printf("\n");
		drawVLine(height, width, fillStr, vStr);
		drawHLine(height, hStr);
		System.out.printf("\n");
	}
	
	//used in println or string concatenation
	public String toString() {
		String str;
		
		str =   "\n Horizontal Size: " + gethSize() +
				"\n Vertical Size: " + getvSize() +
				"\n Filler String: " + getFillerStr() +
				"\n Horizontal String: " + gethStr() +
				"\n Vertical String: " + getvStr();
		return str;
	}


	public static void main(String[] args) {

		// accessing static variables from outside world where the Box class is
		// accessible you don't need to have an object of Box time, you can
		// directly use the class name as static variables are called class variables
		int horizontalSize = Box.getStaticHSize();
		String boxName = Box.name1;

		// Test Final
		Box defaultBox = new Box(10);
		final Box smallBox = new Box(5);
		// defaultBox.hSize2 = 20; //wrong, hSize is final

		// smallBox = defaultBox ; // wrong, smallBox is final
		smallBox.vSize2 = 30; // fine, smallBox reference is final, not vSize

		// overloaded constructor
		Box b; // is ok
		// however
		b = new Box(); // will not be Ok, if you specifically defined a default
						// (empty) constructor
						// that can happen if create on constructor and not the
						// default constructor
		b = new Box(10, 20); // ok

		//draw the boxes
		Box myBox= new Box();
				
	    b.drawYourSelf();
	    b.setFillStr("$");
	    //draw a box fileed wit dollars
	    b.drawYourSelf();
	}

}
