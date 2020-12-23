package dp.standard;

/**
 * @author Sharad
 *
 */
public class PrintLongestCommonSubsequence {

	static void printLCS(String s1, String s2) {
		
		char[] s1arr = s1.toCharArray();
		char[] s2arr = s2.toCharArray();
		
		int m = s1arr.length, n = s2arr.length;
		
		int[][] L = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0||j==0) L[i][j] = 0;
				else if(s1arr[i-1]==s2arr[j-1]) L[i][j] = 1+L[i-1][j-1];
				else L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
			}
		}
		
		int index = L[m][n];
		int i = m, j = n;
		
		char[] lcs = new char[index+1];
		lcs[index] = '\u0000'; // marking end of string
		
		while(i>0 && j>0) {
			if(s1arr[i-1] == s2arr[j-1]) {
				lcs[index-1] = s1arr[i-1];
				i--;
				j--;
				index--;
			}
			else if(L[i-1][j]>L[i][j-1]) i--;
			else j--;
		}
		
		for(char c: lcs) System.out.print(c);
	}
	
	public static void main(String[] args) {
		String s1 = "AGGTAB", s2 = "GXTXAYB";
		printLCS(s1, s2);
	}

}
