class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int res = tasks[0][1];
        int sum = tasks[0][0];
        for(int i = 1; i < tasks.length; i++){
            res = Math.max(res, sum + tasks[i][1]);
            sum += tasks[i][0];
        }
        return res;
    }
}