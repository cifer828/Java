package practice.practice9;

class Family extends Guest{
	static int familyCount;
	Family(){
		familyCount++;
	}
	@Override
	void placeOrder() {
		// TODO Auto-generated method stub
		servings = new int[] {4,2,3,4,2};
	}
}
