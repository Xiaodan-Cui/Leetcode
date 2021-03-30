class Solution {
    public int splitArray(int[] nums, int m) { 
        int max=0;
        int sum=0;
        for(int n:nums){
            sum+=n;
            max=Math.max(n,max);
        }
        return binarySearch(nums,max,sum,m);
        
    }
    private int binarySearch(int[] nums,int start,int end,int m){
        if(start>=end) return start;
        int mid=start+(end-start)/2;
        int j=0;
        int sum=0;
        int count=0;
        while(j<nums.length){
            while(j<nums.length && sum<=mid){
                sum+=nums[j];
                j++;
            }
            count++;
            if(j==nums.length){
                if(sum>mid){
                    count++;
                }
                break;
            } 
            else{
                sum=0;
                j--;
            }
        }
        if(count<=m) return binarySearch(nums,start,mid,m);
        else return binarySearch(nums,mid+1,end,m);
    }
}