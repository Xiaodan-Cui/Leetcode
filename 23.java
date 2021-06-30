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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        Queue<ListNode> queue = new LinkedList();
        for(ListNode ln : lists){
            queue.add(ln);
        }
        while(queue.size() > 1){
            ListNode l1 = queue.poll();
            ListNode l2 = queue.poll();
            ListNode ml = new ListNode(0);
            ListNode pointer = ml;
            while(l1!= null || l2!= null){
                if (l1 == null) {
                    pointer.next = l2;
                    break;
                }
                if (l2 == null){
                    pointer.next = l1;
                    break;
                }
                if (l1.val <= l2.val){
                    pointer.next = l1;
                    l1 = l1.next;
                    pointer = pointer.next;
                }
                else {
                    pointer.next = l2;
                    l2 = l2.next;
                    pointer = pointer.next;
                }
            }
            queue.add(ml.next);
        }
        return queue.poll();
    }
}