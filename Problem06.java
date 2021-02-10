interface IntSequence{
	boolean hasNext();
	int next();
}
class FibonacciSequence implements IntSequence{
	private int fibo1 = 0;
	private int fibo2 = 1; 
	private int num = 0;
	private int sum = 0;
	public boolean hasNext() {
		return true;
	}
	public int next() {
		if(num == 0) { num ++; 	return fibo1; }
		else if(num == 1){ 	num++; 	return fibo2; }
		else {
			sum = fibo1 + fibo2; fibo1 = fibo2;
			fibo2 = sum; num++;
			return sum;
		}
	}
}
public class Problem06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntSequence seq = new FibonacciSequence();
		for(int i=0; i<20; i++) {
			if(seq.hasNext() == false) break;
			System.out.print(seq.next() + " ");
		}
		System.out.println(" ");
	}
}
