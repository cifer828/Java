package test;

class Grandfather {
	String name = "grandfater";
}

class Child extends Father {
	Child(int f) {
		super(f); // must call super(f) explicitly, since default super() is no longer exist.
		System.out.println(super.name);
	}
}


public class Father extends Grandfather {
	int f;
	Father(int f){
		this.f=f;
	}
	public static void main(String[] args) {
		Child c = new Child(1); // must initialize the class using non-default constructor
	}
}
