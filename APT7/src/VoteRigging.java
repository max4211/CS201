import java.util.Arrays;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        // Check base case
    	if (votes.length == 1) return 0;
    	// Make a new array containing all competitors
    	int[] competition = new int [votes.length - 1];
    	for (int i = 0; i < competition.length; i ++) {
    		competition[i] = votes[i + 1];
    	}
    	int me = votes[0];
    	int most = competition.length-1;
    	Arrays.sort(competition);
    	int max = competition[most];
    	int count = 0;
    	while (me <= max) {
    		count += 1;
    		me += 1;
    		competition = steal(competition, most);
    		max = competition[most];
    	}
    	
    	return count;
    }
    
    // Steal one vote from the greatest competitor
    // Return new array
    public int[] steal(int[] competition, int most) {
    	Arrays.sort(competition);
    	competition[most] = competition[most] - 1;
    	Arrays.sort(competition);
    	return competition;
    }
    
//    public static void main (String[] args) {
//    	int[] votes = {60, 30, 20, 100, 421, 8};
//    	int most = votes.length - 1;
//    	votes = steal(votes, most);
//    	
//    	for (int i = 0; i < votes.length; i ++) {
//    		System.out.println(votes[i]);
//    	}
    	
//   }
}
