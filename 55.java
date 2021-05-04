class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int reach = nums[i] + i;
            int next = i;
            if (reach >= nums.length - 1) return true;
            for(int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + (j + i) >reach ) {
                    next = j + i;
                    reach = nums[j + i] + (j + i);
                }
            }
            if (next == i) return false;
            i = next;
        }
        return true;
    }
}