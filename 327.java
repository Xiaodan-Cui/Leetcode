class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return mergeAndCount(sum, 0, sum.length - 1, lower, upper);
    }
    private int mergeAndCount(long[] sum, int start, int end, int lower, int upper) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = mergeAndCount(sum, start, mid, lower, upper);
        int right = mergeAndCount(sum, mid + 1, end, lower, upper);
        long[] leftArray = new long[mid - start + 1];
        long [] rightArray = new long[end - mid];
        for (int i = start; i <= mid; i++) {
            leftArray[i - start] = sum[i];
        }
        for(int i  = mid + 1; i<= end; i++){
            rightArray[i - mid - 1] = sum[i];
        }
        int count = left + right;
        int i = 0;
        int j = 0;
        int k = start;
        int p1 = 0;
        int p2 = 0;
        while(k <= end) {
            if (i == leftArray.length 
                ||  (j != rightArray.length && leftArray[i] > rightArray[j])){
                sum[k++] = rightArray[j++];
            }
            else{
                while(p1 < rightArray.length && rightArray[p1] - leftArray[i] < lower){
                    p1++;
                }
                while(p2 < rightArray.length && rightArray[p2] - leftArray[i] <= upper){
                    p2++;
                }
                if (p2 > p1){
                    count += p2- p1;
                }
                sum[k++] = leftArray[i++];
            }
        }
        return count;
    }
    
}