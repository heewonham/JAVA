package cse3040_23;

class ThreadEx5_1 extends Thread{
	public void run() {
		for(int i=0; i < 300; i++)
			System.out.printf("%s",new String("|"));
		System.out.print("elapsed time 2: "+(System.currentTimeMillis()-ex04.startTime));
	}
}
// �����ư��鼭 ���ÿ� ����ǰ� ������ �� �� �ִ�.
public class ex04 {
	static long startTime = 0;
	public static void main(String[] args) {
		ThreadEx5_1 t1 = new ThreadEx5_1();
		t1.start();
		startTime = System.currentTimeMillis();
		for(int i =0; i <300; i++)
			System.out.printf("%s",new String("-"));
		System.out.print("elapsed time 1: "+(System.currentTimeMillis()-ex04.startTime));
	}
}
/* ȭ�鿡 ��� ��� ���� ���� ���� multiThread�� �ð��� �� �ɸ���. 
 * ȭ�鿡 ����� ��� multi�� ���ÿ� ������ �� ����. */