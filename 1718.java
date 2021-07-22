class Solution {
    public int[] constructDistancedSequence(int n) {
        boolean[] used = new boolean[n];
        int[] temp = new int[2 * n - 1];
        dfs(used, 0, temp);
        return temp;
    }
    private boolean dfs(boolean[] used, int start, int[] temp){
        if (start == temp.length){
            return true;
        }
        if (temp[start] != 0) return dfs(used, start + 1, temp);
        for(int i = used.length - 1; i >= 0; i--){
            if (used[i]) continue;
            if (i == 0){
                temp[start] = 1; 
                used[i] = true;
                if (dfs(used, start + 1, temp)){
                    return true;
                }
                temp[start] = 0;
                used[i] = false;
            }
            else if (start + i + 1 < temp.length && temp[start + i + 1] == 0 ){ 
                temp[start] = i + 1;
                temp[start + i + 1] = i + 1;
                used[i] = true;
                if (dfs(used, start + 1, temp)){
                    return true;
                }
                temp[start] = 0;
                temp[start + i + 1] = 0;
                used[i] = false;
            }
        }
        return false;
    }
}