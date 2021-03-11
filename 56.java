class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        Stack<Integer> stack=new Stack();
        stack.push(intervals[0][0]);
        stack.push(intervals[0][1]);
        for(int[] interval: intervals){
            if(interval[0]>stack.peek()) {
                stack.push(interval[0]);
                stack.push(interval[1]);
            }
            else if(interval[1]>stack.peek()){
                stack.pop();
                stack.push(interval[1]);
            }
        }
        int[][] res=new int[stack.size()/2][2];
        for(int i=res.length-1;i>=0;i--){
            res[i][1]=stack.pop();
            res[i][0]=stack.pop();
        }
        return res;
    }
}