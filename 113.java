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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        dfs(root, targetSum, 0 , new ArrayList(), list);
        return list;
    }
    
    private void dfs(TreeNode root, int targetSum, int sum, List<Integer> temp,
                     List<List<Integer>> list){
        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null) {
            if (sum == targetSum) {
                list.add(new ArrayList(temp));
            }
            temp.remove(temp.size() - 1);
            return;
        }
        if(root.left != null) {
            dfs(root.left, targetSum, sum, temp, list);
        }
        if(root.right != null) {
            dfs(root.right, targetSum, sum, temp, list);
   
        }
        sum -= root.val;
        temp.remove(temp.size() - 1);
    }
    
}