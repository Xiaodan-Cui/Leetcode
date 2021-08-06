class Solution {
    Map<Integer, List<Integer>> map = new HashMap();
    Random rand = new Random();
    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            List<Integer> temp = map.getOrDefault(nums[i], new ArrayList());
            temp.add(i);
            map.put(nums[i], temp);
        }
    }
    
    public int pick(int target) {
        List<Integer> temp = map.get(target);
        int index = rand.nextInt(temp.size());
        return temp.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */