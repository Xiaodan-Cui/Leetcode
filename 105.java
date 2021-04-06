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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, inorder.length, map, 0);
    }
    private TreeNode helper(int[] preorder, int [] inorder, int start, int end, Map<Integer, Integer> map, int rootPosition){
        if (rootPosition >= preorder.length) return null;
        TreeNode root=new TreeNode(preorder[rootPosition]);
        int rootPosition2 = map.get(preorder[rootPosition]);
        int leftEnd = rootPosition2 - 1;
        int rightStart = rootPosition2 + 1;
        int leftRoot = rootPosition + 1;
        int rightRoot = rootPosition + 1;
        if(start > leftEnd) {
            root.left = null;
        }
        else {
            root.left = helper(preorder, inorder, start, leftEnd, map, leftRoot);
            rightRoot = rootPosition + leftEnd - start + 2;
        }
        if(end < rightStart) {
            root.right = null;
        }
        else {
            root.right = helper(preorder, inorder, rightStart, end, map, rightRoot);
        }
        return root;
    }
        
}