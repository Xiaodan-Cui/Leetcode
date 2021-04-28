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
    List<TreeNode> parents = new ArrayList();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new ArrayList();
        isParent(root, target);
        for (int i = 0; i < parents.size() && i <= K; i++) {
            Queue<TreeNode> queue = new LinkedList();
            queue.add(parents.get(i));
            int level = K - i;
            while (level != 0) {
                int s = queue.size();
                for (int j = 0; j< s; j++) {
                    TreeNode curr = queue.poll();
                    if (curr.left != null && (i == 0 || parents.get(i - 1) != curr.left)) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null && (i == 0 || parents.get(i - 1) != curr.right)) {
                        queue.add(curr.right);
                    } 
                }
                level--;
            }
            while (!queue.isEmpty()) {
                list.add(queue.poll().val);
            }
        }
        return list;
    }
    
    private boolean isParent(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root == target) {
            parents.add(root);
            return true;
        }
        if (isParent(root.left, target) || isParent(root.right,target)) {
            parents.add(root);
            return true;
        }
        return false;
    }
}