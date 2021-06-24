class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList();
        int i = 0;
        int j = 0;
        while(i < encoded1.length){
            int[] temp = new int[2];
            temp[0] = encoded1[i][0] * encoded2[j][0];
            if (encoded1[i][1] == encoded2[j][1]){
                temp[1]= encoded1[i][1];
                i++;
                j++;
            }
            else if (encoded1[i][1] < encoded2[j][1]){
                temp[1] = encoded1[i][1];
                encoded2[j][1] -= encoded1[i][1];
                i++;
            }
            else {
                temp[1] = encoded2[j][1];
                encoded1[i][1] -= encoded2[j][1];
                j++;
            }
            if (res.size() > 0 && temp[0] == res.get(res.size() - 1).get(0)){
                List<Integer> last = res.get(res.size() - 1);
                int count = last.get(1) + temp[1];
                last.remove(1);
                last.add(count);
            }
            else{
                List<Integer> list = new ArrayList();
                list.add(temp[0]);
                list.add(temp[1]);
                res.add(list);
            }
        }
        return res;
       // return new ArrayList();
    }
}