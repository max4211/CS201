import java.util.Arrays;
import java.util.Comparator;

public class TheBestName {

	public class Person implements Comparable<Person> {
		String myName;
		int myWeight;

		public Person(String name, int weight) {
			myName = name;
			myWeight = weight;
		}

		public int compare(Person a, Person b) {
			// TODO Auto-generated method stub
			int diff = a.getWeight() - b.getWeight();
			if (!(diff == 0))
				return diff;
			else
				return compareLex(a, b);
		}

		public int compareLex(Person a, Person b) {
			int diff;
			int small = Math.min(a.getName().length(), b.getName().length());
			for (int i = 0; i < small; i++) {
				for (int k = 0; k < small; k++) {
					diff = a.getName().charAt(k) - b.getName().charAt(k);
					if (!(diff == 0))
						return diff;
				}
				if (a.getName().length() > small)
					return 1;
				if (b.getName().length() > small)
					return -1;

			}
			return 0;
		}

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			// What to do here?
			return 0;
		}

		public int getWeight() {
			return myWeight;
		}

		public String getName() {
			return myName;
		}

		@Override
		public String toString() {
			return myName;
		}

	}

	public String[] sort(String[] names) {
		// Create a list of people
		Person list[] = new Person[names.length];
		String name;
		for (int k = 0; k < list.length; k++) {
			name = names[k];
			list[k] = new Person(name, weight(name));
		}

		Arrays.sort(list, Comparator.comparing(Person::getWeight).reversed().thenComparing(Person::getName));

		for (int k = 0; k < names.length; k++) {
			names[k] = list[k].toString();
		}
		return names;

	}

	public int weight(String name) {
		// public static int weight(String name) {
		if (name.equals("JOHN")) return Integer.MAX_VALUE;
		int guy = 0;
		char cur;
		for (int i = 0; i < name.length(); i++) {
			cur = name.charAt(i);
			guy += cur - 64;
		}
		return guy;
	}

//	public static void main (String[] args) {
//		System.out.println(weight("JOHN"));
//		System.out.println(weight("LISA"));
//	}
}
