
public class Totality {
	public int sum(int[] a, String stype) {
		// you add code here
		
		int sum = 0;

		if (stype.contentEquals("odd")) {
			for (int i = 1; i < a.length; i ++) {
				sum = sum + a[i];
				i ++;
			}
		}
		else if (stype.contentEquals("even")) {
			for (int i = 0; i < a.length; i ++) {
				sum = sum + a[i];
				i ++;
			}
		}
		else if (stype.contentEquals("all")) {
			for (int i = 0; i < a.length; i ++) {
				sum = sum + a[i];
			}
		}
		
		return sum;
	}
}
