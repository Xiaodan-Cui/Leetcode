class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans =new ArrayList();
        int lo=toBeRemoved[0];
        int hi=toBeRemoved[1];
        for(int[] itv:intervals){
            
            if(itv[1]<=lo ||itv[0]>=hi) {
                List<Integer> temp=new ArrayList();
                temp.add(itv[0]);
                temp.add(itv[1]);
                ans.add(temp);
            }
            else{
                if(itv[0]<lo) {
                    List<Integer> temp=new ArrayList();
                    temp.add(itv[0]);
                    temp.add(lo);
                    ans.add(temp);
                }
                if(itv[1]>hi){
                    List<Integer> temp=new ArrayList();
                    temp.add(hi);
                    temp.add(itv[1]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}