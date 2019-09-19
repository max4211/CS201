import java.util.ArrayList;

public class CounterAttack {
     public int[] analyze(String str, String[] words) {
         // change this code
         String [] individual = str.split(" "); // make an array of all individual words in the str array
    	 ArrayList<String> used = new ArrayList<String>(); // make an array list that will contain all used letters
       	 int usedSize = 0;
    	 
    	 for (int i = 0; i < individual.length; i ++) {// fill array list with individual strings
    		 if (!used.contains(individual[i])) {	
    			 used.add(individual[i]);     		 // add the next letter to the array list if it is not already in the array list
    			 usedSize = usedSize + 1;
    		 }
    	 }
    	 
    	 String currentGuy = " "; // declare empty current string
    	 int [] count = new int [words.length]; // create an integer array that is the size of array 
    	 
    	 for (int j = 0; j < individual.length; j ++) { // scan through used array
    		 currentGuy = individual[j];
    		 for (int k = 0; k < words.length; k ++) { // scan through words array
    			 if (currentGuy.equals(words[k])) {
    				 count[k] = count[k] + 1;
    			 }
    		 }
    	 }
    	 
    	 return count;
         
         
     }
 }