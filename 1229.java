class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b)-> a[0]-b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j = 0;
        int[] pre = new int[]{-1, -1};
        List<Integer> res = new ArrayList();
        while(i < slots1.length || j < slots2.length){
            if (i == slots1.length){
                if (pre[1] - slots2[j][0] < duration) return res;
                if (slots2[j][1] - slots2[j][0] < duration) j++;
                else {
                    res.add(slots2[j][0]);
                    res.add(slots2[j][0] + duration);
                    return res;
                }
            }
            else if (j == slots2.length){
                if (pre[1] - slots1[i][0] < duration) return res;
                if (slots1[i][1] - slots1[i][0] < duration) i++;
                else {
                    res.add(slots1[i][0]);
                    res.add(slots1[i][0] + duration);
                    return res;
                }                
            }
            else if (slots1[i][0] <= slots2[j][0]){
                if (slots1[i][1] - slots1[i][0]  < duration) {
                    i++;
                    continue;
                }
                if (pre[1] - slots1[i][0] >= duration){
                    res.add(slots1[i][0]);
                    res.add(slots1[i][0] + duration);
                    return res;
                }
                pre[0] = Math.min(slots1[i][1], pre[1]);
                pre[1] = Math.max(slots1[i][1], pre[1]);
                i++;
            }
            else{
                if (slots2[j][1] - slots2[j][0]  < duration) {
                    j++;
                    continue;
                }
                if (pre[1] - slots2[j][0] >= duration){
                    res.add(slots2[j][0]);
                    res.add(slots2[j][0] + duration);
                    return res;
                }
                pre[0] = Math.min(slots2[j][1], pre[1]);
                pre[1] = Math.max(slots2[j][1], pre[1]);
                j++;
            }
            
        }
        return res;
    }
}