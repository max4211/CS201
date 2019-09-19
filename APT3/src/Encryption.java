import java.util.ArrayList;

public class Encryption {
       private int range = 'z'-'a';
	   
	   public String encrypt(String message){
           // you write code here
		   String code = "";
		   int[] indexes = new int[range+1]; // track of what indexes used letters occurred in
		   int count = 0; // count to keep track of what letter is what
		   
    	   ArrayList<Character> used = new ArrayList<Character>(); // used characters
    	   char current; // current character
    	   int add; // integer value of character to add
    	  
    	   for (int i = 0; i < message.length(); i ++) { // scan through the length of the word
    		  current = message.charAt(i);
    		   if (!used.contains(current)) {			// array list does not contain the letter
    			   add = used.size() + 97;				// use size of array list to figure out what letter of the encryption we are on
    			   code += Character.toString((char)add); // add the letter to the code of the next unused letter
    			   used.add(current);					// add the letter to the array list
    			   
    			   indexes[current-97] = count;		// Add the character to the corresponding index value (map to indexes)
    			   count += 1;							// increment the count by 1 to keep track of what letter we are on
    		   }
    		   else {									// else, array list does contain the letter
    			   add = indexes[current-97] + 97;			// count int in index of character to add
    			   code += Character.toString((char)add);
    		   }
    	   }
    	   		      
    	   return code;
       }
	   
	   // Pseudocode:
	   /* Scan through the length of the word
	    * Check if the letter has been used yet (check if it is in the arrayList)
	    * If it hasn't been used, then add the next letter encryption  to the string, and add that letter to the array list
	    * If it has been used, then figure out what letter it is (according to indexes) and add the corresponding letter to the String
	    */
   }