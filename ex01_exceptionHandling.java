package cse3040_13;

public class ex01_exceptionHandling {
	public static void main(String args[]) {
		int number = 100;
		int result = 0;
		
		for(int i=0; i<10; i++) {
			try {
				result = number / (int)(Math.random()*10);
				System.out.println(result);
			} catch(ArithmeticException e) {
				// 상위 클래스를 써도 된다.
				System.out.println("division by zero");
			}
		}
	}
}