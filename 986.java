class Solution {
    
    List<int[]> list = new ArrayList();
    int[] pre = new int[]{-1, -1};
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        while(i < firstList.length || j < secondList.length){
            if (i == firstList.length && j == secondList.length) break;
            if (i == firstList.length){
                if (secondList[j][0] > pre[1]) break;
                insert(secondList[j++]);
            }
            else if (j == secondList.length){
                if (firstList[i][0] > pre[1]) break;
                insert(firstList[i++]);
            }
            else if (firstList[i][0] <= secondList[j][0]){
                insert(firstList[i++]);
            }
            else insert(secondList[j++]);
        }
        int[][] res = new int[list.size()][2];
        for(int k = 0; k < list.size(); k++){
            res[k] = list.get(k);
        }
        return res;
    }
    
    private void insert(int[] interval){
        if (interval[0] > pre[1]) pre = interval;
        else{
            int[] curr = new int[]{interval[0], Math.min(interval[1], pre[1])};
            pre[0] = Math.min(interval[1], pre[1]);
            pre[1] = Math.max(interval[1], pre[1]);
            list.add(curr);
        }
    }
}