import java.util.ArrayList;
import java.util.Arrays;

public class Anonymous {
	private int a = ' ';
	private int z = 'z';
	private int range = z - a;

	public int howMany(String[] headlines, String[] messages) {
		// fill in code here
		int stringCount = 0;
		String headlines2 = " "; // possible characters to use
		for (int i = 0; i < headlines.length; i++) {
			headlines2 += headlines[i];
		}
		String headlines3 = filter(headlines2);
		int[] possibleChar = new int[range];
		possibleChar = ASCII(headlines3);

		String[] messages2 = new String[messages.length];
		for (int i = 0; i < messages.length; i++) {
			messages2[i] = filter(messages[i]);
		}

		int[] spellThis = new int[range]; // ASCII for message to spell
		int[] difference = new int[range]; // difference between available char and messgae to spell (if negative can't
											// spell)
		int counter = 0;
		for (int j = 0; j < messages2.length; j++) {
			spellThis = ASCII(messages[j]);
			for (int i = 0; i < spellThis.length; i++) {
				difference[i] = possibleChar[i] - spellThis[i];
				if (difference[i] >= 0)
					counter += 1;
			}
			if (counter == range)
				stringCount += 1;
			counter = 0;
		}

		return stringCount;
	}

	private String filter(String guy) { // remove spaces and combine strings into a sequence of letters

		ArrayList<String> first = new ArrayList<String>(); // create empty array list
		char current = ' ';
		for (int i = 0; i < guy.length(); i++) { // scan through all letters in guy, adding them to array list if not a
													// space
			current = guy.charAt(i);
			String current2 = Character.toString(current);
			if (!current2.contentEquals(" ")) // remove spaces
				first.add(current2.toLowerCase());
		}

		String[] compress = new String[first.size()];
		compress = first.toArray(compress); // convert array list to a string array

		String compress2 = ""; // create an empty string

		for (int j = 0; j < compress.length; j++) { // fill empty string with letters from array list
			compress2 += compress[j];
		}
		return compress2; // return string of letters
	}

	private int[] ASCII(String guy) { // convert each string to ASCII indexes
		int[] indexes = new int[range];
		char current;
		int val;
		String current2;
		String guy2 = guy.toLowerCase();
		for (int k = 0; k < guy.length(); k++) {
			current = guy2.charAt(k);
			current2 = Character.toString(current);
			val = current - 97;
			if (!current2.equals(" ")) {
				indexes[val] += 1;
			}
		}
		return indexes;
	}

//	public static void main (String [] args) {
//		String test = "Earthquake in San Francisco";
//		String guy = filter(test);
//	}
	// Helper method to concatenate all characters and change everything to lower
	// case
}