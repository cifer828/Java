package utility;

public class OldBox extends Shape {
//	public class Box Shape { //we edited it to later to extend from Shape
    //state
	private int hSize = 20;
	private int vSize = 10;
	private String hStr = "-";
	private String vStr = "|";
	private String fillerStr = " ";
	
	public String getName() {return "";};
	//empty/default constructor
	public OldBox() {
	}
	
	//other constructors
	public OldBox(int hSize, int vSize, String hStr, String vStr, String fillerStr) {
		super();
		this.hSize = hSize;
		this.vSize = vSize;
		this.hStr = hStr;
		this.vStr = vStr;
		this.fillerStr = fillerStr;
	}

	public OldBox(int h, int v){
		hSize = h;
		vSize = v;
	}
	
	//accessor methods
	public int gethSize() {
		return hSize;
	}

	public int getvSize() {
		return vSize;
	}

	public String gethStr() {
		return hStr;
	}

	public String getvStr() {
		return vStr;
	}

	public String getFillerStr() {
		return fillerStr;
	}

	//mutator methods
	public void sethSize(int hSize) {
		this.hSize = hSize;
	}

	public void setvSize(int vSize) {
		this.vSize = vSize;
	}

	public void sethStr(String hStr) {
		this.hStr = hStr;
	}

	public void setvStr(String vStr) {
		this.vStr = vStr;
	}

	public void setFillerStr(String fillerStr) {
		this.fillerStr = fillerStr;
	}
    
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
		drawHLine(hSize, hStr);
		System.out.printf("\n");
		drawVLine(hSize, vSize, fillerStr, vStr);
		drawHLine(hSize, hStr);
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
}



