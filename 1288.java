class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]!=b[0]) return a[0]-b[0];
                return b[1]-a[1];
            }
        });
        int count=intervals.length;
        int max=Integer.MIN_VALUE;
        for(int[] itv:intervals){
            if(itv[1]<=max){
                count--;
            }
            else max=itv[1];
        }
        return count;
    }
}