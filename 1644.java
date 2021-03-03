/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(!has(root,q) || !has(root,p)){
            return null;
        }
        
        return helper(root,p,q);

    }
    private TreeNode helper(TreeNode root, TreeNode p,TreeNode q){
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left=helper(root.left,p,q);
        TreeNode right=helper(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
    private boolean has(TreeNode root,TreeNode p){
        if(root==null){
            return false;
        }
        if(root==p){
            return true;
        }
        return has(root.left,p) || has(root.right,p);
    }   
}
