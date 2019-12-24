
/**
 * 17683 Data Structures for Application Programmers.
 * Homework Assignment 2 Solve Josephus problem
 * using different data structures
 * and different algorithms and compare running times
 *
 * Andrew ID:
 * @author 
 */
package homework2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Josephus {
    /**
     * Uses ArrayDeque class as Queue/Deque to find the survivor's position.
     *
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithAD(int size, int rotation) {
    	Deque <Integer> adq = new ArrayDeque<Integer>(10000);
    	for (int i = 0; i < size; i++)
    		adq.addLast(i + 1);
    	while(adq.size() > 1) {
    		for (int i = 0; i < rotation - 1; i++) 
    			adq.addLast(adq.removeFirst());
    		adq.removeFirst();
    	}
    	return adq.getFirst();
    }

    /**
     * Uses LinkedList class as Queue/Deque to find the survivor's position.
     *
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithLL(int size, int rotation) {
    	Deque<Integer> lldq = new LinkedList<Integer>();
    	for (int i = 0; i < size; i++)
    		lldq.addLast(i + 1);
    	while(lldq.size() > 1) {
    		for (int i = 0; i < rotation - 1; i++) 
    			lldq.addLast(lldq.removeFirst().intValue());
    		lldq.removeFirst();
    	}
    	return lldq.getFirst();
    }

    /**
     * Uses LinkedList class to find the survivor's position.
     *
     * However, do NOT use the LinkedList as Queue/Deque
     * Instead, use the LinkedList as "List"
     * That means, it uses index value to find and remove a person to be executed in the circle
     *
     * Note: Think carefully about this method!!
     * When in doubt, please visit one of the office hours!!
     *
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithLLAt(int size, int rotation) {
    	LinkedList<Integer> ll = new LinkedList<Integer>();
    	for (int i = 0; i < size; i++)
    		ll.add(i + 1);
    	int start = 0, dead;
    	while(ll.size() > 1) {
    		dead = (start + rotation - 1) % ll.size();
    		ll.remove(dead);
    		start = dead % ll.size();
    	}
    	return ll.get(0);
    }

}
