class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap();
        for(int n : nums){
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += n;
            if (map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
        }
        
        return count;
    }
}