package cse3040_13;

public class ex03_ThrowingException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
	}
	static void method1() {
		try {
			method2();
		}catch(Exception e) {
			System.out.println("method handled at method_1");
		}
	}
	static void method2() throws Exception {
		//try {
			throw new Exception();
		//}catch(Exception e) {
		//	e.printStackTrace();
			// �̰��� crush�� ���� �ʰ� trace�� ���!!
			// �׷��� ����(main����) Throws Exception�� ���ָ� crush�� ���鼭 trace�� ������ش�.
		//}
	}
}