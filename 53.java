class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int n : nums){
            if (sum >= 0){
                sum += n;
            }
            else{
                sum = n;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}