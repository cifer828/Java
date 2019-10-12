package practice.practice9;

class Group extends Guest{
	static int groupCount;
	Group(){
		groupCount++;
	}
	@Override
	void placeOrder() {
		servings = new int[]{4, 3, 3, 4, 3};
	}
	
}
