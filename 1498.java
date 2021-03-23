class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int j=nums.length-1;
        int i=0;
        int res=0;
        int[] pows = new int[j+1];
        pows[0] = 1;
        for (int k = 1 ; k < j+1 ;k++)
            pows[k] = pows[k - 1] * 2 % 1000000007;
        while(i<=j){
            if(nums[j]+nums[i]>target){
                j--;
            }
            else{
                res=(res+pows[j-i])%1000000007;
                i++;
            }
            
        }
        return res;
    }
}