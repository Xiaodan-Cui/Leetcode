class Solution {
    public int pathSum(int[] nums) {
        int res = 0;
        int i = nums.length - 1;
        int currlevel = nums[i] / 100;
        Map<Integer, Integer> preMap = new HashMap();
        Map<Integer, Integer> currMap = new HashMap();
        while (i >= 0) {
            int h = nums[i] / 100;
            int t = (nums[i] - h * 100) / 10;
            int u = nums[i] % 10;
            if (h != currlevel) {
                preMap = currMap;
                currMap = new HashMap();
                currlevel = h;
            }
            int n = preMap.getOrDefault(2 * t - 1, 0) + 
                preMap.getOrDefault(2 * t , 0);
            if (n == 0) {
                n = 1;
            }
            res += n * u;
            currMap.put(t, n);
            i--;
        }
        return res;
        
    }
}