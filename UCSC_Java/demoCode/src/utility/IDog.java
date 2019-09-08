package utility;

//IDog is an interface which defines what is minimum state and behavior
//a class will have which will implement this interface
public interface IDog {

	int LIFE_EXPECTANCY = 15;
	int MAX_SPEED = 30;
	void fetch();
	void wagTail();
}
