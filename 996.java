class Solution {
    Map<Integer, List<Integer>> map = new HashMap();
    Map<Integer, Integer> rep = new HashMap();
    int count = 0;
    public int numSquarefulPerms(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            rep.put(nums[i], rep.getOrDefault(nums[i], 0) + 1);
        }
        for(int key1 : rep.keySet()){
            for(int key2: rep.keySet()){
                if (isValid(key1 + key2)){
                    if (key1 == key2 && rep.get(key1) == 1) continue;
                    List<Integer> l1 = map.getOrDefault(key1, new ArrayList());
                    l1.add(key2);
                    map.put(key1, l1);
                }
            }
        }
        int singleKey = 0;
        for(int key : rep.keySet()){
            if (!map.containsKey(key)) return 0;
            if (map.get(key).size() == 1){
                singleKey++;
                if (singleKey > 2) return 0;
            }
        }
        for(int key : rep.keySet()){
            rep.put(key, rep.get(key) - 1);
            dfs(nums, key, 1);
            rep.put(key, rep.get(key) + 1);
        }
        return count;
    }
    
    private void dfs(int[] nums, int start, int len){
        if (len == nums.length){
            count++;
        }
        List<Integer> temp = map.get(start);
        for(int next : temp){
            if (rep.get(next) > 0){
                rep.put(next, rep.get(next) - 1);
                dfs(nums, next, len + 1);
                rep.put(next, rep.get(next) + 1);
            }
        }
    }
    
    private boolean isValid(int k){
        int sqrt = (int)Math.sqrt(k);
        return sqrt * sqrt == k;
    }
    
}