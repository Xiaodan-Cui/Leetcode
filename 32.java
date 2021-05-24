class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int[] dp = new int[s.length() + 1];
        for(int i = 1; i < s.length(); i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i + 1] = dp[i - 1] + 2;
                    res = Math.max(dp[i + 1], res);
                }
                else{
                    if (i - 1 - dp[i] >= 0 && s.charAt(i - 1- dp[i]) == '('){
                        dp[i + 1] = dp[i] + 2 + dp[i - 1 - dp[i]];
                        res = Math.max(dp[i + 1], res);
                    }
                }
            }
        }
        return res;
    }
}