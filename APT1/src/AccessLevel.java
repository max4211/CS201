public class AccessLevel {
	public String canAccess(int[] rights, int minPermission) {
		// fill in code here
		int size = rights.length;
		String access = "";
		
		for (int i = 0; i < size; i ++) {
			if (rights[i] >= minPermission) {
				// add a A to access
				access = access + "A";
			}
			else if (rights[i] < minPermission) {
				// add a D to access
				access = access + "D";
			}
		}
		
		return access;
	}
}