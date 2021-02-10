package cse3040_23;

class ThreadEx5_1 extends Thread{
	public void run() {
		for(int i=0; i < 300; i++)
			System.out.printf("%s",new String("|"));
		System.out.print("elapsed time 2: "+(System.currentTimeMillis()-ex04.startTime));
	}
}
// 번갈아가면서 동시에 실행되고 있음을 알 수 있다.
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
/* 화면에 찍는 경우 양이 많을 수록 multiThread가 시간이 더 걸린다. 
 * 화면에 안찍는 경우 multi가 동시에 끝나서 더 좋다. */