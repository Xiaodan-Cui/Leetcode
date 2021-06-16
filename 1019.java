/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack();
        int i = list.size() - 1;
        while(i >= 0){
            while(stack.size() > 0 && stack.peek() <= list.get(i)){
                stack.pop();
            }
            res[i] = stack.size() == 0 ? 0 : stack.peek();
            stack.push(list.get(i));
            i--;
        }
        return res;
    }
}