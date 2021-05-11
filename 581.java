class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = nums.length;
        int end = -1;
        int minChange = 10001;
        int maxChange = -100001;
        for(int i = 1; i< nums.length; i++){
            if (nums[i] < maxChange || nums[i -1] > nums[i]){
                start = Math.min(start, i -1);
                if (nums[i] < minChange){
                    while(start > 0 && nums[i] <nums[start -1]){
                        start--; 
                    }
                }
                end = i;
                minChange = Math.min(nums[i], minChange);
                maxChange = Math.max(nums[i -1], maxChange);
            }
        }
        if (start == nums.length) return 0;
        return end - start + 1;
    }
}