import java.util.Map;
import java.util.TreeMap;

public class LeafCollector {

	// This map tracks what round you are on
	private Map<Integer, String> myMap = new TreeMap<Integer, String>();
	// private Map<Integer, String> myOtherMap = new HashMap<Integer, String>();
	private Map<Integer, String> nodeCounter = new TreeMap<Integer, String>();
	
	public String[] getLeaves(TreeNode tree) {
		if (tree.left == null && tree.right == null) {
			String[] leaves = new String[1];
			leaves[0] = Integer.toString(tree.info);
			return leaves;
		}
		// Starting off on round 0 because nothing has been removed yet
		int round = 0;
		if (!(tree.left == null)) {
			mapFiller(leafRemove(tree.left, tree, round), round + 1);
		} else if (!(tree.right == null)) {
			mapFiller(leafRemove(tree.right, tree, round), round + 1);
		}
		
		// At this point, should have a tree map with integer values corresponding to rounds removed at
		
    	String[] allLeafs = new String [myMap.size()];
    	int counter = 0;
    	
    	// Need to do a descending key set? Or input everything in round order
    	for (int s: myMap.keySet()) {
    		allLeafs[counter] = myMap.get(s);
    		counter += 1;
    	}
		
		return allLeafs;
	}
	
	// Recursively calls leaf remove and adds to the hashMap accordingly
	public void mapFiller(TreeNode tree, int round) {
		// Terminate when the tree is null
		if (tree == null) return;
		
		// Otherwise scan through the left first and then the right
		// The input tree is going to be the removed leaves
		if (!(tree.left == null)) {
			mapFiller(leafRemove(tree.left, tree, round), round + 1);
		}
		if (!(tree.right == null)) {
			mapFiller(leafRemove(tree.right, tree, round), round + 1);
		}
				
	}

	
	// Returns a tree without leaves
	// Appends the leaves to the hashMap
	public TreeNode leafRemove(TreeNode tree, TreeNode parent, int round) {
		// You are at a leaf, then remove that leaf and add it to the HashMap
		if (tree.left == null && tree.right == null) {
			if (!(myMap.containsKey(round))) {
				myMap.put(round, Integer.toString(tree.info));
			} else {
				myMap.put(round, myMap.get(round) + " " + Integer.toString(tree.info));
			}
			// Now remove leaf
			// Check which side the leaf came from and remove it
			if (parent.left == tree) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		
		// NEED TO MAKE SURE ALL LEAVES WERE REMOVED BEFORE RETURNING PARENT
		// How do I do this?
		// Could do a counter for rounds and leaves to remove, but if I knew that then I could do the APT easily :(
		
		// You may not be at a leaf, and will have to keep going to remove all leaves
		if (!(tree.left == null)) leafRemove(tree.left, tree, round);
		if (!(tree.right == null)) leafRemove(tree.right, tree, round);
		
		return parent;
	}
	
	// Scan through the tree and index each node with the amount of nodes on each level
	public void nodeIndex (TreeNode tree, int level) {
		if (tree.left == null && tree.right == null) return;
		if (!(tree.left == null)) {
			
		}
	}
}
