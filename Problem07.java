import java.util.Scanner;

interface IntSequenceStr{
	boolean hasNext();
	char next();
}
class BinarySequenceStr implements IntSequenceStr{
	private int i; 	private int j;
	private String str = new String();
	
	public BinarySequenceStr(int num) {
		for(i = 0; ; i++) {	if(num < Math.pow(2, i)){ i--; break; }}
		for(j = i; j >= 0; j--) {
			if(num >= Math.pow(2,j)) {
				str += '1';
				num -= Math.pow(2, j);	}
			else
				str += '0';		}
	}
	public boolean hasNext() {
		if(++j <= i ) return true;
		else return false; 
	}
	public char next() {
		return str.charAt(j);
	}
}

public class Problem07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		String str = in.nextLine();
		int num = Integer.parseInt(str);
		in.close();
		System.out.println("Integer: " + num);
		IntSequenceStr seq = new BinarySequenceStr(num);
		System.out.print("Binary number: ");
		while(seq.hasNext()) System.out.print(seq.next());
		System.out.println(" ");
	}
}