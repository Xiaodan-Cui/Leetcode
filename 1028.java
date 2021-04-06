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
    public TreeNode recoverFromPreorder(String S) {
        if (S.length() == 0) return null;
        Queue<Integer> queue = new LinkedList();
        int i = 0;
        while (i < S.length()){
            if (Character.isDigit(S.charAt(i))){
                int num = S.charAt(i++) - '0';
                while (i < S.length() && Character.isDigit(S.charAt(i))){
                    num = num * 10 + (S.charAt(i++) - '0');
                }
                queue.add(num);
            }
            else{
                queue.add(-1);
                i++;
            }
        }
        return helper(queue);
    }
    
    private TreeNode helper(Queue<Integer> queue) {
        if(queue.isEmpty()) return null;
        TreeNode root = new TreeNode(queue.poll());
        if (queue.isEmpty()) return root;
        queue.poll();
        Queue<Integer> queueLeft = new LinkedList();
        Queue<Integer> queueRight = new LinkedList();
        splitQueue(queue,queueLeft);
        splitQueue(queue,queueRight);
        
        root.left = helper(queueLeft);
        root.right = helper(queueRight);
        
        return root;
    }
    
    private void splitQueue(Queue<Integer> queue, Queue<Integer> queueRes) {
        int pre = 0;
        //System.out.println(pre);
        boolean addable = false;
        while (!queue.isEmpty()) {
            if(queue.peek()!=-1){
                if(pre == -1 && !addable) {
                    break;
                }
                queueRes.add(queue.poll());
                pre=1;
                addable = false;
                //System.out.println(1);
            }
            else{
                if(pre == -1) {
                    addable = true;
                    queueRes.add(queue.poll());
                }
                else{
                    queue.poll();
                    pre = -1;
                }
            }
        }
    }
    
}