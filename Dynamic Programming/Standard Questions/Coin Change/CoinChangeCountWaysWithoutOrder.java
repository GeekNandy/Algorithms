package dp.standard;

/**
 * @author Sharad
 *
 */
public class CoinChangeCountWaysWithoutOrder {

	static int getNumOfWays(int[] arr, int n) {
		int m = arr.length, inclJ=0, exclJ=0;
		int[][] table = new int[n+1][m];
		
		for(int i=0; i<m; i++) table[0][i] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<m; j++) {
				
				inclJ = (i-arr[j]>-1)?(table[i-arr[j]][j]):0;
				exclJ = (j>0)?(table[i][j-1]):0;
				
				table[i][j] = inclJ+exclJ;
			}
		}
		
		return table[n][m-1];
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		int n = 4;
		System.out.println(getNumOfWays(arr, n));
	}

}
