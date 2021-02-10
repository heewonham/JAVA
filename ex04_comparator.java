package cse3040_18;

import java.util.Arrays;
import java.util.Comparator;

/*class Descending<T> implements Comparator<T> {
	public int compare(T o1, T o2) {
	if(o1 instanceof Comparable && o2 instanceof Comparable) {
		Comparable c1 = (Comparable)o1;
		Comparable c2 = (Comparable)o2;
		return c1.compareTo(c2) * -1; // reverse order
	}
	return -1; // undefined
	}
}*/
class Descending implements Comparator<String>{
	public int compare(String o1, String o2) {
		return o1.compareTo(o2) * -1;
	}
}

public class ex04_comparator {

	public static void main(String[] args) {
		String[] strArr = {"lion", "DOG", "TIGER", "cat"};
		System.out.println("strArr = " + Arrays.toString(strArr));
		Arrays.sort(strArr);
		System.out.println("strArr = " + Arrays.toString(strArr));
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr = " + Arrays.toString(strArr));
	}
}
