
public class MergeLists {
    public ListNode weave (ListNode a, ListNode b) {
        // replace statement below with code you write
    	ListNode head = new ListNode(a.info, null);
    	ListNode ret = head;
    	head.next = new ListNode(b.info, null);
    	head = head.next;
    	if (a.next == null) {
    		return ret;
    	}
    	a = a.next;
    	b = b.next;
    	while (a.next != null) {
    		head.next = new ListNode(a.info, null);
    		head = head.next;
    		a = a.next;
    		head.next = new ListNode(b.info, null);
    		head = head.next;
    		b = b.next;
    	}
		head.next = new ListNode(a.info, null);
		head = head.next;
		a = a.next;
		head.next = new ListNode(b.info, null);
		head = head.next;
		b = b.next;
    	
	  return ret;
    }
}
