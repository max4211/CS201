import java.util.ArrayList;

public class FreeZone {
	public int[] uncovered(int zones, String[] covered) {
		// you write code here
		
		// Generate an ArrayList of the total zone range
		ArrayList<Integer> total = new ArrayList<Integer>();
//		for (int k = 0; k < zones - 1; k ++) {
//			total.add(k);
//		}
		int k = 0;
		while (k < zones) {
			total.add(k);
			k = k+ 1;
		}
		
		ArrayList<Integer> current = new ArrayList<Integer>();
		// Scan through all covered values
		for (int i = 0; i < covered.length; i ++){
			current = range(covered[i]);
			total.removeAll(current);
		}
		
		int[] coverage = new int[total.size()];
		for (int i = 0; i < coverage.length; i ++) {
			coverage[i] = total.get(i);
		}
		
		return coverage;
	}
	
	// Inputs a String of coverage range
	// Outputs an ArrayList of integers spanning that range
	public ArrayList<Integer> range(String coverage){
		ArrayList<Integer> ran = new ArrayList<Integer>();
		
		String[] bounds = separate1(coverage);
		String min = bounds[0];
		String max = bounds[1];
		
		int x = Integer.parseInt(min);
		int y = Integer.parseInt(max);
		
		for (int i = x; i <= y; i ++) {
			ran.add(i);
		}
		
		return ran;
		
	}
	
	public String[] separate1(String element) {
		
		String[] guy = element.split(" ");
		return guy;
	}
	
//	public static void main (String[] args) {
//		int zones = 10;
//		String[] covered = {"2 8"};
//		
//		ArrayList <Integer> ran = range("2 9");
//		System.out.println("Returns : " + ran);
//	}
	
}