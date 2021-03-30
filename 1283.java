class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int n:nums){
            max=Math.max(max,n);
        }
        return binarySearch(nums,1,max,threshold);
    }
    private int binarySearch(int[] nums, int start,int end,int threshold){
        if(start>=end) return start;
        int mid=start+(end-start)/2;
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=(nums[i]+mid-1)/mid;
        }
        if(total<=threshold) return binarySearch(nums,start,mid,threshold);
        return binarySearch(nums,mid+1,end,threshold);
    }
}