class Solution {
    int mod = 1000000007;
    public int numOfWays(int[] nums) {
        List<Integer> numbers = new ArrayList();
        for(int n : nums) {
            numbers.add(n);
        }
        return (int)((count(numbers)-1)%mod);   
    }
    private long count(List<Integer> nums) {
        if (nums.size() == 0 || nums.size() == 1) return 1;
        int root = nums.get(0);
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        
        for (int i = 1; i< nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            }
            else{
                right.add(nums.get(i));
            }
        }
        long countLeft = count(left)%mod ;
        long countRight = count (right)%mod;
        long mixWays = mix(left.size(), right.size())%mod;
        return ((((countLeft%mod)*(countRight%mod))%mod)*(mixWays%mod))%mod;
    }
    private long mix(int left, int right) {
        long[][] dp = new long[left + 2][right + 1];
        for (int i = 0; i< left + 2; i++){
            dp[i][0] = 1;
        }
        for(int i=1 ;i<left+2; i++){
            for(int j = 1; j< right + 1; j++){
                dp[i][j] = (dp[i-1][j]+ dp[i][j-1])%mod;
            }
        }
        return dp[left+1][right]%mod;
    }
}