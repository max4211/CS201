public class RemoveMin {
	public ListNode remove(ListNode list) {
		// replace statement below with code you write
		if (!(list.next != null)) return null;
		// Initialize pointers from start
		ListNode start = list;
		ListNode guy = list.next; // pointer of value after minimum
		// Minimum value that the list contains, default to first one
		int min = list.info;
		while (list != null) {
			int current = list.info; // Current value
			// Check if current info is the lowest
			if (current < min) {
				min = current;
				guy = list.next; // If it is, then the pointer goes to next one
			}
			list = list.next; // Increment the list by one
		}
		// At this point, know min, go back and find
		ListNode head = start; // reinitialize
		if (start.info == min) return guy;
		
		while (start.next.info != min) {start = start.next;}
		start.next = guy;
		return head;
	}
}