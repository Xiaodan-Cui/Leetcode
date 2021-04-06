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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<voyage.length; i++){
            map.put(voyage[i], i);
        }
        List<Integer> res = new ArrayList();
        
        boolean help = helper(root, voyage, 0, voyage.length - 1, res, map);
        
        if(help) return res;
        
        return new ArrayList(Arrays.asList(-1));
    }
    private boolean helper(TreeNode root, int[] voyage, int start, int end, List<Integer> res, Map<Integer, Integer> map){
        if (start < 0 || end >= voyage.length || start > end || root.val != voyage[start]) 
            return false;
        if (root.left == null && root.right == null) return start == end;
        if (start == end) return false;
        if(root.left == null) {
            return helper(root.right, voyage, start+1, end, res, map);
        }
        if(root.right == null){
            return helper(root.left, voyage, start+1, end, res, map);
        }
        if(root.left.val == voyage[start + 1]) {
            int rightStart = map.get(root.right.val);
            if (rightStart <= start || rightStart > end) return false;
            int leftEnd = rightStart - 1;
            return helper(root.left, voyage, start + 1, leftEnd, res, map) 
                && helper(root.right, voyage, rightStart, end, res, map);
        }
        if(root.right.val == voyage[start + 1]) {
            int leftStart = map.get(root.left.val);
            if(leftStart <= start || leftStart > end) return false;
            int rightEnd = leftStart - 1;
            res.add(root.val);
            return helper(root.left, voyage, leftStart, end, res, map) 
                && helper(root.right, voyage, start + 1, rightEnd, res, map);
        }
        return false;
    }
}