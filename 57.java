class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans=new ArrayList();
        int lo=newInterval[0];
        int hi=newInterval[1];
        boolean flag=true;
        for(int[] itv: intervals){
            if(itv[1]<lo){
                ans.add(itv);
            }
            else if(itv[0]>hi){
                if(flag){
                    ans.add(new int[]{lo,hi});
                    flag=false;
                }
                ans.add(itv);
            }
            else {
                lo=Math.min(lo,itv[0]);
                hi=Math.max(hi,itv[1]);
            }
        }
        if(flag) ans.add(new int[]{lo,hi});
        return ans.toArray(new int[ans.size()][]);
    }
}