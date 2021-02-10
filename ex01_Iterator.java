package cse3040_18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ex01_Iterator {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		//Iterator<String> it = list.iterator();
		ListIterator<String> it = list.listIterator();
		/* Iterator은 Previous 없음.
		 * it은 맨 처음 포인터를 가르킨다. 그래서 만약 next를 넘겨주지 않고
		바로 previous를 하면 출력되지 않는다.*/
		while(it.hasNext()) {
			System.out.println(it.next());
		}// 
		System.out.println();
		while(it.hasPrevious()) {
			System.out.print(it.previous());
		}
	}
}
