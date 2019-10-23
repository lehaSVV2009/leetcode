/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // May I create separate list?
        // Any duplicates in array?

        // Solution 1
        // Create preResult
        // Create preResultHead
        // O(N^2)
        // while head
        //   go from preHead and insert into valid position
        // return preResult.next

        // Solution 2
        // ListNode to ArrayList
        // Arrays.sort() or insertion sort
        // ArrayList to ListNode
        // O(NlogN)!
        
        ListNode preResult = new ListNode(Integer.MIN_VALUE);
        ListNode resultHead = preResult;

        while (head != null) {
            ListNode tmp = new ListNode(head.val);

            while (resultHead.next != null && resultHead.next.val <= head.val) {
                resultHead = resultHead.next;
            }
            ListNode next = resultHead.next;
            resultHead.next = tmp;
            tmp.next = next;

            resultHead = preResult;
            head = head.next;
        }
        
        return preResult.next;
    }
}