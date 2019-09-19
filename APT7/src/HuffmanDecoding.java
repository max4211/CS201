import java.util.HashMap;

public class HuffmanDecoding {
	// Populate with all letters
	HashMap<String, String> myMap = new HashMap<String, String>();
	private int capStart = 65;
	
	public String decode(String archive, String[] dictionary) {
		// Populate hashmap with values
		String key;
		char value;
		for (int i = 0; i < dictionary.length; i ++) {
			key = dictionary[i];
			value = (char) (i + capStart);
			myMap.put(key, Character.toString(value));
		}
		
		String ret = "";
		String sub;
		int start = 0;
		for (int i = 0; i <= archive.length(); i ++) {
			sub = archive.substring(start, i);
			if (myMap.containsKey(sub)) {
				ret = ret + myMap.get(sub);
				start = i;
			}
		}
		
		return ret;
	}
}
