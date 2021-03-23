class Solution {
    public int maximumScore(int[] nums, int k) {
        int res=nums[k];
        int min=nums[k];
        int i=k;
        int j=k;
        while(true){
            if(i==0 && j==nums.length-1) return res;
            if(i==0){
                min=Math.min(min,nums[j+1]);
                j++;
                res=Math.max(res,min*(j-i+1));
            }
            else if(j==nums.length-1){
                min=Math.min(min,nums[i-1]);
                i--;
                res=Math.max(res,min*(j-i+1));
            }
            else if(nums[i-1]>=nums[j+1]){
               min=Math.min(min,nums[i-1]);
                i--;
                res=Math.max(res,min*(j-i+1)); 
            }
            else{
                min=Math.min(min,nums[j+1]);
                j++;
                res=Math.max(res,min*(j-i+1));
            }
        }
        
    }
}