class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) return -1;
        int[] count1 = new int[6];
        int[] count2 = new int[6];
        int sum1 = 0;
        int sum2 = 0;
        for(int n : nums1){
            count1[n - 1]++;
            sum1 += n;
        }
        for(int n : nums2){
            count2[n - 1]++;
            sum2 += n;
        }
        if (sum1 == sum2) return 0;
        if (sum1 < sum2){
            return balance(count1, count2, sum2 - sum1);
        }
        return balance(count2, count1, sum1- sum2);
    }
    
    private int balance(int[] count1, int[] count2, int diff){
        int i = 0;
        int res = 0;
        while(true){
            if (count1[i] * (5 - i) >= diff){
                return res + (diff + 5 - i- 1 ) / (5 -i); 
            }
            res += count1[i];
            diff -= (5 - i) * count1[i];
            if (count2[5 - i] * (5 - i) >= diff){
                return res + (diff + 5 - i- 1) / (5 -i) ; 
            }
            res += count2[5 -i];
            diff -= (5 - i) * count2[5 - i];
            i++;
        }
    }
}