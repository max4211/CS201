import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Thesaurus {
	public String[] edit(String[] entry) {
		// TODO: fill in code here
		Set<String> entryList = new HashSet<>(Arrays.asList(entry));	// Converts entry string into a set
		Set<String> newEntries = new HashSet<>();	// New set that is a combo
		Set<String> combo = new HashSet<>();

		String current1;
		String current2;
		
		Iterator<String> iter = entryList.iterator();	// Creates an iterator over entryList
		while(iter.hasNext()) {							// While there is a next value
			current1 = iter.next();						// next element
			current2 = iter.next();						// next element
			
			Set<String> guy1 = new HashSet<>(Arrays.asList(current1));	// convert first element to set for analysis
			Set<String> guy2 = new HashSet<>(Arrays.asList(current2));	// ditto
			guy1.retainAll(guy2);
			
			if (guy1.size() >= 2) { // guy1 has more in common with guy2 than one
				// Then combine the two Sets and add this combo to the list
			}
			else {	// The two sets have less in common, so add them to the combo list anyways
				
			}
			
		}
		
		String[] guy = new String[1]	;	// Make an empty string array same size as combo
		guy = combo.toArray(guy);				// Not sure if this works
		
		return guy;
	}
	
	/*Pseudcode 2: Turn each string into a set
	 * Find the intersection of two strings, and if this value is greater than 2 then combine the two
	 * Do this by removing the intersection of two sets, then adding this removal to the other set
	 * Use .retainAll (this is a mutator), and make a copy of one set before I mutate it
	 * 
	 * If its greater than two, then do add all
	 */
	
	/*Pseudocode 3:
	 * For String in entryList
	 * Convert each string to arrays by space
	 * Convert arrays to sets
	 * Then do set.retainAll to see how many elements are the same
	 * 
	 */
}