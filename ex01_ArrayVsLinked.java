package cse3010_17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ex01_ArrayVsLinked {
	
	static long add1(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<1000000; i++) list.add(i+"");
		long end = System.currentTimeMillis();
		return end - start;
	}
	static long add2(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++) list.add(500,"X");
		long end = System.currentTimeMillis();
		return end - start;
	}
	static long remove1(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=list.size()-1; i>=0;i--) list.remove(i);
		long end = System.currentTimeMillis();
		return end - start;
	}
	static long remove2(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<1000000; i++) list.remove(i);
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		ArrayList<String> a1= new ArrayList<>(2000000);
		LinkedList<String> l1 = new LinkedList<>();
		System.out.println("ArrayList: "+add1(a1));
		System.out.println("LinkedList: "+add1(l1));
		// LinkedList add�� ó���� ��������� reference�� �����.
		// �׷��� �������� �߰��ϱ� ���ؼ� ��ó������ ������ �ʴ´�.
		
		System.out.println();
		System.out.println("ArrayList: "+add2(a1));
		System.out.println("LinkedList: "+add2(l1));
		
		System.out.println();
		System.out.println("ArrayList: "+remove1(a1));
		System.out.println("LinkedList: "+remove1(l1));
		
		System.out.println();
		System.out.println("ArrayList: "+remove2(a1));
		System.out.println("LinkedList: "+remove2(l1));		
		// �տ��� �����ϴ� ���� �Ű��� ���� ���� ������ ArrayList�� ȿ���� ���� ���ϴ�.
		
	}
}