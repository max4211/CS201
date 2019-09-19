import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SetAside {
	public String common(String[] list) {
		// replace this with your code
		// ArrayList<String> analyze = new ArrayList<String>();
		List<String> current = Arrays.asList(separate(list[0]));
		ArrayList<String> add = new ArrayList<String>(current);
		for (int i = 1; i < list.length; i++) { // Scan through the size of list
			List<String> next = Arrays.asList(separate(list[i]));
			add.retainAll(next); // find intersection of two lists
		}
		// At this point, add should contain all of the intersections of each element in list
		// Be sure to sort alphabetically at the end
		Collections.sort(add);
		String[] filtered = new String[add.size()];
		filtered = add.toArray(filtered);

		String guy2 = "";
		for (int k = 0; k < filtered.length; k++) {
			guy2 += filtered[k];
			if (k < filtered.length - 1) {
				guy2 += " ";
			}
		}
		// At this point, everything is correct except I have repeats
		String[] guy4 = guy2.split(" ");
		ArrayList<String> guy3 = new ArrayList<String>();
		for (int j = 0; j < guy4.length; j ++) {
			if(!(guy3.contains(guy4[j]))) {
				guy3.add(guy4[j]);
			}
		}
		String[] filtered2 = new String[guy3.size()];
		filtered2 = guy3.toArray(filtered2);
		
		String guy5 = "";
		for (int k = 0; k < filtered2.length; k++) {
			guy5 += filtered2[k];
			if (k < filtered2.length - 1) {
				guy5 += " ";
			}
		}

		return guy5;
	}
	
	public static String[] separate(String element) {
		
		String[] guy = element.split(" ");
		return guy;
	}
	
//	public static void main(String[] args) {
//		String[] list = {"a b c d", "b c d", "b c d e", "b c f"};
//		List<String> guy = common(list);
//		//System.out.println(guy);
//		
//		List<String> current = Arrays.asList(separate(list[0]));
//		ArrayList<String> add = new ArrayList<String>(current);
//		for (int i = 1; i < list.length; i++) { // Scan through the size of list
//			List<String> next = Arrays.asList(separate(list[i]));
//			add.retainAll(next); // find intersection of two lists
//			System.out.println(add);
//		}
//		
//	}
}