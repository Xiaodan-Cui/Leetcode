class NumMatrix {
    class TreeNode{
        TreeNode leftUp;
        TreeNode rightUp;
        TreeNode leftDown;
        TreeNode rightDown;
        int val;
        int up;
        int down;
        int left;
        int right;
        TreeNode(int up, int left, int down, int right){
            this.up = up;
            this.left = left;
            this.down = down;
            this.right = right;
        }
    }
    TreeNode root;
    int[][] curr;
    public NumMatrix(int[][] matrix) {
        curr = matrix.clone();
        root = buildTree(matrix, 0, 0, matrix.length-1, matrix[0].length-1);
    }
    
    private TreeNode buildTree(int[][] matrix, int up, int left, int down, int right){
        if (up > down || left > right) return null;
        TreeNode root = new TreeNode(up, left, down, right);
        if(up == down && left == right) {
            root.val = matrix[up][left];
            return root;
        }
        int leftEnd = left+ (right - left) / 2;
        int upEnd = up + (down - up) / 2;
        root.leftUp = buildTree(matrix, up, left, upEnd, leftEnd);
        root.leftDown = buildTree(matrix, upEnd + 1, left, down, leftEnd);
        root.rightUp = buildTree(matrix, up, leftEnd + 1, upEnd, right);
        root.rightDown = buildTree(matrix, upEnd + 1, leftEnd + 1, down, right);
        if (root.leftUp != null) root.val += root.leftUp.val;
        if (root.leftDown != null) root.val += root.leftDown.val;
        if (root.rightUp != null) root.val += root.rightUp.val;
        if (root.rightDown != null) root.val += root.rightDown.val;
        return root;
    }
    
    public void update(int row, int col, int val) {
        TreeNode temp = root;
        int diff = val - curr[row][col];
        curr[row][col] = val;
        temp.val += diff;
        while(temp.up != temp.down || temp.left != temp.right){
            if (temp.leftUp != null && row <= temp.leftUp.down 
                && col <= temp.leftUp.right ){
                temp = temp.leftUp;
            }
            else if (temp.rightUp != null && row <= temp.rightUp.down 
                && col >= temp.rightUp.left){
                temp = temp.rightUp;
            }
            else if(temp.leftDown != null && row >= temp.leftDown.up 
                && col <= temp.leftDown.right){
                temp = temp.leftDown;
            }
            else{
                temp = temp.rightDown;
            }
            temp.val += diff;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        Queue<TreeNode> queue = new LinkedList();
        int res = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp.down < row1 || temp.right < col1 || temp.up > row2 
               || temp.left > col2) continue;
            if (temp.left >= col1 && temp.right <=col2 && temp.up >= row1 
                && temp.down <= row2 ){
                res += temp.val;
            }
            else{
                if (temp.leftUp != null) queue.add(temp.leftUp);
                if (temp.leftDown != null) queue.add(temp.leftDown);
                if (temp.rightUp != null) queue.add(temp.rightUp);
                if (temp.rightDown != null) queue.add(temp.rightDown);
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */