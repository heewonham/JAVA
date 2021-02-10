import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ranNum = (int)(100 * Math.random()) + 1;
		int count = 1;
		int guess = 0;
		int numMin = 1;
		int numMax = 100;
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("["+count+"] Guess a number (" + numMin + "-" + numMax + "): ");
			guess = in.nextInt();
			if (ranNum == guess) {
				System.out.print("Correct! Number of guesses : " + count);
				break;
			}
			else if(guess > numMax || guess < numMin){
				System.out.println("Not in range!");
				continue;
			}
				
			else {
				if (ranNum > guess) {
					System.out.println("Too small!");
					count ++;
					numMin = guess+1;
				}
				else {
					System.out.println("Too large!");
					count ++;
					numMax = guess-1;
				}
			}
		}
		in.close();
	}
}
