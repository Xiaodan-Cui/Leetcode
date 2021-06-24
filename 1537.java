class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long[] sum1 = new long[nums1.length + 1];
        long[] sum2 = new long[nums2.length + 1];
        int i = 1; 
        int j = 1;
        int mod = (int) 1e9 + 7;
        while(i < sum1.length || j < sum2.length){
            if (i == sum1.length){
                sum2[j] = sum2[j - 1] + nums2[j - 1];
                j++;
            }
            else if (j == sum2.length){
                sum1[i] = sum1[i - 1] + nums1[i - 1];
                i++;
            }
            else if (nums1[i - 1] < nums2[j - 1]){
                sum1[i] = sum1[i - 1] + nums1[i - 1];
                i++;
            }
            else if (nums1[i - 1] > nums2[j - 1]){
                sum2[j] = sum2[j - 1] + nums2[j - 1];
                j++;
            }
            else{
                long max = Math.max(sum1[i - 1], sum2[j - 1]);
                sum1[i] = max + nums1[i - 1];
                sum2[j] = sum1[i];
                i++;
                j++;
            }
        }
        return (int) (Math.max(sum1[sum1.length - 1], sum2[sum2.length - 1]) % mod);
    }
}