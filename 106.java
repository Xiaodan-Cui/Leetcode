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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0, inorder.length-1, postorder.length-1, map);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end, int root, Map<Integer, Integer> map){
        if (root<0 || root >= postorder.length) return null;
        
        TreeNode res = new TreeNode(postorder[root]);
        int position = map.get(postorder[root]);
        int rightStart = position + 1;
        int leftEnd = position -1;
        int rightRoot = root - 1;
        int leftRoot = root -1;
        if (rightStart > end) {
            res.right = null;
        }
        else {
            res.right = helper(inorder, postorder, rightStart, end, rightRoot, map);
            leftRoot = root - (end - rightStart + 1) - 1;
        }
        if(leftEnd < start){
            res.left = null;
        }
        else {
            res.left = helper(inorder, postorder, start, leftEnd, leftRoot, map);
        }
        return res;
    }
}