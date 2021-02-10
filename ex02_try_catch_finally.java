package cse3040_13;

public class ex02_try_catch_finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(1/0);
			System.out.println(4);
		} catch(ArithmeticException e) {
			System.out.println(5);
		} catch(Exception e) {
			System.out.println(6);
		} finally {
			System.out.println(7);
		}
		System.out.println(8);
	}
}