import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class UniqueTreeValues {
	private ArrayList<Integer> vals = new ArrayList<Integer>();
	// public TreeMap<Integer> tm = new TreeMap<Integer>();

	public int[] unique(TreeNode root) {
		// May need to correct this, could be empty of correct size
		if (root.left == null && root.right == null) {
			int[] ret = new int[1];
			ret[0] = root.info;
			return ret;
			
		}
		
		appendList(root);
		
		// At this point, should have an array list of ints
		Collections.sort(vals);
		
		int[] ret = new int[vals.size()];
		for (int i = 0; i < vals.size(); i ++) {
			ret[i] = vals.get(i);
		}
		
		return ret;
	}

	public void appendList(TreeNode root) {
		if (!(vals.contains(root.info)))
			vals.add(root.info);

		if (!(root.left == null))
			appendList(root.left);
		if (!(root.right == null))
			appendList(root.right);

	}
}
