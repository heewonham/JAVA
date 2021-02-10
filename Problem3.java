import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String letter = new String();
		int count = 0;
		int i = 0;

		System.out.print("Enter a text: ");
		String text = in.nextLine();

		while(true) {
			System.out.print("Enter a letter: ");
			letter = in.nextLine();

			if(!letter.isEmpty()) {
				if(letter.trim().length() == 1) {
					char ch[] = text.toCharArray();
					for(i = 0; i < text.length(); i++) {
						if(ch[i] == letter.trim().charAt(0))
							count++;
					}
					System.out.print("There are " + count +
							" "+ letter.trim().charAt(0) + "'s in the text.");
					break;
				}
				else{
					System.out.println("You must enter a single letter.");
					continue;
				}
			}
			else {
				System.out.println("You must enter a single letter.");
				continue;
			}
		}
		in.close();	
	}
}