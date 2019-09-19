import java.util.ArrayList;
import java.util.Collections;

public class TentNames {
	public int popular(String[] tents) {
		// write code here
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		
		for (int i = 0; i < tents.length; i ++) {
			// Split current tent at spaces
			String[] current = separate1(tents[i]);
			for (int k = 0; k < current.length; k ++) {
				if (!(name.contains(current[k]))) { // If the current name isn't in the array list
					name.add(current[k]);
					count.add(1);
				}
				else { // otherwise, it is in the array list
					int index = name.indexOf(current[k]);
					count.set(index, 1 + count.get(index));
				}
			}
		}
		
		int guy = Collections.max(count); // Maximum value (return this)
		int index = count.indexOf(guy); // Index of that value		
		
		return guy;
	}
	
	public static String[] separate1(String element) {
		
		String[] guy = element.split(" ");
		return guy;
	}
}