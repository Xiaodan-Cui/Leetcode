class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] allTasks = new int[n][3];
        for(int i = 0; i < tasks.length; i++){
            allTasks[i][0] = tasks[i][0];
            allTasks[i][1] = tasks[i][1];
            allTasks[i][2] = i;
        }
        Arrays.sort(allTasks, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if (a[1] != b[1]){
                    return a[1] - b[1];
                }
                return a[2] - b[2];
            }
        });
        int time = allTasks[0][0];
        int i = 0;
        int[] res = new int[n];
        int order = 0;
        while(order < n){
            while(i < n && allTasks[i][0] <= time){
                pq.add(allTasks[i++]);
            }
            int[] curr = pq.poll();
            res[order++] = curr[2];
            time += curr[1];
            if (pq.size() == 0 && i < n && time < allTasks[i][0]){
                time = allTasks[i][0];
            }
        }
        return res;
    }
}