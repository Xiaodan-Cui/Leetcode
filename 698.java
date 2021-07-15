class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        Arrays.sort(nums);
        for(int n : nums){
            sum += n;
            max = Math.max(max, n);
        }
        if (sum % k != 0) return false;
        if (max > sum / k) return false;
        return dfs(nums, 0, sum / k, k, new boolean[nums.length], 0);
    }
    
    private boolean dfs(int[] nums, int start, int ave, int k, boolean[] state, int temp){
        if (k == 0){
            return true;
        }
        for(int i = start; i < nums.length; i++){
            if (!state[i]){
                if (temp + nums[i] == ave){
                    state[i] = true;
                    if (dfs(nums, 0, ave, k - 1, state, 0)){
                        return true;
                    }
                    state[i] = false;
                }
                if (temp + nums[i] < ave){
                    state[i] = true;
                    if (dfs(nums, i + 1, ave, k, state, temp + nums[i])){
                        return true;
                    }
                    state[i] = false;
                }
            }
            
        }
        return false;
    }

}