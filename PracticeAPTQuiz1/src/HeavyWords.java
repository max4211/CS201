import java.util.ArrayList;
import java.util.Collections;

public class HeavyWords {
	public double average(String[] words) {
		// write your code here
		// The most frequent starting character
		
		return most(words);
	}
	
	//Input the words array, output the most occurring character
	public double most(String[] words) {
		ArrayList<Character> used = new ArrayList<Character>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<Integer> total = new ArrayList<Integer>(); // total times a letter is used
		
		
		
		String current;
		char guy;
		for (int i = 0; i < words.length; i ++) {
			current = words[i];
			guy = current.charAt(0);
			if (!(used.contains(guy))) { // letter hasn't been seen before
				used.add(guy);
				count.add(1);
				total.add(current.length());
			}
			else { // letter has been seen
				int index = used.indexOf(guy);
				count.set(index, count.get(index) + 1);
				total.set(index, current.length() + total.get(index));
			}
		}
		// At this point, should have parallel arrays with characters and counts
		// Now, must find most occurring letter
		// Cast guys to double
		int most = Collections.max(count);
		int sum = total.get(count.indexOf(most));
		double avg = ((double) sum)/most;
		
		return avg;
	}
}