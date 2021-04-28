/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int rootL = oneSide(root.left, root.val) + oneSide(root.right, root.val);
        return Math.max(Math.max(rootL, longestUnivaluePath(root.left)), longestUnivaluePath(root.right));
    }
    public int oneSide(TreeNode root, int val) {
        if (root == null || root.val != val) return 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean canExtend = true;
        while (canExtend) {
            canExtend = false;
            int s = queue.size();
            for (int i = 0 ; i < s; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && curr.left.val ==val) {
                    canExtend = true;
                    queue.add(curr.left);
                }
                if (curr.right != null && curr.right.val ==val) {
                    canExtend = true;
                    queue.add(curr.right);
                }
            }
            level++;
        }
        return level;
    }
}