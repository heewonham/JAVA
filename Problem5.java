import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int score[] = new int[5];
		int bestScore = 0;
		int bestStudent = 0;
		int secondScore = 0;
		int secondStudent = 0;
		
		System.out.println("Enter exam scores of each student.");
		
		for(int i = 0; i < 5; i++) {
			System.out.printf("Score of student %d : ",i+1);
			score[i] = in.nextInt();
			if(bestScore <= score[i]) {
				secondScore = bestScore;
				secondStudent = bestStudent;
				bestScore = score[i];
				bestStudent = i+1;
			}
			else if(secondScore <= score[i]) {
				secondScore = score[i];
				secondStudent = i+1;
			}
		}
		
		System.out.println("The 1st place is student " + bestStudent + " with " + bestScore +" points.");
		System.out.println("The 2nd place is student " + secondStudent + " with " + secondScore+" points.");
		
		in.close();	
	}
}