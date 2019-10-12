package test;

interface Interface {
	String a = "aa";
	default void DefaultMethod() {
		System.out.println(a);
	}
}
interface InterfaceB extends Interface{
	// Override a default method to abstract method in interface
	@Override
	void DefaultMethod();
}
abstract class AbstratClass implements Interface {
	// Override a default method to abstract method in class
	@Override
	public abstract void DefaultMethod();
}
class InterfaceDefaultMethod implements Interface {
	public static void main(String[] args) {
		InterfaceDefaultMethod idm = new InterfaceDefaultMethod();
		idm.DefaultMethod();
		// idm.a = " "; // Compile error: The final field Interface.a cannot be assigned
	}
}
