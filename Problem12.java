public class Problem12 {
	
	public static class SubsequenceChecker{
		public static void check(String str1, String str2) {
			int i = 0;
			int j = 0;
			int len1 = str1.length();
			int len2 = str2.length();
			int[] id = new int[len2];
			while(i < len1 && j < len2) {
				if(str1.charAt(i)==str2.charAt(j)) {
					id[j] = i; 
					j++;
				}
				i++;	
			}
			if(len2 == j) {
				System.out.println(str2+" is a subsequence of "+str1);
				for(int a : id)
					System.out.print(a+" ");
				System.out.print("\n");
			}
			else {
				System.out.println(str2+" is not a subsequence of "+str1);
			}
		}
	}

	public static void main(String[] args) {
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "pads");
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "padsx");
	}
}
