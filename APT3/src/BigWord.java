import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BigWord {
	
//	public static void main (String[] args) {
//		
//		String[] testString = {"one fish two", "fish red fish blue", "fish this fish is black" };
//		
//		ArrayList<Integer> guy = most(testString);
//		// TODO Fix errors in count array (everything else seems to work correctly
//		
//		System.out.println(guy);
//	}
	
	public String most(String[] sentences) {
	//public static ArrayList<Integer> most(String[] sentences) {
		// you write code here
		String most = "";
		ArrayList<String> words = new ArrayList<String>(); // array list of words
		int count2[] = new int [50];						// I know max number of words, so presetting size of array
		
		String[] sorted = process(sentences); // sort the sentences array
		
		int index; // index in the array list

		for (int i = 0; i < sorted.length; i++) { // scan through all sentences
			if (!(words.contains(sorted[i]))) { // if the array list doesn't contain the current word
				count2[words.size()] = 1; // edit index of the array to be 1
				words.add(sorted[i]); // add the word to the array list
			} else if (words.contains(sorted[i])) { // otherwise, the array list should contain the letter
				// increment the count at that index
				index = words.indexOf(sorted[i]); 	// index of the word in the array list
				count2[index] += 1; 				// increment count2 @ index by 1
			}
		}
		// At this point, should have filled array lists of words with corresponding count numbers
		// Next step is to find the highest count and return the corresponding word
		
		int mostIndex = max(count2);			// TODO call function
		most = words.get(mostIndex);
		
		return most;
	}
	// TODO helper methods
	// Convert string to lower case

	private int max(int[] count) {			// input count array, output index of max value
		int greatest = 0;
		int index = 0;
		for (int j = 0; j< count.length; j ++) {
			if (count[j] > greatest) {
				greatest = count[j];
				index = j;
			}
				
		}
		return index;
	}
	
	private String[] process(String[] sentence) {
		String combo = "";
		for (int i = 0; i < sentence.length; i ++) {
			combo += sentence[i] + " ";
		}
		
		String combo2 = combo.toLowerCase();

		String[] sentences = combo2.split(" "); // array of words

		return sentences; // return array of lower case words

	}

	/*
	 * Pseudocode: Scan through sentences array If a word hasn't been added to the
	 * array list, add it in and add one to the corresponding count If it has been
	 * added to the array list, add one to the corresponding count Return the word
	 * at the index of the greatest count
	 */

}