class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        if(min == max) return 0;
        int l = nums.length;
        int interval = (int)Math.ceil((double)(max - min + 1) / l);
        int[] minEnd = new int[l];
        int[] maxEnd = new int[l];
        Arrays.fill(minEnd, 1000000001);
        for(int n : nums){
            int ln = (n - min)/interval;
            minEnd[ln] = Math.min(minEnd[ln], n);
            maxEnd[ln] = Math.max(maxEnd[ln], n);
            
        }
        int preMax = maxEnd[0];
        int res = maxEnd[0] - minEnd[0];
        for(int i = 1; i < l; i++){
            if (minEnd[i] != 1000000001){
                res = Math.max(minEnd[i] - preMax, res);
                preMax = maxEnd[i];
            }
        }
        return res;
        
    }
}