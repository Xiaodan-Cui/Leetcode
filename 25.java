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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0, head);
        ListNode before = res;
        ListNode first = head;
        while(true){
            ListNode counter = first;
            //if >= k nodes remaining
            for(int i = 0; i <= k - 1; i++){
                if (counter == null) return res.next;
                counter = counter.next;
            }
            //System.out.println(1);
            //reverse every section
            for(int i = 0; i < k - 1; i++){
                ListNode temp = before.next;
                before.next = first.next;
                first.next = first.next.next;
                before.next.next = temp;
            }
            //move forward pointer
            before = first;
            first = first.next;
        }
    }
}