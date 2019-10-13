/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null) {
            ListNode delete = current;
            
            while (delete.next != null && delete.val == delete.next.val) {
                delete = delete.next;
            }
            
            current.next = delete.next;
            
            current = current.next;
        }

        return head;
    }
}