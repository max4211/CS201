
public class Prob5 {

	
	public static ListNode divide (ListNode list) {
		
		if (list == null || list.next == null) return list;
		boolean even = false;
		boolean odd = true;
		
		// Missing this declaration in code
		ListNode evenLast = new ListNode(0, null);
		ListNode evenFirst = new ListNode(0, null);
		ListNode oddLast = new ListNode(0, null);
		ListNode oddFirst = new ListNode(0, null);
		
		while (list.next != null) {
			list = list.next;
			if (list.info % 2 == 0) {
				if (!even) {
					even = true;
					evenLast = new ListNode (list.info, null);
					evenFirst = evenLast;	
				} else {
					evenLast.next = new ListNode (list.info, null);
				}
				
			} else {
				if (!odd) {
					odd = true;
					oddLast = new ListNode(list.info, null);
					oddFirst = oddLast;
				} else {
					oddLast.next = new ListNode(list.info, null);
				}
			}
		}
		
		oddLast.next = evenFirst;
		evenLast.next = null;
		return oddFirst;
	}
	
	public static void main (String[] args) {
		ListNode list = new ListNode(5, null);
		ListNode head = list;
		list.next = new ListNode(8, null);
		list.next = new ListNode(3, null);
		list.next = new ListNode(4, null);
		list.next = new ListNode(7, null);
		
		ListNode guy = divide(head);
		
		while (guy.next != null) {
			System.out.println("Lets get this bread");
			System.out.println(guy.info);
			guy = guy.next;
		}
		
	}
}
