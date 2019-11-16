package lab7;

import java.util.Objects;

public class Student {
	String id;
	String name; 
	String major;
	
	public Student(String id, String name, String major) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.major = major;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id, name, major);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) { return false; }
		if (this == obj) { return true; }
		if (this.getClass() != obj.getClass()) {return false; }
		Student s = (Student)obj; 
		return this.id.equals(s.id) && this.name.equals(s.name) && this.major.equals(s.major);
	}
}
