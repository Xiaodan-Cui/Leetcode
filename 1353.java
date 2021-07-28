class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[1] -b[1]);
        int loc = events[0][0];
        int i = 0;
        int count = 0;
        while(i < events.length || pq.size() >0) {
            while(!pq.isEmpty() && pq.peek()[1] < loc){
                pq.poll();
            }
            while(i < events.length) {
                if (events[i][0] > loc) break;
                pq.add(events[i++]);
            }
            if (!pq.isEmpty()){
                pq.poll();
                count++;
            }
            loc++;
            if (pq.isEmpty() && i < events.length) {
                loc = Math.max(loc, events[i][0]);
            }
        }
        return count;
    }
}