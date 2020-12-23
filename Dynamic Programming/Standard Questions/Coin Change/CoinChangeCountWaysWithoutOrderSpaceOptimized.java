package dp.standard;

/**
 * @author Sharad
 *
 */
public class CoinChangeCountWaysWithoutOrderSpaceOptimized {
	
	static int getNumOfWays(int[] arr, int n) {
		int[] table = new int[n+1];
		table[0] = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j=arr[i]; j<=n; j++) {
				table[j]+=table[j-arr[i]];
			}
		}
		return table[n];
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		int n = 4;
		System.out.println(getNumOfWays(arr, n));
	}

}
