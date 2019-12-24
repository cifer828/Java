package test;

import java.lang.reflect.*;
import java.util.Scanner;


public class Reflector {
	Class<?> mirror;
	public Reflector(String classname) { //initialize mirror with the Class instance
		try {
			mirror = Class.forName(classname);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println("Enter fully qualified name of a class name e.g. java.util.Date");
		@SuppressWarnings("resource")
		Reflector r = new Reflector((new Scanner(System.in)).nextLine());
		r.reflect();
		r.printMethods();
		r.printConstructors();
		r.printFields();
	}

	public void reflect() {
		String modifiers = Modifier.toString(mirror.getModifiers()); 	//get access modifiers
		if (modifiers.length() > 0) System.out.print(modifiers + " "); //print access modifiers
		System.out.print("class " + mirror.getSimpleName());
		Class<?> superC = mirror.getSuperclass(); // get its super-class
		if (superC != null && superC != Object.class) System.out.print (" extends " +  	superC.getSimpleName());
		System.out.println();
	}

	public void printMethods() {
		System.out.println("********* Methods ************");
		Method[] methods = mirror.getDeclaredMethods(); //array of declared methods  
		for (Method m: methods) {
			String modifiers = Modifier.toString(m.getModifiers()); //access modifiers e.g. public
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			Class<?> returnType = m.getReturnType();  //type returned by the method
			String name = m.getName();//name of method as a string
			System.out.print("   ");
			System.out.print(returnType.getSimpleName() + " " + name + "(");
			Class<?>[] paramTypes = m.getParameterTypes();  //parameters passed to the method
			for (int i = 0; i < paramTypes.length; i++) {
				if (i>0) System.out.print(", ");
				System.out.print(paramTypes[i].getSimpleName());
			}
			System.out.println(");");
		}
	}

	public void printConstructors() {
		System.out.println("********* Constructors ************");
		Constructor<?>[] constructors = mirror.getDeclaredConstructors();
		for (Constructor<?> con : constructors) {
			String modifiers = Modifier.toString(con.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print("   ");
			System.out.print(mirror.getSimpleName() + "(");
			Class<?> [] paramTypes = con.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i>0) System.out.print(", ");
				System.out.print(paramTypes[i].getSimpleName());
			}
			System.out.println(");");
		}
	}

	public void printFields() {
		System.out.println("********* Fields ************");
		Field[] fields = mirror.getDeclaredFields();
		for (Field f : fields) {
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0) System.out.print(modifiers + " ");
			Class<?> type = f.getType();
			String name = f.getName();
			System.out.print("   ");
			System.out.println(type.getSimpleName() + " " + name + ";");
		}
	}
}
