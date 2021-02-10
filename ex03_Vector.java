package cse3040_16;

import java.util.Vector;

public class ex03_Vector {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>(5);
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		v.trimToSize();
		System.out.println("=== After trimToSize() ===");
		print(v);
		
		v.ensureCapacity(6);
		System.out.println("=== After ensureCapacity() ===");
		print(v);
		
		v.setSize(7);
		System.out.println("=== After setSize(7) ===");
		print(v);
		// setSize가 두배 이상으로 설정한 경우에는 capacity도 그 숫자로 맞춰준다.
		// setSize가 두배가 안되면 그 숫자의 두배까지 capacity로 맞춰준다
		
		v.clear();
		System.out.println("=== After clear() ===");
		print(v);
	}
	
	public static void print(Vector<?> v) {
		System.out.println(v);
		System.out.println("size: "+v.size());
		System.out.println("capacity: " + v.capacity());
	}
}
