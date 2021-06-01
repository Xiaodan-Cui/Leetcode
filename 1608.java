class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        return binarySearch(nums, 0, nums.length - 1);
    }
    private int binarySearch(int[] nums, int start, int end){
        if(start > end){return -1;}
        int mid = start + (end - start) / 2;
        int right = nums.length - mid;
        if (nums[mid] >= right){
            if (mid == 0 || nums[mid - 1] < right) return right;
            return binarySearch(nums, start, mid - 1);
        }
        else{
            return binarySearch(nums, mid + 1, end);
        }
    }
    
}