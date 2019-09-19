import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// I believe this works, but it isn't a cue so prob need to change that to improve run time
public class SortedFreqs {
	
	// Array list of all words in alphabetical order
	private ArrayList<String> alist = new ArrayList<String>();
	// Array list of single words in alphabetical order to help with printing in the end
	private ArrayList<String> singlealist = new ArrayList<String>();
	// Hashmap to retrieve frequencies of words
	private Map<String, Integer> myMap = new HashMap<String, Integer>();
	
    public int[] freqs(String[] data) {
    	
    	// Populate array list with all unsorted values
    	for (int i = 0; i < data.length; i ++) {
    		alist.add(data[i]);
    	}
    	
    	// Sort array list using Collections API
    	Collections.sort(alist);
    	// Now alist is sorted
    	
    	// Populate hashmap with values with sorted data
    	for (int k = 0; k < alist.size(); k ++) {
    		String cur = alist.get(k);
    		// Verify if the value is in the map
    		if (!(myMap.containsKey(cur))){
    			myMap.put(cur, 1);
    			// Add unique string to the parallel arraylist
    			singlealist.add(cur);
    		} else {
    		// Increment value by 1
    			myMap.put(cur, myMap.get(cur) + 1);
    		}
    	}
    	
    	// Convert single array list to array
    	String[] singlealist2 = new String[singlealist.size()];
    	for (int i = 0; i < singlealist2.length; i ++) {
    		singlealist2[i] = singlealist.get(i);
    	}
    			
    	int[] frequency = new int[singlealist.size()];
    	
    	for (int j = 0; j < frequency.length; j ++) {
    		frequency[j] = myMap.get(singlealist2[j]);
    	}
    	
    	return frequency;
      }
}
