public class ListLastFirst {
	public ListNode move(ListNode list) {
		// replace statement below with code you write
		if (!(list != null)) {
			return list; // edge case list is of length one
		}
		if (!(list.next != null)) {
			return list;
		}
		
		ListNode first = list;
		while (list.next.next != null) { // Second before last entry is not null
			list = list.next; // increment to next element in list
		} // once you are at the second to last element
		
		ListNode second = list; // re establish list at this point
		first = new ListNode(list.next.info, first);
		
		list.next = null; // Change last list to point to null
		// first = new ListNode(second.info, first);
		
		
		return first;
	}
}