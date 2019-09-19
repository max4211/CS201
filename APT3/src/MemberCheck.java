import java.util.ArrayList;
import java.util.Arrays;

public class MemberCheck {
      public String[] whosDishonest(String[] club1, 
                                    String[] club2, 
                                    String[] club3) {
             // TODO: fill in code here
    	  ArrayList<String> dishonest = new ArrayList<String>(); // array list of people who attend multiple clubs, unsorted
    	  
    	  for (int i = 0; i < club1.length; i ++) {				// check if member of club 1 appears in club 2
    		  if(containsMember(club2, club1[i])){ 				// if it does contain member
    			  if(!dishonest.contains(club1[i])) {			// and doesn't appear in the array list
    				  dishonest.add(club1[i]);					// add the member to the Array List
    			  }
    		  }
    		  if(containsMember(club3, club1[i])){ 				// same as above
    			  if(!dishonest.contains(club1[i])) {
    				  dishonest.add(club1[i]);
    			  }
    		  }
    	  }
    	  
    	  for (int j = 0; j < club2.length; j ++) {				// same as above
    		  if(containsMember(club3, club2[j])){ 
    			  if(!dishonest.contains(club2[j])) {
    				  dishonest.add(club2[j]);
    			  }
    		  }
    	  }
    	  // Should have an unsorted array list with all crossover
    	  // Now convert to String array and alphabetize
    	  
    	  String[] dishonest2 = new String[dishonest.size()]; // populate with array list, return to tester function
    	  dishonest2 = dishonest.toArray(dishonest2); // convert array list to a string array
    	  Arrays.sort(dishonest2); // alphabetize array using arrays API
    	  
    	  return dishonest2;
      }
      
      private boolean containsMember(String[] club, String member) { // checks if a member is in a club
    	  
    	  for (String s: club) {
    		  if (s.equals(member))
    			  return true;
    	  }
    	  return false;
      }
   }