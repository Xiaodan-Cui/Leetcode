class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][][] mat = new int[n][n][4];
        int count = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    if (mat[i][j][k] == 0){
                        expand(mat, grid, i, j, k, count);
                        count++;
                    }
                }
            }
        }
        return count - 1;
    }
    
    private void expand(int[][][] mat, String[] grid, int i, int j, int k, int count){
        if (i < 0 || j < 0 || i >= mat.length || j >= mat.length || mat[i][j][k] != 0 ) return;
        mat[i][j][k] = count;
        if (grid[i].charAt(j) == ' '){
            for(int m = 0; m < 4; m++){
                if (m == k) continue;
                expand(mat, grid, i, j, m, count);            
            }
        } 
        else if (grid[i].charAt(j) == '/'){
            if (k == 0){
                expand(mat, grid, i, j, 1, count);
            }
            else if (k == 1){
                expand(mat, grid, i, j, 0, count);
            }
            else if (k == 2){
                expand(mat, grid, i, j, 3, count);
            }
            else{
                expand(mat, grid, i, j, 2, count);
            }
        }
        else {
            if (k == 0){
                expand(mat, grid, i, j, 3, count);
            }
            else if (k == 3){
                expand(mat, grid, i, j, 0, count);
            }
            else if (k == 2){
                expand(mat, grid, i, j, 1, count);
            }
            else{
                expand(mat, grid, i, j, 2, count);
            }
        }
        if (k == 0){
            expand(mat, grid, i - 1, j, 2, count);
        }
        else if (k == 1){
            expand(mat, grid, i, j - 1, 3, count);
        }
        if (k == 2){
            expand(mat, grid, i + 1, j, 0, count);
        }
        if (k == 3){
            expand(mat, grid, i, j + 1, 1, count);
        }
        
    }
}