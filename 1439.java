class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        pq.add(0);
        for(int[] m : mat){
            pq = addToPQ(m, k, pq);
        }
        return pq.poll();
    }
    
    private PriorityQueue addToPQ(int[] arr, int k, PriorityQueue<Integer> pq){
        PriorityQueue<Integer> nextPQ = new PriorityQueue<Integer>((a, b) -> b - a);
        while(pq.size() > 0){
            int curr = pq.poll();
            for(int a : arr){
                nextPQ.add(a + curr);
                if (nextPQ.size() > k) nextPQ.poll();
            }
        }
        return nextPQ;
    }
}
    