import java.util.ArrayList;
import java.util.Collections;

public class DonorStats {
	public String[] calculate(String[] donations) {
		// write your code here and replace this
		// Split each element in donations at the semicolon
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> nums = new ArrayList<String>();
		
		String name = "";
		String num = "";
		int index = 0;
		for (int i = 0; i < donations.length; i ++) {
			// Current is of form [name, list of donations]
			String[] current = separate1(donations[i]);
			name = current[0]; // Name
			System.out.println("Name = " + name);
			num = current[1]; // List of donations
			System.out.println("Num = " + num);
			if (!(names.contains(name))) { // if the name has not been counted at
				names.add(name);
				nums.add(num);
			}
			else { // otherwise the name has been added
				index = names.indexOf(name); // find index of name
				System.out.println("Index = " + index);
				// add the new numbers to that spot
				nums.set(index, num + "," + nums.get(index));
			}
		}
		// At this point, expecting an array list of names
		// Parallel array list with numbers
		System.out.println("Nums = " + nums + nums.size());
		ArrayList<Integer> total = new ArrayList<Integer>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		int subtotal;
		
		for (int k = 0; k < nums.size(); k ++) { // Scan through all number donations
			subtotal = 0;
			
			String[] quant = separate2(nums.get(k));
			count.add(quant.length); // Number of  donations is length
			String quant2 = unite(quant); // now each donation is separated by a space
			for (int i = 0; i < quant.length; i ++) {
				subtotal += Integer.parseInt(quant[i]);
			}
			total.add(subtotal);
		}
		System.out.println("Names = " + names);
		System.out.println("Total  = " + count);
		System.out.println("Count  = " + total);
		// At this point, should have 3 parallel arrays of the correct indices
		ArrayList<String> summary = new ArrayList<String>();
		for (int i = 0; i < names.size(); i ++) {
			summary.add(names.get(i) + ":" + count.get(i) + ":" + total.get(i));
		}
		Collections.sort(summary);
		String[] summary2 = new String[summary.size()];
		for (int k = 0; k < summary2.length; k ++) {
			summary2[k] = summary.get(k);
		}
		return summary2;
	}
	
	
	public static String unite (String[] element) {
		String guy = "";
		for (int i = 0; i < element.length; i ++) {
			guy += element[i];
			if (i < element.length-1) {
				guy += " ";
			}
		}		
		return guy;
	}
	
	public static String[] separate1(String element) {
		
		String[] guy = element.split(":");
		return guy;
	}
	
	public static String[] separate2(String element) {
		
		String[] guy = element.split(",");
		return guy;
	}
	
	//public static void main (String[] args) {
//		String name = "Max";
//		int total = 160;
//		int amount = 69;
//		String s = String.format("%s:%d:%d",name,total,amount);
//		System.out.println(s);
//		String[] test = {"1", "2", "5"};
//		String test2 = unite(test);
//		System.out.println(test2);
		
		String[] guy = {"fred:1,2,3", "ethel:4,5,6", "fred:3,3", "ethel:9"};
		String[] guy2 = calculate(guy);
		
	//}
	
	
}
