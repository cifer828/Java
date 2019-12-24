package test;

import java.lang.reflect.Method;

public class Movie {
	public static void main(String[] args) {
		SpongeBob SquarePants = new SpongeBob();
		Movie movie = new Movie();
		movie.cook(SquarePants.getClass());
	}
	void cook(Class<?> c) {
		try {
			Object o = c.getDeclaredConstructor().newInstance(); //c.newInstance() is deprecated since Java 9 
			Method method = c.getDeclaredMethod("cookFood");
			method.invoke(o);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
class SpongeBob {
	void cookFood() {
		System.out.println("Cooking food");
	}
	void cookTrouble() {
		System.out.println("Cooking trouble");
	}
}
