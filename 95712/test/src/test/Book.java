package test;

public class Book implements Comparable{
	String title;
	float price;
	Book(String title, float price) {
		this.title = title;
		this.price = price;
	}
	@Override
	public int compareTo(Object o) {
		return (int)(this.price - ((Book)o).price);
	}


	public static void main(String[] args) {
		Book b1 = new Book ("Core Java", 45.5f);
		Book b2 = new Book ("Head First Java", 45.6f);
		System.out.println(b1.compareTo(b2));
	}
}
