import java.util.ArrayList;

public class SimpleWordGame {
	public int points(String[] player, String[] dictionary) {
		// you write code here
		// currently works, remove double counted words with an arraylist
		int totalPoints = 0;
		int wordLength = 0;
		int wordPoints = 0;
		ArrayList<String> used = new ArrayList<String>();
		String word = "";
		for (int i = 0; i < player.length; i++) {
			word = player[i];
			for (int j = 0; j < dictionary.length; j++) {
				if (word.equals(dictionary[j])) {
					if (!used.contains(word)) { // change condition to ArrayList contains word
						wordLength = word.length();
						wordPoints = wordLength * wordLength;
						totalPoints = totalPoints + wordPoints;
					}
					used.add(word);
				}
			}
		}

		return totalPoints;
	}
}

// if the word is in dictionary
// if the word is not already in used
// then add points