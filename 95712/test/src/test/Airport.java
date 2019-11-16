package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Airport {
	List<Passenger> passengers = new ArrayList<>();

	public static void main(String[] args) {
		Airport pittsburgh = new Airport();
		pittsburgh.loadPassengers();
		pittsburgh.printInfo();
	}
	void printInfo() {
		Collections.sort(passengers); //natural order
		for(Passenger p : passengers) 
			System.out.println(p.name + " " + p.ticketNumber); 
		System.out.println();
		Collections.sort(passengers, new Passenger()); //custom order
		for(Passenger p : passengers) 
			System.out.println(p.name + " " + p.ticketNumber);
	}
	void loadPassengers() {
		passengers.add( new Passenger ("Sam", 1));
		passengers.add( new Passenger ("Lisa", 2));
		passengers.add( new Passenger ("John", 3));
	}
	class TicketComparator implements Comparator<Passenger> {
		@Override
		public int compare(Passenger p1, Passenger p2) {
			return (p1.ticketNumber - p2.ticketNumber);
		}
	}
}

class Passenger implements Comparable<Passenger> , Comparator<Passenger>{
	String name;
	int ticketNumber;
	public Passenger() {
		// TODO Auto-generated constructor stub
	}
	Passenger(String name, int ticketNumber) {
		this.name = name;
		this.ticketNumber = ticketNumber;
	}
	@Override
	public int compareTo(Passenger p) {
		return name.compareTo(p.name);
	}
	@Override
	public int compare(Passenger p1, Passenger p2) {
		return (p1.ticketNumber - p2.ticketNumber);
	}
}
