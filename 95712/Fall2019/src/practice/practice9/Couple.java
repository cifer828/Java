package practice.practice9;

class Couple extends Guest{
	static int coupleCount;
	Couple(){
		coupleCount++;
	}
	@Override
	void placeOrder() {
		// TODO Auto-generated method stub
		servings = new int[] {2,1,1,2,1};
	}

}
