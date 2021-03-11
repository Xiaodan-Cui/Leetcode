class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length==0 ||secondList.length==0) return new int[0][0];
       List<int[]> list=new ArrayList();
        int i=0;
        int j=0;
       
        while(i<firstList.length && j<secondList.length){
            int lo=Math.max(firstList[i][0],secondList[j][0]);
            int hi=Math.min(secondList[j][1],firstList[i][1]);
            if(lo<=hi) list.add(new int[]{lo,hi});
            if(firstList[i][1]<=secondList[j][1]) i++;
            else j++;
        }
    
        return list.toArray(new int[list.size()][]);
    }
}