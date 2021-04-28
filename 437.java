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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return dfs(root,targetSum) + pathSum(root.right,targetSum) 
            + pathSum(root.left,targetSum);
    }
    
    private int dfs(TreeNode root, int target) {
        if(root == null) return 0; 
        if (target == root.val) {
            return 1 + dfs(root.right, target - root.val) + dfs(root.left, target - root.val);
        }
        return dfs(root.right, target - root.val) + dfs(root.left, target - root.val);
        
    }
}