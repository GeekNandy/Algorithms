package dp.medium;

public class LongestPalindromicSubstring {

	static String findLongestPalindromicSubstrng(String str) {
		int len = str.length();
		boolean[][] roster = new boolean[len][len];
		
		int maxLen = 1;
		// all substrings of length 1 are palindrome
		for(int i=0; i<len; i++) {
			roster[i][i] = true;
		}
		
		// checking for substrings of length 2
		int start = 0;
		for(int i=0; i<len-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				roster[i][i+1] = true;
				start = i;
				maxLen = 2;
			}
		}
		
		// for lengths >2, k is length of substring
		for(int k=3; k<=len; k++) {
			// Fix the starting index
			for(int i=0; i<len-k; i++) {
				
				int j = i+k-1;
				
				if(roster[i+1][j-1] && str.charAt(i) == str.charAt(j)) {
					roster[i][j]=true;
					
					if(k>maxLen) {
						start=i;
						maxLen=k;
					}
				}
			}
		}
		
		return str.substring(start, start+maxLen);
	}
	
	public static void main(String[] args) {
		String str = "aabbad";
		System.out.println("Longest substring is "+findLongestPalindromicSubstrng(str));
	}

}
