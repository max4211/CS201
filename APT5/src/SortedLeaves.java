import java.util.ArrayList;

public class SortedLeaves {
	
	private ArrayList<String> letters = new ArrayList<String>();
	
    public String[] values(TreeNode tree) {
        if (tree == null) return new String [0];
        	// return letters.toArray();
        	// Change below to ^^

        scanTree(tree);
        letters.sort(null);
        // Change this return to letters Array
        return letters.toArray(new String[letters.size()]);
    }
    
    // Scan through tree, appending letters when you get to the end of the tree
    public void scanTree (TreeNode tree) {
    	if (tree.left == null && tree.right == null) letters.add(Character.toString((char) tree.info));
    	
    	if (!(tree.left == null)) scanTree(tree.left);
    	if (!(tree.right == null)) scanTree(tree.right);
    	
    }
}
