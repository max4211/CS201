public class LeafSum {
	public int sum(TreeNode t) {
		// replace with working code
		if (t == null) return 0;
		if (t.left == null && t.right == null) return t.info;
		return sum(t.left) + sum(t.right);
	}
}