
public class TreeTighten {
	public TreeNode tighten(TreeNode t) {

		if (t.left == null && t.right == null) return t;
		
		if (t.left == null) { // if root doesn't have two branches
			return tighten(t.right);
		}
		
		if (t.right == null) {
			return tighten(t.left);
		}
		
		// cases don't work are getting here, what am I missing?
		// At this point, both t.left and t.right should have nodes
		
		if (!(t.right == null && t.left == null)) {
			t.left = tighten(t.left);
			t.right = tighten(t.right);
		}
		// return null;
		return t;
	}
}
