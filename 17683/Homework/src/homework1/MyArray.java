package homework1;


public class MyArray {
	private int size;
	private String[] string;
	private final static int DEFAULTSIZE = 10;
	// Default constructor, default size is 10
	public MyArray() {
		this(DEFAULTSIZE);
	}
	
	// Non default constructor, if input size is 0, don't initialize the string array
	public MyArray(int initialCapacity){
		if (initialCapacity < 0)
			string = new String [DEFAULTSIZE];
		else
			string = new String [initialCapacity];
		size = 0;
	}
	
	// add string to the list
	public void add(String text) {
		if (valid(text)) {
			ensureCapacity(size + 1);
			string[size++] = text;
		}
	}
	
	public boolean search(String key) {
		for (String s: string) {
			if (s.equals(key))
				return true;
		}
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public int getCapacity() {
		return string.length;
	}
	
	public void display() {
		for(int i = 0; i < size; i++)
			System.out.print(string[i] + " ");
		System.out.println();
	}
	
	public void removeDups() {
		for (int i = 0; i < size; i++) {
			if (checkDups(string, i, string[i]))
				remove(i--);
		}
	}
	
	/*** Helpers ***/
	
	private boolean valid(String s) {
		if (s == null || s.length() == 0) return false;
		for (char c: s.toCharArray()) {
			if ( (c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a'))
				continue;
			else {
				return false;
			}
		}
		return true;
	}
	
	// check if elements before end in the array has key string
	private boolean checkDups(String [] input, int end, String key) {
		for (int i = 0; i < end; i++) {
			if (input[i].equals(key))
				return true;
		}
		return false;
	}
	
	private void remove(int idx) {
		if (idx >= 0 && idx < size) {
			System.arraycopy(string, idx + 1, string, idx, size - idx - 1);
			size--;
			string[idx] = null; // Otherwise the print function won't be right
		}
		
	}
	
	// extend the underline array
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = string.length;
		int newCapacity;
		if (minCapacity > oldCapacity) {
			if (oldCapacity == 0)
				newCapacity = 1;
			else
				newCapacity = oldCapacity * 2;
			String [] newString = new String[newCapacity];
			System.arraycopy(string, 0, newString, 0, oldCapacity);
			string = newString;
		}
	}
}
