import java.util.ArrayList;

public class Starter {
     public int begins(String[] words, String first) {
         // replace this code
    	 String current = "";
    	 char start = ' ';
    	 String startComp = "";
    	 int count = 0;
    	 ArrayList<String> used = new ArrayList<String>();
    	 
    	 for (int i = 0; i < words.length; i ++) {
    		 current = words[i];
    		 start = current.charAt(0);
    		 startComp = Character.toString(start);
    		 if (startComp.contentEquals(first) && !used.contains(current)) {
    			 // increase counter
    			 count = count + 1;
    			 used.add(current);
    		 }
    	 }
    	 
         return count;
     }
 }