package dp.standard;

/**
 * @author Sharad
 *
 */
public class LongestCommonSubsequenceLength {

	static int getLCSlen(String first, String second) {
		char[] firstArr = first.toCharArray();
		char[] secondArr = second.toCharArray();
		int m = firstArr.length;
		int n = secondArr.length;
		
		int[][] L = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0 || j==0) L[i][j] = 0;
				else if(firstArr[i-1]==secondArr[j-1]) L[i][j] = L[i-1][j-1] + 1;
				else L[i][j] = Math.max(L[i-1][j], L[i] [j-1]);
			}
		}
		
		return L[m][n];
	}
	
	public static void main(String[] args) {
		String first = "AGGTAB", second = "GXTXAYB";
		System.out.println("Length of LCS is = "+getLCSlen(first, second));
	}

}
