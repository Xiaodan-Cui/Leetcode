class NumArray {
    class TreeNode{
        int sum;
        int start;
        int end;
        TreeNode left;
        TreeNode right;
        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    TreeNode root;
    int[] curr;
    public NumArray(int[] nums) {
        root = buildTree(nums,0, nums.length -1);
        curr = nums.clone();
    }
    
    private TreeNode buildTree(int[] nums, int start, int end){
        TreeNode root = new TreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
            return root;
        }
        int l = end - start;
        int leftEnd = start + l/2;
        root.left = buildTree(nums,start,leftEnd);
        root.right = buildTree(nums, leftEnd + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    public void update(int index, int val) {
        TreeNode temp = root;
        int diff = val - curr[index];
        curr[index] = val;
        temp.sum += diff;
        while(temp.left!=null ) {
            if (temp.left.end >= index) {
                temp = temp.left;
            } 
            else{
                temp = temp.right;
            }
            temp.sum += diff;
        }
    }
    
    public int sumRange(int left, int right) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.start > right || curr.end < left) continue;
            if(curr.start >= left && curr.end <= right) {
                res +=  curr.sum;
            }
            else{
                if(curr.left !=null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            } 
        }
        return res;
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */