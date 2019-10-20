/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // if m == n return head
        // Thinking about simple reverse list
        // Reverse is just reverse, not sorting, right? yes
        // n inclusive? yes

        // Solution 1
        // Create result linked list
        // copy values until m
        // Create reversed linked list
        // Copy values from m to n in reversed way to reversed linked list
        // Attach reversed linked list to result linked list
        // copy values from n to end to result linked list

        if (m == n) {
            return head;
        }

        ListNode preResultHead = new ListNode(-1);
        ListNode preResultTail = preResultHead;

        int index = 1;

        while (head != null && index != m) {
            preResultTail.next = head;
            preResultTail = preResultTail.next;

            index++;
            head = head.next;
        }

        ListNode reversedHead = null;
        ListNode reversedTail = null;

        if (head != null) {
            reversedTail = new ListNode(head.val);
            reversedHead = reversedTail;
            index++;
            head = head.next;
        }

        while (head != null && index != n + 1) {
            ListNode tmp = new ListNode(head.val);
            tmp.next = reversedHead;
            reversedHead = tmp;

            index++;
            head = head.next;
        }

        preResultTail.next = reversedHead;
        preResultTail = reversedTail;

        while (head != null) {
            preResultTail.next = head;
            preResultTail = preResultTail.next;

            index++;
            head = head.next;
        }

        return preResultHead.next;
    }
}