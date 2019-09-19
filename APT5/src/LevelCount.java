
public class LevelCount {
    private int curLevel = 0;
	private int total = 0;
	
	public int count(TreeNode t, int level) {
		curLevel = curLevel + 1;
		if (t == null) return 0;
    	if (level == 0) {
    		return 1;
    	}
    	nextLevel(t.left, curLevel, level);
    	nextLevel(t.right, curLevel, level);
        return total;
    }
	
	public void nextLevel(TreeNode root, int curLevel, int level) {
		if (root == null) return;
		if (curLevel == level) {
			total += 1;
		}
    	nextLevel(root.left, curLevel + 1, level);
    	nextLevel(root.right, curLevel + 1, level);
		
	}
}
