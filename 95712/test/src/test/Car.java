package test;
class Vehicle {
private int noOfWheels;
private String color;

Vehicle(String color) {
this.color = color;
}

// rest as above

}

class Car extends Vehicle {
private String make, model;

Car(String model, String make, String color){
super(color);		// must invoke super constructor
this.make = make;
this.model = model;
//this.setNoOfWheels(4); //method inherited from Vehicle
}

}
