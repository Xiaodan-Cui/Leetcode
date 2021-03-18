class Solution {
    public boolean stoneGame(int[] piles) {
        if(piles.length<=1) return true;
        int[][] dp=new int[piles.length][piles.length];
        for(int i=0;i<piles.length;i++){
            dp[i][i]=piles[i];
        }
        for(int l=1;l<piles.length;l++){
            for(int i=0;i+l<piles.length;i++){
                int j=i+l;
                dp[i][j]=Math.max(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][piles.length-1]>=0;
    }
}