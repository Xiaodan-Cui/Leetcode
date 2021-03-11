class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        int count=0;
        int max=Integer.MIN_VALUE;
        for(int[] itv:intervals){
            if(itv[0]<max){
                count++;
                max=Math.min(max,itv[1]);
            }
            else max=itv[1];
        }
        return count;
    }
}