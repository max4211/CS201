import java.util.ArrayList;
import java.util.Collections;

public class AllPaths {
	private ArrayList<String> myList = new ArrayList<String>();
	
    public String[] paths(TreeNode root) {
    	myList = new ArrayList<String>();
        if (root == null) return new String[0];
        findPaths(root, "");
        Collections.sort(myList);
        return myList.toArray(new String[0]);
    }
  
    public void findPaths(TreeNode tree, String path) {
    	// append myList in this method
    	// Base case, at the bottom of the tree
    	if (tree.left == null && tree.right == null) 
    		myList.add(path + tree.info);
    	if (!(tree.left == null)) 
    		findPaths(tree.left, path + tree.info + "->");
    	if (!(tree.right == null)) 
    		findPaths(tree.right, path + tree.info + "->");
    }
}