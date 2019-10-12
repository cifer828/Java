package test;

class Auto {
	void drive() {
		System.out.println("Auto driving");
	}
	void fly() {
		
	};
}
class Car extends Auto{
	void drive() {
		System.out.println("Car driving");
	}
}
public class Aircraft extends Auto implements Flyable{
	void drive() {
		System.out.println("Aircraft driving");

	}
	@Override
	public void fly() {
		System.out.println("Aircraft flying");
	}
	public static void main(String[] args) {
		Auto[] autos = new Auto[3];
		autos[0] = new Auto();
		autos[1] = new Car();
		autos[2] = new Aircraft();

		for (Auto auto : autos) {
			auto.drive();
		}
	}

}
interface Flyable {
	void fly();
}
