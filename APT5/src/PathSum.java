import java.util.ArrayList;

public class PathSum {
	
	// Appended every time a complete path is given
	private ArrayList<Integer> allPaths = new ArrayList<Integer>();
	
    public int hasPath(int target, TreeNode tree){
    	if (tree == null) return 0;
    	if (tree.left == null && tree.right == null) {
    		if (tree.info == target) return 1;
    		return 0;
    	}
    	
    	tracePath(tree, tree.info);
    	
    	if (allPaths.contains(target)) return 1;
    	
        return 0;
    }
    
    // input a tree and the total pathsum so far
    public void tracePath(TreeNode tree, int soFar) {
    	if (tree.left == null && tree.right == null) allPaths.add(soFar);
    	
    	// You know only one is null or neither are null, so don't have to worry about null pointer
    	if (!(tree.left == null)) tracePath(tree.left, soFar + tree.left.info);
    	if (!(tree.right == null)) tracePath(tree.right, soFar + tree.right.info);
    	
//    	// Other cases, both tree.left and tree.right exist
//    	if (!(tree.left == null || tree.right == null)) {
//        	tracePath(tree.right, soFar + tree.right.info);
//        	tracePath(tree.left, soFar + tree.left.info);
//    	}

    	
    }
    
    
}
