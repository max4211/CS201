public class ListsEqual {
	public int equal(ListNode a1, ListNode a2) {
		// replace statement below with code you write
		if (!(a1 != null)) {
			if (!(a2 != null)) {
				return 1;
			}
		}
		
		while (a1 != null && a2 != null) { // while both lists have a next node
			if (a1.info != a2.info) {
				return 0;
			}
			a1 = a1.next;
			a2 = a2.next;
			
			if (!(a1 != null)) {
				if (!(a2 != null)) {
					return 1;
				}
			}
		}
		return 0;
	}

}
