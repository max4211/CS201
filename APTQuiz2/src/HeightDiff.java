
public class HeightDiff {
	
	private int mySubDiff;
	
	public int maxhd(TreeNode root) {
		// Check base cases
		if (root.left == null && !(root.right == null)) return height(root.right);
		if (!(root.left == null) && root.right == null) return height(root.left);
		if (root.left == null && root.right == null) return 0;
		
//		subDiff(root.left);
//		subDiff(root.right);
		subDiff(root);
		
		int overall = Math.abs(height(root.left) - height(root.right));
		
		return Math.max(mySubDiff, overall);
	}
	
	// Find max diff between two guys
	public void subDiff(TreeNode root) {
		int curDiff;
		if (root.left == null && !(root.right == null)) {
			curDiff = height(root.right);
			mySubDiff = Math.max(curDiff, mySubDiff);
			subDiff(root.right);
		} else if (!(root.left == null) && root.right == null) {
			curDiff = height(root.left);
			mySubDiff = Math.max(curDiff, mySubDiff);
			subDiff(root.left);
		} else {
			// Otherwise, neither are null
			curDiff = height(root.left) - height(root.right);
			mySubDiff = Math.max(curDiff, mySubDiff);
			if (!(root.right == null)) subDiff(root.right);
			if (!(root.left == null)) subDiff(root.left);
		}
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
