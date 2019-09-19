public class TrueSpace {
	public long calculateSpace(int[] sizes, int clusterSize) {
		// fill in code here
		long space = 0;
		int clusters; // allocated clusters
		double remainFloor;
		int sizesI;

		for (int i = 0; i < sizes.length; i++) { // scan through each number in sizes
			clusters = 0;
			remainFloor = 0;

			if (!(sizes[i] == 0)) { // if the size isn't zero, then we need to allocate memory
				remainFloor = Math.floor(sizes[i] / clusterSize);	// floor the division of the two to find minimum of clusters
				clusters += remainFloor; 
				
				if (!(sizes[i] % clusterSize == 0)) // if the there is a remainder, add 1 to clusters 
					clusters += 1;
			}
			space += clusters * clusterSize;
		}
		
		// Try another method
		
//		for (int j = 0; j < sizes.length; j ++) {
//			clusters = 0;
//			sizesI = sizes[j];
//			
//			if (!(sizesI == 0)) {
//				do {
//					sizesI = sizesI - clusterSize;
//					clusters ++;
//				} while (sizesI >= 0);
//			}			
//			space += clusters*clusterSize;
//		}

		return space;
	}
	/*
	 * Psuedocode: If sizes isn't zero Divide the sizes by cluster size That is how
	 * many current "cluster sizes we need" Floor the remainder, if this value
	 * equals the remainder, then we are done If the two values are not equal, then
	 * we need to allcoate one more clusterSize
	 * 
	 */
}