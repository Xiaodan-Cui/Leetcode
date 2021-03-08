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
    TreeNode first=null;
    TreeNode second=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
        
    }
    TreeNode pre=null;
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(pre!=null && root.val<pre.val){
            if(first==null){
                first=pre;
                second=root;
            }
            else{
                second=root;
            }
            
        }
        pre=root;
        inorder(root.right);
    }
}