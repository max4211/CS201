import java.util.ArrayList;

public class StringCuts {
	public String[] filter(String[] list, int minLength) {
		// replace this with your code
		ArrayList<String> words = new ArrayList<String>();
		for (int i = 0; i < list.length; i ++) {
			if (list[i].length() >= minLength && !(words.contains(list[i])))
				words.add(list[i]);
		}
		
		String[] filtered = new String[words.size()];
		filtered = words.toArray(filtered);
		
		return filtered;
	}
}