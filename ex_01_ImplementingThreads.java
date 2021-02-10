package cse3040_23;

class ThreadEx1_1 extends Thread{
	public void run() {
		for(int i=0; i<5; i++)
			System.out.println(getName());
	}
}
class ThreadEx1_2 implements Runnable{
	public void run() {
		for(int i=0; i<5; i++)
			System.out.println(Thread.currentThread().getName());
	}
}
public class ex_01 {

	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
}
// 순서가 정해져 있지 않다. concurrent하다.