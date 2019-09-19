import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LeafTrails {
	
	private TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
	
    public String[] trails(TreeNode tree) {
    	if (tree == null) return new String [0];
    	
    	// Otherwise, there are trails that we must traverse through
    	traverse(tree, "");
    	
    	String[] allTrails = new String [tm.size()];
    	int counter = 0;
    	for (int s: tm.keySet()) {
    		allTrails[counter] = tm.get(s);
    		counter += 1;
    	}
    	
        return allTrails;
    }
    
    // scan through the tree, adding to the tree map when you get to a node
    public void traverse(TreeNode tree, String path) {
    	// When you are at a leaf, add the path so far
    	if (tree.left == null && tree.right == null) tm.put(tree.info, path);
    	
    	// Otherwise, call traverse again and add the direction you are heading
    	if (!(tree.left == null)) traverse(tree.left, path + "0");
    	if (!(tree.right == null)) traverse(tree.right, path + "1");
    	
    }
}
