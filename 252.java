class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length<=1) return true;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        int max=-1;
        for(int[] interval:intervals){
            if(interval[0]<max) return false;
            max=Math.max(max,interval[1]);
        }
        return true;
    }
}