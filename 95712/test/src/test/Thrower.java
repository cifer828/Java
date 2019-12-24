package test;

import java.io.IOException;

public class Thrower {
	public static void main(String[] args) {
		int x=1;  //note the change
		try {
			if (x ==0) throw (new MyException1());
			else throw (new MyException2());
		} catch (MyException1 e1) {
			System.out.println("MyException1 caught");
		} catch (MyException2 e2) {
			
			System.out.println("MyException2 caught");
			try {
				
			}
			catch (Exception e3) {
				throw e3;
			}
		} catch (Exception e) {
			System.out.println("Exception caught");
		}
		finally {
			System.out.println("Exiting try block");
		}
	}
}

class MyException1 extends Exception{
	MyException1() {
		System.out.println("MyException1 thrown");
	}
}

class MyException2 extends IOException {
	MyException2() {
		System.out.println("MyException2 thrown");
	}
}

