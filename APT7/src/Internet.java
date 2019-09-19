import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Internet {
	
	private Map<String, Set<String>> myGraph = new HashMap<String, Set<String>>();
	
    public int articulationPoints(String[] routers) {
       makeGraph(routers);
       int total = 0;
       for (int k = 0; k < routers.length; k ++) {
    	   String vertex = "" + k;
    	   String start = "0";
    	   if (k == 0) start = "1"; // Must start @ something different than skipping
    	   Set<String> set = reachFromSkip(start, vertex);
    	   if (set.size() != routers.length - 1) {
    		   total += 1;
    	   }
       }
       return total;
    }

    // Do BFS or DFS but SKIP vertex (don't push it)
    // Slide 39 from huff-graphs(24) lecture
	private Set<String> reachFromSkip(String start, String vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	// Assign myGraph to something
	private void makeGraph(String[] routers) {
		// TODO Auto-generated method stub
		
		
	}
	
    // Use BFS code slide 30 in slideset 24 (huff-graphs)
    // Could alsu use dfs
    public Set<String> bfs (String start, String vertex) {
    	Set<String> visited = new TreeSet<>();
    	Queue<String> qu = new LinkedList<>();
    	visited.add(start);
    	qu.add(start);
    	
    	while (qu.size() > 0) {
    		String v = qu.remove();
    		for (String adj: myGraph.get(v)) {
    			if (! visited.contains(adj)) {
    				visited.add(adj);
    				qu.add(adj);
    			}
    		}
    	}
    	
    	return visited;
    }
}
