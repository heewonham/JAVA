package cse3040_23;

public class ex03 {

	public static void main(String[] args) {
		// sequence�ϰ� ���ư��� �ִ�.
		long startTime = System.currentTimeMillis();
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.print("elapsed time: "+ (System.currentTimeMillis() - startTime));
		
		for(int i =0; i<300; i ++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.print("elapsed time: "+(System.currentTimeMillis()-startTime));
	}
}
