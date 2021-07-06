class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[n - 1 - i] = suffix[n - i] * nums[n - i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}