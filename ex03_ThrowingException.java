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
			// 이것은 crush가 나지 않고 trace를 출력!!
			// 그러나 전부(main까지) Throws Exception을 해주면 crush가 나면서 trace를 출력해준다.
		//}
	}
}