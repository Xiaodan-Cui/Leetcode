class Solution {
    public int minJumps(int[] arr) {
        if (arr.length == 1) return 0;
        Map<Integer, Set<Integer>> map = new HashMap();
        for(int i = 0; i< arr.length; i++) {
            if (i > 0 && i < arr.length -1 && arr[i - 1] == arr[i] && arr[i + 1] == arr[i]) continue;
            Set<Integer> set = map.getOrDefault(arr[i], new HashSet());
            set.add(i);
            map.put(arr[i], set);
        }
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        queue.add(0);
        visited.add(0);
        int res = 1;
        while(true) {
            int s = queue.size();
            for(int i = 0; i < s; i++) {
                int curr = queue.poll();
                if (curr + 1 == arr.length - 1) return res;
                if (!visited.contains(curr + 1)) {
                    queue.add(curr + 1);
                    visited.add(curr + 1);
                }
                if (curr - 1>= 0 && !visited.contains(curr - 1)) {
                    queue.add(curr - 1);
                    visited.add(curr - 1);
                }
                Set<Integer> set = map.get(arr[curr]);
                for(int ss : set) {
                    if (ss == arr.length - 1) return res;
                    if (!visited.contains(ss)) {
                        queue.add(ss);
                        visited.add(ss);
                    }
                }
            }
            res++;
        }
    }
}