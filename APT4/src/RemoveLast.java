public class RemoveLast {
	public ListNode remove(ListNode list) {
		// replace statement below with code you write
		ListNode head = list;
		ListNode prev = new ListNode(0, null);
		if (!(list != null)){
			return null;
		}
		
		while (list.next != null) {
			prev = list;
			list = list.next;
		}
		prev.next = null;
		/// Counter should equal size of the list

		return head;
	}
}