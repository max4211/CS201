import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AlphaLength {
	public static class Word implements Comparator<Word> {
		String myWord;
		
		public Word (String word) {
			myWord = word;
		}
		
		@Override
		public int compare(Word o1, Word o2) {
			// TODO Auto-generated method stub
			String first = o1.getWord();
			String second = o2.getWord();
			char firstChar;
			char secondChar;
			int difference = 0;
			for (int i = 0; i < first.length(); i ++) {
				if (second.length() > i) {
					firstChar = first.charAt(i);
					secondChar = second.charAt(i);
					difference = firstChar - secondChar;
				}
				if (!(difference == 0)) return difference;
			}
			return 0;
		}
		
		public String getWord() {
			return myWord;
		}
		
	}
	
	public ListNode create(String[] words) {
		// Step one, sort the words in alphabetical order
		// Create an array of words
		words = alphabetize(words);
		
		int firstWord = words[0].length();
		
		ListNode ret = new ListNode(firstWord, null);
		ListNode first = ret;
		
		for (int k = 1; k < words.length; k ++) {
			ret.next = new ListNode(words[k].length(), null);
			ret = ret.next;
		}
		
		return first;
	}
	
	public static String[] alphabetize (String[] words) {
		ArrayList<String> allWords = new ArrayList<String>();
		for (int i = 0; i < words.length; i ++) {
			if (!(allWords.contains(words[i]))) {
				allWords.add(words[i]);
			}
		}
		Collections.sort(allWords);
		
		String[] ret = new String[allWords.size()];
		// Now return to an array
		for (int k = 0; k < allWords.size(); k ++) {
			ret[k] = allWords.get(k);
		}
		return ret;
	}
	
//	public static void main (String[] args) {
//		String[] words = {"bat", "at", "spat"};
//		ArrayList<String> allWords = new ArrayList<String>();
//		for (int i = 0; i < words.length; i ++) {
//			allWords.add(words[i]);
//		}
//		Collections.sort(allWords);
//		
//		for (int k = 0; k < allWords.size(); k ++) {
//			System.out.println(allWords.get(k));
//		}
//		
//	}
}
