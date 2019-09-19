import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class MedalTable {
	public class Country implements Comparable<Country> {
		int myGold;
		int mySilver;
		int myBronze;
		String myName;
		
		public Country(String name, int gold, int silver, int bronze) {
			myGold = gold;
			mySilver = silver;
			myBronze = bronze;
			myName = name;
		}
		
		public int getGold() {
			return myGold;
		}
		
		public int getSilver() {
			return mySilver;
		}
		
		public int getBronze() {
			return myBronze;
		}
		
		public String getName() {
			return myName;
		}
		
		@Override
		public String toString() {
			return myName + " " + myGold + " " + mySilver + " " + myBronze;
		}
		
		@Override
		public int compareTo(Country o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	// Global tree map variables
	TreeMap<String, Integer> gold = new TreeMap<String, Integer>();
	TreeMap<String, Integer> silver = new TreeMap<String, Integer>();
	TreeMap<String, Integer> bronze = new TreeMap<String, Integer>();
	ArrayList<String> allCountries = new ArrayList<String>();
	
	public String[] generate(String[] results) {	
		// A string of current countries for given event
		String[] event = new String[3];
		
		// Scan through all results
		// Split at all spaces
		for (String s: results) {
			event = s.split(" ");			
			populateMap(event);
		}
		
		// At this point, should have three tree maps
		// Now we can populate an array of countries using keyset on gold
		Country[] list = new Country[allCountries.size()];
		String key;
		for (int i = 0; i < list.length; i ++) {
			key = allCountries.get(i);
			list[i] = new Country (key, gold.get(key), silver.get(key), bronze.get(key));
		}
		
		//Arrays.sort(list, Comparator.comparing(Country:: getName).reversed().thenComparing(Country::getSilver).thenComparing(Country::getBronze).thenComparing(Country::getGold));
		Arrays.sort(list, Comparator.comparing(Country:: getGold).thenComparing(Country::getSilver).thenComparing(Country::getBronze).reversed().thenComparing(Country::getName));
		//Arrays.sort(list, Comparator.comparing(Country:: getGold).thenComparing(Country::getSilver).thenComparing(Country::getBronze).thenComparing(Country::getName));
		//Collections.reverse(Arrays.asList(list));
		
		String[] guy = new String[list.length];
		for (int k = 0; k < guy.length; k ++) {
			guy[k] = list[k].toString();
		}
		
		return guy;
	}
	
	public void populateMap(String[] event) {
		String goldCur = event[0];
		String silverCur = event[1];
		String bronzeCur = event[2];
		
		// Append array list
		for (int k = 0; k < event.length; k ++) {
			if (!(allCountries.contains(event[k]))) allCountries.add(event[k]);
		}
		
		// Populate all TreeMaps with current guy
		// Put zero if it hasn't been seen yet
		gold.putIfAbsent(goldCur, 0);
		gold.putIfAbsent(silverCur, 0);
		gold.putIfAbsent(bronzeCur, 0);
		
		silver.putIfAbsent(goldCur, 0);
		silver.putIfAbsent(silverCur, 0);
		silver.putIfAbsent(bronzeCur, 0);
		
		bronze.putIfAbsent(goldCur, 0);
		bronze.putIfAbsent(silverCur, 0);
		bronze.putIfAbsent(bronzeCur, 0);
		
		// Now add to correct section
		gold.put(goldCur, gold.get(goldCur) + 1);
		silver.put(silverCur, silver.get(silverCur) + 1);
		bronze.put(bronzeCur, bronze.get(bronzeCur) + 1);
	}
}
