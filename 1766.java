class Solution {
    Map<Integer, Integer> levels = new HashMap();
    Map<Integer, List<Integer>> graph = new HashMap();
    Map<Integer, Stack<Integer>> stacks = new HashMap();
    int[][] isCoP = new int[51][51];
    public int[] getCoprimes(int[] nums, int[][] edges) {
        int[] res = new int[nums.length];
        for(int i = 0; i <nums.length; i++){
            graph.put(i, new ArrayList());
            
        }
        for(int i = 0; i <= 50; i++){
            stacks.put(i, new Stack());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        levels.put(0, 0);
        int level = 1;
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        while(queue.size() > 0){
            int s = queue.size();
            for(int i = 0; i < s; i++){
                int curr = queue.poll();
                List<Integer> list = graph.get(curr);
                for(int li : list){
                    if (levels.containsKey(li)) continue;
                    levels.put(li, level);
                    queue.add(li);
                }
            }
            level++;
        }
        dfs(nums, 0, - 1, res);
        return res;
    }
    
    private void dfs(int[] nums, int curr, int from, int[] res){
        int ans = -1;
        int level = -1;
        for(int key : stacks.keySet()){
            if (stacks.get(key).size() == 0) continue;
            if (isCoP[nums[curr]][key] == 0){
                isCoP[nums[curr]][key] = isCoP(nums[curr], key);
                isCoP[key][nums[curr]] = isCoP[nums[curr]][key];
            }
            if (isCoP[nums[curr]][key] == -1){
                int node = stacks.get(key).peek();
                //System.out.println(node);
                if (levels.get(node) > level){
                    level = levels.get(node);
                    ans = node;
                }
            }
        }
        res[curr] = ans;
        stacks.get(nums[curr]).push(curr);
        if (graph.get(curr) != null){
            List<Integer> next = graph.get(curr);
            for(int n : next){
                if (n == from) continue;
                dfs(nums, n, curr, res);
            }
        }
        stacks.get(nums[curr]).pop();
    }
    
    private int isCoP(int a, int b){
        if (a == 1 || b == 1) return -1;
        if (a == b) return 1;
        if (b > a) return isCoP(b, a);
        if (a % b == 0) return 1;
        return isCoP(b, a % b);
    }
}