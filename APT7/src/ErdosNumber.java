import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ErdosNumber {
	
	Map<String, Set<String>> tm = new TreeMap<String, Set<String>>();
	static TreeMap<String, Set<String>> myGraph;
	TreeMap<String, Integer> myDistance;
	
	// Create author object to compare and be returned
	public class Author implements Comparable<Author> {
		
		private String myName;
		private int myErdos;
		
		// How to account for empty guys
		public Author(String name, int erdos) {
			myName = name;
			myErdos = erdos;
		}
		
		public String getName() {
			return myName;
		}
		
		public int getErdos(){
			return myErdos;
		}
		
		@Override
		public String toString() {
			return myName + " " + myErdos;
		}
		
		@Override
		public int compareTo(Author o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
    public String[] calculateNumbers(String[] pubs) {
        // you write code here
    	makeGraph(pubs);
    	ArrayList<String> list = new ArrayList<>();
    	bfsErdos();
    	for (String s: myGraph.keySet()) {
    		if (myDistance.containsKey(s)) {
    			s = s + " " + myDistance.get(s);
    		}
    		list.add(s);
    	}
    	
    	return list.toArray(new String[0]);
      }

    private void bfsErdos() {
		// TODO Modify this lecture code
    	// Need to initialize set, and append to global distance guy
    	Set<String> visited = new TreeSet<>();
    	Queue<String> qu = new LinkedList<>();
    	myDistance = new TreeMap<String, Integer>();
    	
    	// Initialize set somehow
    	// Append to queueu
    	myDistance.put("ERDOS", 0);
    	visited.add("ERDOS");
    	qu.add("ERDOS");
    	
 
    	// Go through ERDOS neighbors
    	// Then go through neighbors neighbors etc
    	
    	while (qu.size() > 0) {
    		String v = qu.remove();
    		for (String adj : myGraph.get(v)) {
    			if (! visited.contains(adj)) {
    				visited.add(adj);
    				qu.add(adj);
    			   	myDistance.put(adj, myDistance.get(v) + 1);
    			}
    		}
    	}
    	
    	
	}

	// Generate tree map from strings of characters
	private static void makeGraph(String[] pubs) {
		myGraph = new TreeMap<String, Set<String>>();
		for (String s : pubs) {
			// Split array at spaces
			String[] authors = s.split(" ");
			java.util.List<String> names = Arrays.asList(authors);
		
			for (String a: names) {
				myGraph.putIfAbsent(a, new TreeSet<>());
				myGraph.get(a).addAll(names);
			}
			
		}
	}
	
//	public static void main (String[] args) {
//		String[] authors = {"ERDOS B", "A B C", "B A E", "D F"};
//		makeGraph(authors);
//		for (String s: myGraph.keySet()) {
//			System.out.println("Author is : " + s);
//			System.out.println("Co authors are: " + myGraph.get(s));
//		}
//	}
}
