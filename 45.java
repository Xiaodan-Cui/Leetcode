class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int i = 0;
        int nextPoint = nums[0] ;
        while( i < nums.length - 1) {
            count++;
            if (nextPoint >= nums.length - 1) return count;
            int nextIndex = i;
            for(int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + (j + i) > nextPoint) {
                    nextIndex = j + i;
                    nextPoint = nums[j + i] + (j + i);
                }
            }
            if (nextIndex == i) return -1;
            i = nextIndex;
        }
        return count;
    }
}