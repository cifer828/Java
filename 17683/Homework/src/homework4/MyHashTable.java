package homework4;


/**
 * 17683 Data Structures for Application Programmers.
 * Homework Assignment 4: HashTable Implementation with linear probing
 *
 * Andrew ID:
 * @author
 */
public class MyHashTable implements MyHTInterface {
    private final static int DEFAULTCAPACITY = 10;
    private final static double LOADFACTOR = 0.5;
    private static final DataItem DELETED = new DataItem("0", 1);
    private int size;
    private int collision;
    
    /**
     * The DataItem array of the table.
     */
    private DataItem[] hashArray;

    // TODO implement constructor with no initial capacity
    public MyHashTable() {
		// TODO Auto-generated constructor stub
    	this(DEFAULTCAPACITY);
	}

    // TODO implement constructor with initial capacity
    public MyHashTable(int capacity){
    	if (capacity <= 0)
    		throw new IllegalArgumentException("Incorrect hashTable capacity");
    	hashArray = new DataItem[capacity];
    }

    // find first prime number larger than num
    private int findNextPrime(int num) {
    	while(!isPrime(num)) {
    		num++;
    	}
    	return num;
    }
    
    // check if a natural number is a prime
    private boolean isPrime(int num) {
    	if (num == 1) return false;
    	for (int i = 2; i <= Math.sqrt(num); i++)
    		if (num % i == 0)
    			return false;
    	return true;
    }
    
    // TODO implement required methods

    /**
     * Instead of using String's hashCode, you are to implement your own here.
     * You need to take the table length into your account in this method.
     *
     * In other words, you are to combine the following two steps into one step.
     * 1. converting Object into integer value
     * 2. compress into the table using modular hashing (division method)
     *
     * Helper method to hash a string for English lowercase alphabet and blank,
     * we have 27 total. But, you can assume that blank will not be added into
     * your table. Refer to the instructions for the definition of words.
     *
     * For example, "cats" : 3*27^3 + 1*27^2 + 20*27^1 + 19*27^0 = 60,337
     *
     * But, to make the hash process faster, Horner's method should be applied as follows;
     *
     * var4*n^4 + var3*n^3 + var2*n^2 + var1*n^1 + var0*n^0 can be rewritten as
     * (((var4*n + var3)*n + var2)*n + var1)*n + var0
     *
     * Note: You must use 27 for this homework.
     *
     * However, if you have time, I would encourage you to try with other
     * constant values than 27 and compare the results but it is not required.
     * @param input input string for which the hash value needs to be calculated
     * @return int hash value of the input string
     */
    private int hashFunc(String input) {
    	int hashCode = 0;
    	
        for (char c: input.toCharArray()) {
        	hashCode = hashCode * 27 + (c - 'a' + 1);
        	hashCode %= hashArray.length;
        }
//        return hashCode;
    	return (hashCode + hashArray.length) % hashArray.length;
    }

    /**
     * doubles array length and rehash items whenever the load factor is reached.
     * Note: do not include the number of deleted spaces to check the load factor.
     * Remember that deleted spaces are available for insertion.
     */
    private void rehash() {
    	// size exceeds load factor
    	if ((double)size / hashArray.length > LOADFACTOR) {
	        DataItem[] oldHashArray = hashArray;
	    	hashArray = new DataItem[findNextPrime(oldHashArray.length * 2)];
    		size = 0;
    		collision = 0;
	        for (DataItem d: oldHashArray) {
	        	// ignore tombstone
	        	if (d != null && d != DELETED) {
	        		insert(d.value, d.frequency);
	        	}
	        }
	        System.out.printf("Rehashing %d items, new length %d\n", size, hashArray.length);
    	}
    }

    /**
     * private static data item nested class.
     */
    private static class DataItem {
        /**
         * String value.
         */
        private String value;
        /**
         * String value's frequency.
         */
        private int frequency;

        // TODO implement constructor and methods
        public DataItem(String value, int frequency) {
			// TODO Auto-generated constructor stub
        	this.value = value;
        	this.frequency = frequency;
		}
    }

	@Override
	public void insert(String value) {
		insert(value, 1);
	}
	
	public void insert(String value, int frequency) {
		int hashVal = hashFunc(value);
		int hashCur = hashVal;
		int tmpCollision = 0; // save potential collisions of adding the new key
		                      // only add to total collisions if the key does not exist 
		// find a place to insert
		while(hashArray[hashCur] != null && hashArray[hashCur] != DELETED) {
			// when insert an existing value, only add frequency/ 0->2, 2->3 ...
			if (hashArray[hashCur].value.equals(value)){
				hashArray[hashCur].frequency++;
				return;
			}
			// add conflict is two key shares same hash value
			if (hashFunc(hashArray[hashCur].value) == hashVal) {
				tmpCollision = 1;
			}
			hashCur += 1;
			hashCur %= hashArray.length;
		}
		
		hashArray[hashCur] = new DataItem(value, frequency);
		size++;
		collision += tmpCollision;
		rehash();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		for (DataItem dataItem: hashArray) {
			if (dataItem == null)
				System.out.print(" **");
			else if(dataItem == DELETED)
				System.out.print(" #DEL#");
			else 
				System.out.printf(" [%s, %d]", dataItem.value, dataItem.frequency);
		}
		System.out.println();
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return search(key) != -1;
	}
	
	// search for a dataItem that contains key, return its index or -1 if the key not found
	private int search(String key) {
		// find hash value of the key
		int hashVal = hashFunc(key);
		int iter = 0;
		// search from hash value
		while (iter != hashArray.length && hashArray[hashVal] != null) {
			if (hashArray[hashVal].value.equals(key)) {
				return hashVal;
			}
			// wrap around
			hashVal = ++hashVal % hashArray.length;
			iter++;
		}
		return -1;
	}
	
	@Override
	public int numOfCollisions() {
		// TODO Auto-generated method stub
		return collision;
	}

	@Override
	public int hashValue(String value) {
		// TODO Auto-generated method stub
		return hashFunc(value);
	}

	@Override
	public int showFrequency(String key) {
		// TODO Auto-generated method stub
		int index = search(key);
		return index == -1 ? 0: hashArray[index].frequency;
	}

	@Override
	public String remove(String key) {
		// TODO Auto-generated method stub
		int delIndx = search(key);
		// key is not found
		if (delIndx == -1)
			return null;
		size--;
		hashArray[delIndx] = DELETED;
		return key;
	}
	
    private long myHashFunc(String input) {
    	long hashCode = 0;
    	
        for (char c: input.toCharArray()) {
        	System.out.println(hashCode);
        	hashCode = hashCode * 27 + (c - 'a' + 1);
//        	hashCode %= hashArray.length;
        }
        return hashCode;
//    	return (hashCode + hashArray.length) % hashArray.length;
    }
	
	public static void main(String[] args) {
		System.out.println(new MyHashTable(40).myHashFunc("himself"));
	}

}
