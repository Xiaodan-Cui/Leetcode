class Solution {
    int res = Integer.MAX_VALUE;
    public int minimumIncompatibility(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int v : map.values()){
            if (v > k) return -1;
        }
        List<TreeSet<Integer>> list = new ArrayList();
        for(int i = 0; i < k; i++){
            list.add(new TreeSet<Integer>());
        }
        dfs(nums, 0, nums.length/k, list, 0);
        return res;
    }
    
    private void dfs(int[] nums, int start,int ave,  List<TreeSet<Integer>> list, int sum){
        if (start == nums.length){
            res = sum;
            return;
        }
        Set<TreeSet<Integer>> visited = new HashSet();
        for(TreeSet<Integer> set : list){
            if (visited.contains(set) || set.contains(nums[start]) || set.size() == ave) continue;
            int diff = 0;
            if (set.size() != 0){
                if (nums[start] < set.first()){
                    diff = set.first() - nums[start];
                }
                else if (nums[start] > set.last()){
                    diff = nums[start] - set.last();
                }
            }
            if (sum + diff >= res) continue;
            set.add(nums[start]);
            dfs(nums, start + 1, ave, list, sum + diff);
            set.remove(nums[start]);
            visited.add(set);
        }  
    }
}