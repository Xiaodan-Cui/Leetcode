class Solution {
    List<List<Integer>> list = new ArrayList();
    Set<String> set = new HashSet();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0, new ArrayList());
        return list;
    }
    
    private void dfs(int[] nums, int start, List<Integer> temp){
        if (start == nums.length){
            String curr = temp.toString();
            if (temp.size() >= 2 && !set.contains(curr)){
                list.add(new ArrayList(temp));
                set.add(curr);
            }
            return;
        }
        if (temp.size() == 0 || nums[start] >= temp.get(temp.size() - 1)){
                temp.add(nums[start]);
                dfs(nums, start + 1, temp);
                temp.remove(temp.size() - 1);
        }
        dfs(nums, start + 1, temp);
    }
}