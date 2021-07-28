class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        int[][] projects = new int[n][2];
        for(int i = 0; i < n; i++){
            projects[i][0] = Profits[i];
            projects[i][1] = Capital[i];
        }
        Arrays.sort(projects, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if (a[1] != b[1]){
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        int j = 0;
        for(int i = 0; i < k; i++){
            while(j < n && projects[j][1] <= W){
                pq.add(projects[j++][0]);
            }
            if (pq.size() == 0) return W;
            W += pq.poll();
        }
        return W;
    }
    
}