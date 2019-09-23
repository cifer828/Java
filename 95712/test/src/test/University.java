package test;
class Person {
String name;
public void sayHello() {
System.out.println("Hello!");
}
}
class Student extends Person{
String studentID;
String[] courses;

public void registerInCourse(String courseID) {
System.out.println("Registered in " + courseID);
}
}
class Professor extends Person{
String employeeID;
String[] courses;

public void teachCourse(String courseID){
System.out.println("Teaching " + courseID);
}
}

public class University {

}
