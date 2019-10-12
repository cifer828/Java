package practice.practice9;

class Individual extends Guest{
	static int individualCount;
	Individual() {
		individualCount++;
		guestType = "Individual";
	}
	@Override
	void placeOrder() {
		servings = new int[] {1,1,0,1,0};
	}
}
