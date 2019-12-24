# Java学习笔记

## 1. 字符串对齐输出

> **Date:** 05/12/2019
>
> **Src:** UCSC-JAVA-HW2
>
> **Ref:** [c语言 %s用法](https://zhidao.baidu.com/question/240193538094311444.html )

### Code
```Java
System.out.printf("%-16s\n", "align left");
System.out.printf("%16s", "align right");
```
### Output
```
align left  
align right
```

## 2. 类执行顺序

> **Date:** 05/27/2019
>
> **Ref:** [Java中的static关键字解析](https://www.cnblogs.com/dolphin0520/p/3799052.html )

### Code

```java
public class Test {
	Person person = new Person("Test"); // 2.5
	static{
		System.out.println("test static"); // 1
	}
	
	public Test() {
		System.out.println("test constructor"); // 5
	}
		
	public static void main(String[] args) {
		new MyClass();  // 1.5
	}
}
class Person{
	static{
		System.out.println("person static"); // 3
	}
	public Person(String str) {
		System.out.println("person "+str); // 4  6
	}
}
class MyClass extends Test {
	Person person = new Person("MyClass"); // 5.5 
	static{
		System.out.println("myclass static"); // 2
	}
		
	public MyClass() {
		// super()  // implicit  //
		System.out.println("myclass constructor"); // 7
	}
}
```

### Output
```
test static			// main在Test类 -> 加载Test类的Static
myclass static 	    // -> 执行main方法 -> new MyClass() -> 加载MyClass -> (先加载父类Test，但已经加载 ->) 执行MyClass的Static 
person static		// -> 初始化父类Test() -> 初始化成员person=new Person("Test") -> 加载Person类 -> 执行Person类的Static
person Test			// -> new Person("Test")对象 -> 调用Person构造方法
test constructor	// -> new MyClass()-> 初始化父类Test -> 调用Test构造方法
person MyClass		// -> 初始化MyClass -> 初始化成员person=new Person("MyClass") -> 调用Person构造方法
myclass constructor	// -> 调用MyClass构造方法
```

## 3. Input缓存

> **Date:** 05/27/2019

> **Src:** UCSC-JAVA-HW5


### Code
```Java
Scanner readInput = new Scanner(System.in);
do{
	try{
		int yourChoice = readInput.nextInt();
		if(yourChoice < 6 && yourChoice > 0){
			System.out.printf("\nYou entered valid choice %d\nThank you for giving your choice\n", yourChoice);
			break;	// quit the loop
		}
		else	// input out of range
		{
			System.out.println("You have not entered a number between 1 and 5. Try again.");
			System.out.printf("Enter your choice between 1 and 5 only:");
		}
	}
	catch(InputMismatchException e)	// input wrong data type
	{
		System.out.println("You have entered an invalid choice. Try again.");
		readInput.next(); // gobble up the wrong input
		System.out.printf("Enter your choice between 1 and 5 only:");
	}
	
}while(true);
readInput.close();
```

next()以空格/空行/制表符为分界
```
Enter your choice between 1 and 5 only:ss 11 1
You have entered an invalid choice. Try again.

Enter your choice between 1 and 5 only:You have not entered a number between 1 and 5. Try again.

Enter your choice between 1 and 5 only:
You entered valid choice 1

Thank you for giving your choice
```

catch中的输出变为下一次循环的输入，不加readInput.next() 程序会无限循环
```
Enter your choice between 1 and 5 only:rr
You have entered an invalid choice. Try again.

Enter your choice between 1 and 5 only:You have entered an invalid choice. Try again.

Enter your choice between 1 and 5 only:You have entered an invalid choice. Try again.
```

> Update 11/01/2019

> **Difference between next() and nextLine()**
> 
> next() reads content after the delimiter, or say it gobbles the delimiter before content, but leave the after delimiter
> 
> nextLine() read the content before the delimiter ("\n")

Eg. 1
```
/* scannerTest1.txt */
,123,
```
```Java
input = new Scanner(new File("scannerTest1.txt"));
System.out.println(input.useDelimiter(",").next());
System.out.println(input.useDelimiter(" ").next());
input.close();
```
```
Output:

123 // next() gobble the first comma
,   // leaves the second comma still in the stream
```
Eg. 2
```
/* scannerTest2.txt */
     // empty line
123
456
```
```Java
// Snippet 1: read lines using next()
input = new Scanner(new File("scannerTest2.txt")).useDelimiter("\n");
System.out.println(input.next());
System.out.println(input.next());
input.close();
// Snippet 2: read lines using nextLine()
input = new Scanner(new File("scannerTest2.txt"));
System.out.println(input.nextLine());
System.out.println(input.nextLine());
input.close();
```
```
Snippet 1 Output:
123   // gobble the first "\n"
456
Snippet 2 Output:
      // read an empty line before "\n"
123
```
## 4. Converting numeric values
### short data type to long data type
```Java
int intValue = 22;
long longValue = intvalue;
System.out.println("longValue is " + longValue);
```
```
longValue is 22;
```
### short data type to long data type (beyond range)
```Java
int intValue = 1022;
byte byteValue = (byte) intValue; // need cast to long data type
System.out.println("byteValue is " + byteValue); // drop the highest bits to fit new data type
```
``` 
byteValue is -2 // since byte's range is -128 to 127;
```

## 5. Default value
Local variables must be initialized before used, while variables outsied method can have a default value.

## 6. New switch in Java 12
When using new switch in java12, use ```@SuppressWarnings("preview")``` to hide warnings "preview".  
``` Java
// lambda in switch, ignore break;
public class X {
    @SuppressWarnings("preview")
	public void foo(int i) {
    	switch (i) {
    		case  2 -> System.out.println("Hello");
    		default ->  System.out.println("World");
    	}
    }
    public static void main(String[] argv) {
        new X().foo(2);
    }
}
```

``` Java
// use switch when assigning value
public class Test {
	enum Day {
		MON, TUE, WED, THUR, FRI, SAT, SUN
	};
 
	@SuppressWarnings("preview")
	public String getDay_1 (Day today) {
		String day = switch(today) {
			case MON, TUE, WED, THUR, FRI -> "Weekday";
			case SAT, SUN -> "Weekend";
		};
		return day;
	}
}
```

## 7. Regular Expression in Java
> Different from Python
> 
> Use ```//s``` instead of ```/s``` (/d, /D, etc)
> 
> **Don't** use / inside [], e.g. ```[.]``` means a point ".", use ```[^]``` to match "^", **not** ```[\^]```
``` Java
// match a float number
token.matches("[+-]?[0-9]+[^]?[0-9]*")
```

## 8. New Array/ArrayList without reference
### New ArrayList
``` Java
// right way
return new ArrayList<Integer>(Arrays.asList(1,2,4,5));

// blow code will cause error, since int[] is no subtype of Object[]
// but String[] array = {"1", "2", "3", "4", "5"} is OK
int[] array = {1, 2, 4, 5};
new ArrayList<Integer>(Array.asList(array));
```
### New Array
``` Java
return new int[] {1,2,3};
```

## 9. Variables Initialization
> **Field variables** are initialized to default values
> 
> Static or instance variable inside class

>  **Local Variables** need to be initialized in the methods.

## 10. Aggregation & Composition
### Not important in Java
### Aggregation A->B: 
> 1. A has B. If A disapears, B still survive.
> 
> 2. B can be shared with C.
### Composition A->B:
> 1. A has B. But if A disapears, B doesn't survive.
> 
> 2. B cannot be shared with C.

## 11. Abstract child can inherent concrete class

```Java

abstract class AbstractChild extends NormalFather {
	abstract void abstractMethod();
}

class GrandChild extends AbstractChild {
	void abstractMethod() {
		System.out.println("AbstractChild");
	}
}

public class NormalFather {
	public static void main(String[] args) {
		GrandChild gc = new GrandChild();
		gc.abstractMethod();
	}
}
```
```
AbstractChild
```

## 12. Non-default constructor
### If father class has a non-default constructor, then its default construtor no longer exist. 

```Java
class Child extends Father {
	Child(int f) {
		super(f); // must call super(f) explicitly, since default super() is no longer exist.
	}
}


public class Father {
	int f;
	Father(int f){
		this.f=f;
	}
	public static void main(String[] args) {
		Child c = new Child(1); // must initialize the class using non-default constructor
	}
}
```

## 13. Composition, Aggragation
### Only in logic level. 
### Don't present in code.
### Composition $\neq$ inner class

## 14. Upcasting in Polyphormic
>I. object's members and methods name should be consistant with father class. If father don't have that member or method, compile errors occurs.
> 
>II. Member values and method contents is from **Inherent** member child class.

### Example 1: Same member names in father and child. 
```Java
public class PolymorphicZoo {
	public static void main(String args[]) {
		Animal animal = new Tiger();
		System.out.println(animal.type);
		// Output: Animal
		// Tiger's type does NOT inherit from Animal's type, so they are different though sharing the same name.
		// If Animal don't have member type, there will be complie error
	}
}

class Animal {
	String type = "Annimal";
}
class Tiger extends Animal {
	// Tiger has two types, this.type = "Tiger", super.type = "Animal"
	String type = "Tiger";
}
```

### Example 2: Child changes member's value of father
```Java
public class PolymorphicZoo {
	public static void main(String args[]) {
		Animal animal = new Tiger();
		System.out.println(animal.type);
		// Output: Tiger
	}
}

class Animal {
	String type = "Annimal";
	Animal(String type) {
		this.type = type;
	}
}
class Tiger extends Animal {
	String type = "Unknown";
	// Tiger change super.type using non-default constructor
	Tiger() {
		super("Tiger");
	}
}
```

## 15. Interface
> I. All methods and members are implicitly **public**
> 
> II. I. All members are **public static final**
> 
> III. Default methods is **not have to** be overiden by class. 
> 
> IV. Default methods can be overiden to abstract method.
``` Java
interface Interface {
	String a = "aa";
	default void DefaultMethod() {
		System.out.println(a);
	}
}
interface InterfaceB extends Interface{
	// Override a default method to abstract method in interface
	@Override
	void DefaultMethod();
}
abstract class AbstratClass implements Interface {
	// Override a default method to abstract method in class
	@Override
	public abstract void DefaultMethod();
}
class InterfaceDefaultMethod implements Interface {
	public static void main(String[] args) {
		InterfaceDefaultMethod idm = new InterfaceDefaultMethod();
		idm.DefaultMethod();
		// idm.a = " "; // Compile error: The final field Interface.a cannot be assigned
	}
}
```

## 16. InvalidationListener
> I. Change dependency will make binding invalid
> 
> II. Listener method will be called when binding is changed from valid to invalid
```Java
public static void main(String[] args) {

    SimpleIntegerProperty one = new SimpleIntegerProperty(1);
    SimpleIntegerProperty two = new SimpleIntegerProperty(0);

    // the binding we are interested in
    NumberBinding sum = one.add(two);
    sum.addListener(observable -> System.out.println("invalidated"));

    // if you add a value change listener, the value will NOT be evaluated lazy anymore
    //sum.addListener((observable, oldValue, newValue) -> System.out.println("value changed from " + oldValue + " to " + newValue));

    // is valid, since nothing changed so far
    System.out.println("sum valid: " + sum.isValid());
    // will invalidate the sum binding
    two.set(1);
    one.set(2); // invalidation event NOT fired here!
    System.out.println("sum valid: " + sum.isValid());
    // will validate the sum binding, since it is calculated lazy when getting the value
    System.out.println("sum: " + sum.getValue());
    System.out.println("sum valid: " + sum.isValid());
}
```
output
```
sum valid: true
invalidated
sum valid: false
sum: 6
sum valid: true
```

## 17. TreeSet v.s HashSet
### When doing set.add(object), TreeSet use compareTo() to determine duplicate, but HashSet use equals()/hashCode()