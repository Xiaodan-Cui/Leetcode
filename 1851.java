class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        PriorityQueue<Integer> qs = new PriorityQueue();
        Map<Integer, Integer> map = new HashMap();
        for(int q : queries){
            qs.add(q);
        }
        int[] res = new int[queries.length];
        int i = 0;
        while(qs.size() > 0){
            int curr = qs.poll();
            if (map.containsKey(curr)) continue;
            while(i < intervals.length && intervals[i][0] <= curr){
                pq.add(intervals[i++]);
            }
            while(pq.size() > 0 && pq.peek()[1] < curr){
                pq.poll();
            }
            if (pq.size() != 0){
                map.put(curr, pq.peek()[1] - pq.peek()[0] + 1);
            }
            else{
                map.put(curr, -1);
            }
        }
        for(int j = 0; j < res.length; j++){
            res[j] = map.get(queries[j]);
        }
        return res;
    }
}