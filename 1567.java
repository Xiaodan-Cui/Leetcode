class Solution {
    public int getMaxLen(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int max = 0;
        int[] neg = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                if (i - start > max) {
                    max = Math.max(max, helper(nums, start, i - 1, neg));
                }
                start = i + 1;
            }
            if (nums[i] < 0) neg[i + 1] = neg[i] + 1;
            else neg[i + 1] = neg[i];
        }
        if (end - start + 1 > max){
            max = Math.max(max, helper(nums, start, end, neg));
        }
        return max;
    }
    public int helper(int[] nums, int start, int end, int[] neg){
        if ((neg[end + 1] - neg[start]) % 2 == 0 ) return end - start + 1;
        int left = start;
        while(nums[left] > 0) left++;
        int right = end;
        while(nums[right] > 0) right--;
        return Math.max(end - left, right - start);
    }
}