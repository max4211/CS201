import java.util.Arrays;
import java.util.Comparator;

public class OlympicCandles {
	public class Candle implements Comparator<Candle> {
		private int mySize;

		public Candle(int height) {
			mySize = height;
		}

		public int getSize() {
			return mySize;
		}

		@Override
		public int compare(Candle o1, Candle o2) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	public int numberOfNights(int[] candles) {
		int maxN = candles.length;
		if (maxN == 1) return 1;
		for (int k = 0; k < maxN; k++) {
			// Sort candles in descending order
			Arrays.sort(candles);
			candles = newSort(candles);
			// Establish numToBurn (1 more than k)
			int numToBurn = k + 1;
			// Check if a burn is possible
//			candles = burn(candles, numToBurn);
//			if (!burnPossible(candles, numToBurn)) return numToBurn - 1;
			
			if (burnPossible(candles, numToBurn)) {
				if (candles.length == numToBurn) return numToBurn;
				candles = burn(candles, numToBurn);
			} else {
				// if (numToBurn == candles.length) return numToBurn;
				return numToBurn - 1;
			}
		}
		return -1;
	}
	
	// Helper function to sort in reverse order
	//public static int[] newSort(int[] candles) {
	public int[] newSort(int[] candles) {
		int[] guy = new int[candles.length];
		int counter = 0;
		for (int k = candles.length - 1; k >= 0; k --) {
			guy[counter] = candles[k];
			counter += 1;
		}

		return guy;
	}

	// Input candles array
	// Burn one inch from the top numToBurn candles
	public int[] burn(int[] candles, int numToBurn) {
		for (int k = 0; k < numToBurn; k++) {
			candles[k] = candles[k] - 1;
		}
		return candles;
	}

	public static boolean burnPossible(int[] candles, int numToBurn) {
		if (numToBurn > candles.length) return false;
		for (int k = 0; k < numToBurn; k++) {
			if (candles[k] == 0)return false;
		}
		return true;
	}
	
	public static void main (String[] args) {
		int[] test = {44, 4};
		int numToBurn = 2;
		System.out.println(burnPossible(test, numToBurn));
	}
}
