import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FriendScore {
	// Data input is an adjacency matrix
	private static Map<Integer, Set<Integer>> myGraph;

	public int highestScore(String[] friends) {
		makeGraph(friends);
		int max = 0;
		for (int k = 0; k < friends.length; k++) {
			Set<Integer> set = twoFriends(k);
			max = Math.max(set.size(), max);
		}
		if (max == 0) return 0;
		else return max - 1;
	}

	// Find all two friends of the kth indexed person
	private Set<Integer> twoFriends(int k) {
		Set<Integer> set = myGraph.get(k);
		Set<Integer> newSet = new HashSet<Integer>(set);
		for (int friend: myGraph.get(k)) {
			newSet.addAll(myGraph.get(friend));
		}
		return newSet;
	}
	
	private static void makeGraph(String[] friends) {
		myGraph = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < friends.length; i ++) {
			String cur = friends[i];
			Set<Integer> guy = new HashSet<Integer>();
			for (int k = 0; k < cur.length(); k ++) {
				if (cur.charAt(k) == 'Y') guy.add(k);
			}
			myGraph.put(i, guy);
		}
	}
}