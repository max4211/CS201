public class DNAMaxNucleotide {
	public String max(String[] strands, String nuc) {
		// fill in code here

		// for some reason I am defaulting returning the last sequence??
		// method 2, expecting quicker runtime, check occurrences and length at the same
		// time and only store one value
		int strandsSize = strands.length;
		String seq = ""; // current sequence I am analyzing
		int currentOccurances; // times nucleotide occurs in current sequence
		int mostOccurances = 0; // most nucleotide occurrences, default to 1 to account for empty case
		String longestSeq = "";
		String guy = ""; // character to string

		for (int i = 0; i < strandsSize; i++) {
			// reset the counter for each new sequence
			currentOccurances = 0; // default current occurrences to 0
			seq = strands[i]; // analyze i'th index strand
			// scan through a single sequence, checking for the letter
			for (int j = 0; j < seq.length(); j++) {
				guy = Character.toString(seq.charAt(j));
				// add to the counter each time the nucleotide occurs
				if (guy.equals(nuc)) {
					currentOccurances += 1;
				}
			}
			// check for most occurrences and the longest sequence
			// if this condition never happens, then longestSeq stays empty
			// if (currentOccurances >= mostOccurances && seq.length() > longestSeq.length()
			// && currentOccurances > 0) {
			if (currentOccurances > 0) {
				if (currentOccurances > mostOccurances) {
					mostOccurances = currentOccurances;
					longestSeq = seq;
				}
				if (currentOccurances == mostOccurances && seq.length() > longestSeq.length()) { // check length as tiebreaker
					// recast most occurrences
					mostOccurances = currentOccurances;
					// establish longest string
					longestSeq = seq;
				}
			}
		}
		return longestSeq;
	}
}