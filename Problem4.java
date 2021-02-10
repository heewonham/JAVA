import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = new String();
		int count = 0;
		int i = 0;

		System.out.print("Enter a text: ");
		String text = in.nextLine();

		while(true) {
			System.out.print("Enter a string: ");
			str = in.nextLine();
			if(str.length() == 0) {
				System.out.println("You must enter a string.");
				continue;
			}
			else {
				char chStr[] = str.toCharArray();
				char chText[] = text.toCharArray();
				while(i <= text.length()-str.length()) {
					for(int j = 0; j < str.length(); j++) {
						if(chStr[j] != chText[i+j])
							break;
						if(j == str.length()-1) {
							count++;
						}
					}
					i++;
				}
				System.out.print("There are " + count +
						" instances of " + "\"" + str +"\"" + ".\n");
				break;
			}
		}
		in.close();	
	}
}