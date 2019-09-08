package utility;

public class FancyBox extends OldBox {
 
	private String boxName = "Default Fancy Box";
	
	//accessor method
	public String getName() {
		return boxName;
	}

	//mutator method
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}

	public void drawSuperSizingYourself(int howBig) {
		// TODO Auto-generated method stub
		super.sethSize(super.gethSize() * howBig);
		super.setvSize(super.getvSize() * howBig);
		
		super.drawYourSelf();
	}

	//overridden drawYourself
	public void drawYourSelf()
	{
		//default box
		drawHLine(super.gethSize(), super.gethStr());
		System.out.printf("\n");
		drawVLine(super.gethSize(), super.getvSize(), super.getFillerStr(), super.getvStr());
		drawHLine(super.gethSize(), super.gethStr());
		System.out.printf("\n");

	}
	
	@Override
	public String toString() {
		String str;
		
		str = super.toString() + "\n Box Name Is: " + boxName;
		return str;
	}

	public FancyBox() {
		// TODO Auto-generated constructor stub
	}

	
	public FancyBox(int hSize, int vSize, String hStr, String vStr,
			String fillerStr) {
		super(hSize, vSize, hStr, vStr, fillerStr);
		// TODO Auto-generated constructor stub
	}

	public FancyBox(int h, int v) {
		super(h, v);
		// TODO Auto-generated constructor stub
	}

}
