class Solution {
  
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int s:nums){
            sum+=s;
        }
        if(sum%2!=0) return false;
        sum/=2;
        boolean[][] dp=new boolean[nums.length+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        
        for(int i=1;i<=nums.length;i++){
            if(dp[i-1][sum]) return true;
            for(int j=1;j<=sum;j++){
                if(j>=nums[i-1]){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
           
        return dp[nums.length][sum];
    }
    
}