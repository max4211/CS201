import java.util.ArrayList;

public class IsomorphicWords {
	public int countPairs(String[] words) {
		// fill in code here
		String[] newWords = new String [words.length];
		for (int i = 0; i < words.length; i ++) {		// Map all words to the basic encryption
			newWords[i] = encrypt(words[i]);
		}
		// At this point, should contain an array of words all conforming to the encryption algorithm
		// Now scan through, looking for identical pairs
		int count = 0;
		
		// TODO: Fix double counting (sometimes words are counted twice; solutions - ArrayList?)
		for (int j = 0; j < newWords.length; j ++) {	// This compares each word to the first word
			for (int i = 0; i < newWords.length; i ++) {
				if (!(j == i) && (j > i)) {						// Whenever the two aren't equal, then compare // Add a constraint to only make a comparison that hasn't been done before
					if (newWords[j].equals(newWords[i]))
						count += 1;
				}
			}
			
		}		
		return count;
		

	}

	private int range = 'z' - 'a';

	public String encrypt(String message) {
		// you write code here
		String code = "";
		int[] indexes = new int[range + 1]; // track of what indexes used letters occurred in
		int count = 0; // count to keep track of what letter is what

		ArrayList<Character> used = new ArrayList<Character>(); // used characters
		char current; // current character
		int add; // integer value of character to add

		for (int i = 0; i < message.length(); i++) { // scan through the length of the word
			current = message.charAt(i);
			if (!used.contains(current)) { // array list does not contain the letter
				add = used.size() + 97; // use size of array list to figure out what letter of the encryption we are on
				code += Character.toString((char) add); // add the letter to the code of the next unused letter
				used.add(current); // add the letter to the array list

				indexes[current - 97] = count; // Add the character to the corresponding index value (map to indexes)
				count += 1; // increment the count by 1 to keep track of what letter we are on
			} else { // else, array list does contain the letter
				add = indexes[current - 97] + 97; // count int in index of character to add
				code += Character.toString((char) add);
			}
		}

		return code;
	}

	/*
	 * Pseudocode: Convert all words to a basic mapping (possible using Encryption
	 * from prior APT?) Scan through length of words, comparing each word to every
	 * other word and adding one to the count for each synonymous pairs
	 */
}