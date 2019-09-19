import java.util.Arrays;
import java.util.Comparator;

public class LengthSort {
	public class Words implements Comparable<Words> {
		String myWord;
		int myLength;
		
		public Words(String word, int length) {
			myWord = word;
			myLength = length;
		}
		
		public String getWord() {
			return myWord;
		}
		
		public int getLength() {
			return myLength;
		}
		
		@Override
		public String toString() {
			return myWord;
		}
		
		@Override
		public int compareTo(Words o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
    public String[] rearrange(String[] values){
        // Create array of word values
    	Words[] words = new Words[values.length];
    	String curVal;
		for (int k = 0; k < words.length; k++) {
			curVal = values[k];
			words[k] = new Words(curVal, curVal.length());
		}
    	
		Arrays.sort(words, Comparator.comparing(Words::getLength).thenComparing(Words:: getWord));
    	    	
		for (int k = 0; k < values.length; k++) {
			values[k] = words[k].toString();
		}
		
        return values;
    }
}
