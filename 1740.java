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
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lowA=lowAnc(root,p,q);
        return findP(lowA,p)+findP(lowA,q);
    }
    private TreeNode lowAnc(TreeNode root, int p,int q){
        if(root==null || root.val==p || root.val==q) return root;
        TreeNode left=lowAnc(root.left,p,q);
        TreeNode right=lowAnc(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
    private int findP(TreeNode root,int p){
        if(root==null) return -1;
        if(root.val==p) return 0;
        int left=findP(root.left,p);
        int right=findP(root.right,p);
        if(left==-1 && right==-1) return -1;
        if(left==-1) return 1+right;
        return 1+left;
        
    }
}