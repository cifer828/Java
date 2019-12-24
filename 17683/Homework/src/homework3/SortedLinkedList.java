package homework3;


public class SortedLinkedList implements MyListInterface{
	
	private static class Node {
		private String value;
		private Node next;
		public Node(String value, Node next) {
			// TODO Auto-generated constructor stub
			this.value = value;
			this.next = next;
		}
	}
	
	private Node head;
	private int size;
	
	public SortedLinkedList() {
		head = null;
	}
	
	public SortedLinkedList(String[] stringArray) {
		if (stringArray == null || stringArray.length == 0)
			return;
		addFromArray(stringArray, 0);
	}
	
	private void addFromArray(String[] stringArray, int cur) {
		add(stringArray[cur]);
		if (++cur < stringArray.length)
			addFromArray(stringArray, cur);
	}
	
	@Override
	public void add(String value) {
		if (!valid(value)) 
			return;
		if (head == null)
			head = new Node(value, null);
		// insert before head
		else if (head.value.compareTo(value) > 0)
			head = new Node(value, head);
		else if(!addNode(head, value))
			return;
		size++;
		
	}
	
	private boolean addNode(Node node, String value) {
		// avoid duplicate
		if (node.value.equals(value))
			return false;
		
		// add to last
		if (node.next == null) 
			node.next = new Node(value, null);
		else if (node.next.value.compareTo(value) > 0)
			node.next = new Node(value, node.next);
		else 
			return addNode(node.next, value);
			
		return true;
	}

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
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void display() {
		if (!isEmpty()) {
			System.out.printf("[%s", head.value);
			displayNode(head.next);
		}
		System.out.println("]");
		
	}
	
	private void displayNode(Node node) {
		if (node != null) {
			System.out.printf(", %s", node.value);
			displayNode(node.next);
		}
			
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return containsKey(head, key);
	}
	
	private boolean containsKey(Node node, String key) {
		if(node == null)
			return false;
		if (node.value.equals(key))
			return true;
		else {
			return containsKey(node.next, key);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}

	@Override
	public String removeFirst() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		Node temp = head;
		head = head.next;
		size--;
		return temp.value;
	}

	@Override
	public String removeAt(int index) {
		if (index < 0 || index > size - 1)
			throw new RuntimeException("invalid index");
		if (index == 0)
			return removeFirst();
		else {
			size--;
			return removeNodeAt(head, head.next, index - 1);
		}
	}
	
	private String removeNodeAt(Node pre, Node node, int index) {
		if (index == 0) {
			Node temp = node;
			pre.next = node.next;
			return temp.value;
		}
		else {
			return removeNodeAt(node, node.next, index - 1);
		}
	}

}
