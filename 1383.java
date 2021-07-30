class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        //currently hired one has the smallest efficiency;
        int[][] sne = new int[n][2];
        for(int i = 0; i < n; i++){
            sne[i][0] = speed[i];
            sne[i][1] = efficiency[i];
        }
        Arrays.sort(sne, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue();
        long res = 0;
        long sum = 0;
        for(int[] m : sne){
            pq.add(m[0]);
            sum += m[0];
            if (pq.size() > k){
                sum -= pq.poll();
            }
            res = Math.max(res, sum * m[1]);
        }
        return (int)(res % 1000000007);
    }
}