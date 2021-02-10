package cse3040_16;

import java.util.ArrayList;
import java.util.Collections;

public class ex01_usingArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>(10);
		list1.add(Integer.valueOf(5));
		list1.add(Integer.valueOf(4));
		list1.add(Integer.valueOf(2));
		list1.add(Integer.valueOf(0));
		list1.add(Integer.valueOf(1));
		list1.add(Integer.valueOf(3));
		
		ArrayList<Integer> list2 = new ArrayList<Integer>(list1.subList(1, 4));
		print(list1,list2);	
		
		Collections.sort(list1); // sort�� �� �ִ� Ÿ���� �ִ�.
		Collections.sort(list2);
		print(list1,list2);
		
		System.out.println("list1.containsAll(list2): "+list1.containsAll(list2));
		
		list2.add(Integer.valueOf(11));
		list2.add(Integer.valueOf(12));
		list2.add(Integer.valueOf(13));
		print(list1,list2);
		
		list2.set(3, Integer.valueOf(21));
		print(list1,list2);
		
		System.out.println("list1.retainAll(list2): "+list1.retainAll(list2));
		// �ٲ�� true�� ����.
		print(list1,list2);// retainAll list1�� list2 ����Ǵ°͸� ���ܶ�
		
		for(int i=list2.size()-1; i>=0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		// ���ʷ��ϸ� �����Ǵ� ���� �ε������� �ٲ� �����ÿ����� ����.
	
	
	
	}
	static void print(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		System.out.println("list1: "+list1);
		System.out.println("list2: "+list2);
		System.out.println();
	}
}