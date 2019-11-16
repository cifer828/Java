package test;

public class VarDemo {
	public static void main(String[] args) {
		VarDemo varDemo = new VarDemo();
		varDemo.doSomething();
	}
	void doSomething() {
		var someClass = new Object (){
			void printSomething() {
				System.out.println("Something");
			}
		};
//		SomeClass someClass = new SomeClass();
		someClass.printSomething();
	}
}
