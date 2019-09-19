import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {
	
	public class Person implements Comparable<Person> {
		String myFirst;
		String myLast;
		public Person (String fname, String lname) {
			myFirst = fname;
			myLast = lname;
		}
		public String getFirst() {
			return myFirst;
		}
		
		public String getLast() {
			return myLast;
		}
		
		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public String toString() {
			return myFirst + " " + myLast;
		}

	}
	
    public String[] dataCleanup(String[] names) {
    	if (names == null) return new String [0];
    	// Step 1 : clean data done in clean and lastFirst functions
    	// Step 2: create person class and person objects in a list
    	String[] names2 = clean(names);
    	// Step 3: sort the person class stuff
    	
    	Person list [] = new Person[names2.length];
    	String name;
    	String first;
    	String last;
    	int guy;
    	for (int i = 0; i < list.length; i ++) {
    		// Cleaned name
    		name = names2[i];
    		if (name.contains(",")) {
    	    	guy = name.indexOf(",");
    	    	first = name.substring(guy + 2, name.length());
    	    	last = name.substring(0, guy);
    		} else {
    			guy = name.indexOf(" ");
    			first = name.substring(0, guy);
    			last = name.substring(guy + 1, name.length());
    		}
    		list[i] = new Person(first, last);
    	}
    	
    	Arrays.sort(list, Comparator.comparing(Person:: getLast).thenComparing(Person::getFirst));
    	
    	for (int k = 0; k < names.length; k ++) {
    		names[k] = list[k].toString();
    	}
    	
    	return names;
   }
    
    // Input the array of names
    // Clean up each entry
    public String[] clean (String[] names) {
    	// Scan through each entry in names
    	String [] clean = new String[names.length];
    	for (int i = 0; i < names.length; i ++) {
    		if (names[i].contains(",")) {
    			clean [i] = lastFirst(names[i]);
    		} else {
    			clean[i] = names[i];
    		}
    	}
    	
    	return clean;
    }
    
    // Input a string that contains a comma, output the name in the correct formats
    public String lastFirst (String name) {
    	int guy = name.indexOf(",");
    	String first = name.substring(guy + 2, name.length());
    	String last = name.substring(0, guy);
    	
    	return first + " " + last;
    }
    
}

