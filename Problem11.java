public class Problem11 {
	
	public static class PalindromeChecker{
		public static void check(String c) {
			int i = 0;
			int len = c.length();
			while(i < (len/2)) {
				if(c.charAt(i) != c.charAt(len-i-1)){
					System.out.println(c + " is not a palindrome.");
					return;	}
				i++;
			}
			System.out.println(c + " is a palindrome.");
		}
		public static void check(int c) {
			int i = 0;
			String str = Integer.toString(c); 
			int len = str.length();
			while(i < (len/2)) {
				if(str.charAt(i) != str.charAt(len-i-1)){
					System.out.println(c + " is not a palindrome.");
					return;  }
				i++;
			}
			System.out.println(c + " is a palindrome.");	
		}
	}
	public static void main(String[] args) {		
		PalindromeChecker.check("abcde");
		PalindromeChecker.check("abcba");
		PalindromeChecker.check(1234);
		PalindromeChecker.check(12321);
	}
}