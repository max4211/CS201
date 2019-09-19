
public class SandwichBar {
	public int whichOrder(String[] available, String[] orders) {
		// fill in code here
		// potential function = s.split(" ") split at spaces
		// use helper functions

		// check which orders I can make, and return the index of that order
		// where does the return go to?

//		for (int k = 0; k < orders.length; k ++) {
//			if (canMake(orders[k], available)) {
//				return k;
//			}
//		}
//		
		int possible = scanSand(orders, available);

		return possible;
	}

	// check which items are contained in the ingredients list
	private boolean containedIn(String one, String[] available) {
		for (String s : available) {
			if (one.contentEquals(s)) {
				return true;
			}
		}
		return false;
	}

	// verify whether or not I can make the sandwich
	private boolean canMake(String sand, String[] available) {
		String[] ingredients = sand.split(" ");
		for (String one : ingredients) {
			if (!containedIn(one, available)) {
				return false;
			}
		}
		return true;
	}

	private int scanSand(String[] orders, String[] available) {
		for (int k = 0; k < orders.length; k++) {
			if (canMake(orders[k], available)) {
				return k;
			}
		}
		return -1;
	}
}