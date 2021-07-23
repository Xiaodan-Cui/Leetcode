/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
    int[][] mat = new int[1001][1001];
    public int findShortestPath(GridMaster master) {
        int[][] dir = {{-1, 0}, {1,0}, {0, 1}, {0, -1}};
        mat[500][500] = -1;
        findPath(master, 500, 500);
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{500, 500});
        int step = 1;
        while(queue.size() > 0){
            int s= queue.size();
            for(int j = 0; j < s; j++){
                int[] curr = queue.poll();
                for(int i = 0; i < 4; i++){
                    if (mat[curr[0] + dir[i][0]][curr[1] + dir[i][1]] == 2){
                        return step;
                    }
                    if (mat[curr[0] + dir[i][0]][curr[1] + dir[i][1]] == 1){
                        mat[curr[0] + dir[i][0]][curr[1] + dir[i][1]] = -1;
                        queue.add(new int[]{curr[0] + dir[i][0], curr[1] + dir[i][1]});
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    public void findPath(GridMaster master, int i, int j){
        if(master.isTarget()){
            mat[i][j] = 2;
            return;
        }
        if (master.canMove('U') && mat[i - 1][j] == 0){
            mat[i - 1][j] = 1;
            master.move('U');
            findPath(master, i - 1, j);
            master.move('D');
        }
        if (master.canMove('D') && mat[i + 1][j] == 0){
            mat[i + 1][j] = 1;
            master.move('D');
            findPath(master, i + 1, j);
            master.move('U');
        }
        if (master.canMove('L') && mat[i][j - 1] == 0){
            mat[i][j - 1] = 1;
            master.move('L');
            findPath(master, i, j - 1);
            master.move('R');
        }
        if (master.canMove('R') && mat[i][j + 1] == 0){
            mat[i][j + 1] = 1;
            master.move('R');
            findPath(master, i, j + 1);
            master.move('L');
        }
    }
}