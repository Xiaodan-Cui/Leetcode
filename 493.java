class Solution {
    public int reversePairs(int[] nums) {
        return mergeAndCount(nums, 0, nums.length - 1);
    }
    private int mergeAndCount(int[] nums, int start, int end){
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = mergeAndCount(nums, start, mid);
        int right = mergeAndCount(nums, mid + 1, end);
        
        int[] leftArray = new int[mid - start + 1];
        int[] rightArray = new int[end - mid];
        for(int i = start; i <= mid; i++){
            leftArray[i - start] = nums[i];
        }
        for(int i = mid + 1; i <= end; i++) {
            rightArray[i - mid - 1] = nums[i];
        }
        int k = start;
        int count = left + right;
        int p = 0;
        int i = 0;
        int j = 0;
        while(k <= end) {
            if (i == leftArray.length 
                || (j != rightArray.length && leftArray[i] > rightArray[j])){
                nums[k++] = rightArray[j++];
            }
            else{
                while(p < rightArray.length && (long)rightArray[p] * 2 < (long)leftArray[i]){
                    p++;
                }
                count += p;
                nums[k++] = leftArray[i++];
            }
        }
        return count;
    }
}