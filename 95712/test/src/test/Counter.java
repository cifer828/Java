package test;

public class Counter {

int count = 0;

Counter increment() {
count++;
return this; // returning the object itself
}
void printCount() { 
System.out.println("count = " + count); 
}

public static void main(String[] args) {
Counter x = new Counter();
x.increment().increment().increment().printCount(); // what will this print?
}
}
