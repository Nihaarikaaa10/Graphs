class Solution {
    public static final int MOD = 1000000007;
    
    // Method to count subsets of 'arr' that sum up to 'sum'
    static int countSubsets(int[] arr, int n, int sum) {
        // Initialize a 2D DP array with size (n+1) x (sum+1)
        if(n<0 || sum<0) return 0;
        int[][] dp = new int[n + 1][sum + 1];
        
        // Base case: There is one way to make sum 0 (by choosing an empty subset)
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // Carry forward the count from the previous row
                dp[i][j] = dp[i - 1][j];
                
                // Check if the current element can contribute to the subset sum
                if (arr[i - 1] <= j) {
                    // Update dp[i][j] by adding subsets that include arr[i-1]
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i - 1]]) % MOD;
                }
            }
        }
        
        // Return the number of subsets of 'arr' that sum up to 'sum'
        return dp[n][sum];
    }
    
    // Method to find the number of ways to achieve target 'd' using +/- operations on 'arr'
    public int findTargetSumWays(int[] arr, int d) {
        int sum = 0;
        int n = arr.length;
        
        // Calculate the total sum of 'arr'
        for (int i = 0; i < n; i++)
            sum += arr[i];
        
        // If (d + sum) is odd, it's impossible to partition 'arr' into subsets with sum (d + sum) / 2
        if ((d + sum) % 2 != 0)
            return 0;
        
        // Calculate the target sum for subset S1
        int s1 = (d + sum) / 2; 
        
        // Return the count of subsets of 'arr' that sum up to 's1'
        return countSubsets(arr, n, s1);
    }
}
