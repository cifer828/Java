package test;

public class stringAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "old";
		String t = s;
		System.out.println(s + "'s address is" + s.hashCode());
		s = s.concat("tonew");
		System.out.println(t == s);

	}

}
