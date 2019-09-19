import java.util.Arrays;
import java.util.Comparator;

public class Dirsort {
	public class DirComp implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			// TODO Auto-generated method stub
			String[] arr = a.split("/");
			String[] brr = b.split("/");
			
			int diff = arr.length - brr.length;
			
			if (!(diff == 0)) return diff;
			// Strings at same depth, sort alphabetically
			else return compareSameDepth(arr, brr);
		}
		
		private int compareSameDepth(String[] a, String[] b) {
			String acur;
			String bcur;
			int diff;
			int small;
			for (int i = 0; i < a.length; i ++) {
				acur = a[i]; bcur = b[i];
				small = Math.min(acur.length(), bcur.length());
				for (int k = 0; k < small; k ++) {
					diff = acur.charAt(k) - bcur.charAt(k);
					if (!(diff == 0)) return diff;
				}
				if (acur.length() > small) return 1;
				if (bcur.length() > small) return -1;
					
			}
			return 0;
		}
	}
	
	public String[] sort(String[] dirs) {
		
		Arrays.sort(dirs, new DirComp());
		return dirs;
	}
}
