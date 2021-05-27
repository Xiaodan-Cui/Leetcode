class Solution {
    public int minSubarray(int[] nums, int p) {
        int[] sum = new int[nums.length + 1];
        for(int i = 1; i < sum.length; i++){
            sum[i] = (sum[i - 1] + nums[i - 1] % p) % p;
        }
        int total = sum[nums.length];
        //System.out.println(total);
        if (total % p == 0) return 0;
        int res = 1;
        while(res < nums.length){
            for(int left = 0;left + res <= nums.length ;left++){
                int diff = sum[left + res] - sum[left];
                if ( (total - diff) % p == 0) return res;
            }
            res++;
        }
        return -1;
    }
}