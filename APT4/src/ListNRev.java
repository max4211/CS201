public class ListNRev {
	public ListNode make(int n) {
		// replace statement below with code you write
		ListNode front = null;
		for (int k = 1; k <= n; k ++) {
			for (int j = 0; j < k; j ++) {
				front = new ListNode(k, front);
			}
		}
		return front;
	}
}