
public class Common {
	
	public int count(String a, String b) {

		// for a to be at index 0 (ASCII is 97), subtract 97 from int value
		int aVal = 'a';
		int bVal = 'z';
		int range = bVal-aVal;
		
		// create empty arrays of occurrences
		int aOccurences[] = new int[range];
		int bOccurences[] = new int[range];
		
		int len = a.length(); // length of both strings
		
		// current letter we are on
		char currentA = ' ';
		char currentB = ' ';
		
		for (int j = 0; j < len; j ++) {
			// find the current letter
			currentA = a.charAt(j);
			currentB = b.charAt(j);
			
			// change current letter to integer and equalize to match array index
			aVal = currentA - 97;
			bVal = currentB - 97;
			
			// add one to the index of said letter because it has occurred
			aOccurences[aVal] += 1;
			bOccurences[bVal] += 1;
		}
		
		int letterCount = 0;
		int indexCount = 0;
		
		for (int k = 0; k < range; k ++) {
			if (aOccurences[k] <= bOccurences [k]) {
				indexCount = aOccurences[k];
			} else if (bOccurences[k] < aOccurences[k]) {
				indexCount = bOccurences[k];
			}
			
			letterCount = letterCount + indexCount;
		}
		
		return letterCount;
	}
	// I want a letter, and the number of occurrences in each word
	// Then take the lower number for each letter and occurrences
}