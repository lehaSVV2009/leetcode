/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {    
        ListNode root = l1;
        
        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l2.val <= l1.val)) {
                l2 = l2.next;
            } else {
                val = l1.val;
                l1 = l1.next;
            }

            leaf.next = new ListNode(val);
            leaf = leaf.next;
        }

        return result.next;
    }
}