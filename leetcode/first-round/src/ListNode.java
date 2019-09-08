

 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      public static void main(String[] args) {
    	  ListNode n = new ListNode(0);
    	  n.next = new ListNode(0);
    	  ListNode c = n.next;
    	  c.val = 0;
    	  System.out.println(n.next.val);
      }
  }
 