
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length<=1) return intervals.length;
        int[] start=new int[intervals.length] ;
        int[] end=new int[intervals.length];
        for(int i=0;i<start.length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count=0;
        int j=0;
        for(int i=0;i<start.length;i++){
            if(start[i]<end[j]){
                count=Math.max(i-j+1,count);
            }
            else{
                j++;
            }
            
        }
        return count;
    }
}