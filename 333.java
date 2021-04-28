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
    class Props{
        Integer min = null;
        Integer max = null;
        int size = 0;
    }
    
    Map<TreeNode, Props> map = new HashMap();
    public int largestBSTSubtree(TreeNode root) {
        if (isBST(root)) return map.get(root).size;
        return Math.max(largestBSTSubtree(root.left), 
                        largestBSTSubtree(root.right));
    }
    
    private boolean isBST(TreeNode root) {
        Props rootProps = map.getOrDefault(root, new Props());
        map.put(root, rootProps);
        if (root == null) {
            return true;
        }
        if (!isBST(root.left) || !isBST(root.right)) {
            return false;
        }
        Props leftProps = map.get(root.left);
        Props rightProps = map.get(root.right);
        if (leftProps.max != null && leftProps.max >= root.val || rightProps.min != null && rightProps.min <= root.val) {
            return false;
        }
        rootProps.min = leftProps.min == null ? root.val: leftProps.min;
        rootProps.max = rightProps.max == null ? root.val : rightProps.max;
        rootProps.size = 1 + leftProps.size + rightProps.size;
        return true;
    }
}