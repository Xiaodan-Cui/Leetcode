class Solution {
    public void solveSudoku(char[][] board) {
        Set<String> set = new HashSet();
        List<int[]> list = new ArrayList();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j ++) {
                if(Character.isDigit(board[i][j])){
                    set.add(i+"col"+board[i][j]);
                    set.add(j+"row"+board[i][j]);
                    set.add((i/3*3+j/3)+"box"+board[i][j]);
                }
                else{
                    list.add(new int[]{i,j});
                }
            }
        }
        dfs(board, list, 0 , set);
    }
    private boolean dfs(char[][] board, List<int[]> list, int i, Set<String> set) {
        if (i == list.size()) return true;;
        int[] loc = list.get(i);
        for(int j = 1; j <= 9; j++){
            char temp = (char)(j+'0');
            //System.out.println(temp);
            String s1=loc[0]+"col"+temp;
            String s2=loc[1]+"row"+temp;
            String s3=(loc[0]/3*3+loc[1]/3)+"box"+temp;
            if(set.contains(s1) || set.contains(s2) || set.contains(s3)) {
                continue;
            }
            board[loc[0]][loc[1]] = temp;
            set.add(s1);
            set.add(s2);
            set.add(s3);
            if(dfs(board, list, i+1, set)) return true;;
            set.remove(s1);
            set.remove(s2);
            set.remove(s3);
        }
        return false;
    }
}