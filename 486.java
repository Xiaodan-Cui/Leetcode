class Solution {
    public boolean PredictTheWinner(int[] nums) {
        //dp[i][j] save how much more the first-in-action player for range i-j wins over the               //second player for the corresoponding range
        int[][] dp=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i][i]=nums[i];
        }
        for(int l=1;l<nums.length;l++){
            for(int i=0;i+l<nums.length;i++){
                int j=i+l;
                dp[i][j]=Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1]>=0;
    }
}