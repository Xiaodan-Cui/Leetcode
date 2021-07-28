class Solution {
    public int scheduleCourse(int[][] courses) {
        int time = 0;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int[] course : courses){
            time += course[0];
            pq.add(course[0]);
            if (time > course[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}