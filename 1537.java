class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long dp1 =0;
        long dp2 =0;
        int i=0;
        int j=0;
        long mol=(long)1e9+7;
        while(true){
            if(i==nums1.length && j==nums2.length) 
                return(int)(Math.max(dp1, dp2)%mol);
            else if(i==nums1.length){
                dp2+=(long)nums2[j];
                j++;
            }
            else if(j==nums2.length){
                dp1+=(long)nums1[i];
                i++;
            }
            else if(nums1[i]<nums2[j]){
                dp1+=(long)nums1[i];
                i++;
            }
            else if(nums1[i]>nums2[j]){
                dp2+=(long)nums2[j];
                j++;
            }
            else{
                dp1=Math.max(dp1,dp2)+(long)nums1[i];
                dp2=dp1;
                i++;
                j++;
            }
        }
    }
}