package test;

public class Hasher {
	public static void main(String[] args) {
		Integer i = new Integer(10);
		Integer j = new Integer(10);

		System.out.println(i.hashCode()); //10
		System.out.println(j.hashCode()); //10
		System.out.println(i.equals(j));  //true
		System.out.println(i==j); 		 //false
	}
}

