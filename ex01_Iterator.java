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
		/* Iterator�� Previous ����.
		 * it�� �� ó�� �����͸� ����Ų��. �׷��� ���� next�� �Ѱ����� �ʰ�
		�ٷ� previous�� �ϸ� ��µ��� �ʴ´�.*/
		while(it.hasNext()) {
			System.out.println(it.next());
		}// 
		System.out.println();
		while(it.hasPrevious()) {
			System.out.print(it.previous());
		}
	}
}
