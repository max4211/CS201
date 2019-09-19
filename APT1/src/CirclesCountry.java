
public class CirclesCountry {
	public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
		// my code here
		int crosses = 0;
		// maybe length - 1
		for (int i = 0; i < x.length; i++) {
			if (isInside(x1, y1, x[i], y[i], r[i]) != isInside(x2, y2, x[i], y[i], r[i])) {
				crosses+=1;
			} 
		}
		return crosses;
	}

	public boolean isInside(int x, int y, int cx, int cy, int r) {
		// variable distance calculation
		double dist = (x-cx) * (x-cx) + (y-cy) * (y-cy);
		// don't need square root because comparing to r^2
		// double dist2 = r * r;
		return dist < r*r;
	}
}
