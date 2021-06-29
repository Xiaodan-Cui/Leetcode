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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        int len = 0;
        ListNode pointer = head;
        while(pointer != null){
            pointer = pointer.next;
            len++;
        }
        //divide to two list
        pointer = head;
        for(int i = 0; i < (len - 1) / 2; i++){
            pointer = pointer.next;
        }
        ListNode secondHalf = pointer.next;
        pointer.next = null;
        //reverse
        secondHalf = reverse(secondHalf);
        //insert
        pointer = head;
        while(secondHalf != null){
            ListNode next = pointer.next;
            pointer.next = secondHalf;
            secondHalf = secondHalf.next;
            pointer.next.next = next;
            pointer = pointer.next.next;
        }
    }
    
    private ListNode reverse(ListNode node){
        ListNode head = new ListNode(0, node);
        ListNode pointer = node;
        while(pointer.next != null){
            ListNode curr = pointer.next;
            pointer.next = pointer.next.next;
            ListNode hnext = head.next;
            curr.next = hnext;
            head.next = curr;
        }
        return head.next;
    }
}