public class ListStretch {
	public ListNode stretch(ListNode list, int amount) {
		// replace statement below with code you write
		ListNode front = list;
		if (!(list != null)) { // Check if the list is empty
			return null;
		}
		// Check if amount is only 1
		if (amount == 1)return list;
		else {
			while (list != null) { // Scan and add, while list isn't null
				for (int i = 1; i < amount; i++) { // do this amount times
					// next node contains current info, points to next next node
					list.next = new ListNode(list.info, list.next); 
					list = list.next; // increment to next node, should be what you just made
				}
				list = list.next;
			}
			return front; // after list.next is null, return list
		}
	}
}