package cse3040_23;

class ThreadEx2_1 extends Thread{
	public void throwException() {
		try {
			throw new Exception();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run() {
		throwException();
	}
}
public class ex02 {

	public static void main(String[] args) {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
		// main�� run�� ���еǾ� run �κи� ����.
		t1.run();
		// main,run�� ����Ǵ� thread ���Ƽ� ���� ����.
	}
}
