class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (b[0] - a[0]));
        int score = nums[0];
        pq.add(new int[]{nums[0], 0});
        for(int i = 1; i < nums.length; i++) {
            while(!pq.isEmpty() && pq.peek()[1] + k < i) {
                pq.poll();
            }
            score = pq.peek()[0] + nums[i];
            pq.add(new int[]{score, i});
        }
        return score;
    }
}