class Solution {
    static boolean canPartition(int[] nums,int n,int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int j=1;j<=sum;j++){
            dp[0][j] = false;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        
        if(sum%2!=0) return false;
        int target = sum/2;
        return canPartition(nums,n,target);
        
    }
}