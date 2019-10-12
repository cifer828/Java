package test;

public class PolymorphicZoo {
	public static void main(String args[]) {
		Animal animal = new Tiger();
		Animal a2 = new Cat();
		System.out.println(Tiger.count);
		System.out.println(Cat.count);
		System.out.println(Animal.count);
	}
}

abstract class Animal {
	String type = "Annimal";
	static int count;
	Animal(String type) {
		this.type = type;
	}
}
class Tiger extends Animal {
	String type = "Unknown";
	static int count;
	Tiger() {
		super("Tiger");
		count++;
	}
}
class Cat extends Animal {
	String type = "Unknown";
	static int count;
	Cat() {
		super("Cat");
		count++;
	}
}
