package practice.practice10;

abstract class Pet {
	static int petCount;
	abstract String talk();
}

class Bird extends Pet {
	static int birdCount;

	@Override
	String talk() {
		// TODO Auto-generated method stub
		return "Tweet";
	}
	
}

class Dog extends Pet {
	static int dogCount;

	@Override
	String talk() {
		// TODO Auto-generated method stub
		return "Bark";
	}
	
}

class Cat extends Pet {
	static int catCount;

	@Override
	String talk() {
		// TODO Auto-generated method stub
		return "Meow";
	}
	
}
