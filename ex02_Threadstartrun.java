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
		// main과 run이 구분되어 run 부분만 보임.
		t1.run();
		// main,run이 실행되는 thread 같아서 같이 보임.
	}
}
