import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(true) {
			// ASCII 65~122
			System.out.print("ASCII code teller. Enter a letter : ");
			String code = in.nextLine();
			
			if(!code.isEmpty()) {
				String letter = code.trim();
				if(letter.length() == 1 && (letter.charAt(0) > 64 && letter.charAt(0) < 123)){
					System.out.print("The ASCII code of " + letter
							+ " is " + (int)letter.charAt(0)+".\n");
				}
				else{
					System.out.println("You must input a single uppercase or lowercase a alphabet.");
					break;
				}
			}
			else{
				System.out.println("You must input a single uppercase or lowercase a alphabet.");
				break;
			}
		}
		in.close();
	}
}