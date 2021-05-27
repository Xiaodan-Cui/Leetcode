class Solution {
    public int minOperations(int[] nums, int x) {
        if (x == 0) return 0;
        Map<Integer, Integer> leftMap = new HashMap();
        Map<Integer, Integer> rightMap = new HashMap();
        leftMap.put(0,0);
        rightMap.put(0,0);
        int pre = 0;
        for(int i = 0; i < nums.length; i++ ){
            int curr = pre + nums[i];
            if (curr > x){ break;}
            leftMap.put(curr, i + 1);
            pre = curr;
        }
        pre = 0;
        for(int i = nums.length - 1; i >= 0; i-- ){
            int curr = pre + nums[i];
            if (curr > x){break;}
            rightMap.put(curr, nums.length - i);
            pre = curr;
        }
        int res = Integer.MAX_VALUE;
        for(int key : leftMap.keySet()){
            int left = leftMap.get(key);
            //System.out.println(key);
            if (rightMap.containsKey(x - key)){
                int right = rightMap.get(x - key);
                if (right + left <= nums.length){
                    res = Math.min(right + left, res);
                }
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}