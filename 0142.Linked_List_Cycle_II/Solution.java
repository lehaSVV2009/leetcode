/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Not by value, but by reference, right?
        // Return node that start cycle (4), or next to starting cycle node (3)?
        
        // Solution 1.
        // Using memory
        // Visited set
        // while list != null
        //   check if not in visited set
        //   store list.node in visited set
        // Algorithm complexity - O(N^2)
        // Space complexity - O(N)

        // Solution 2
        // slow-fast
        // Find meeting point slow-fast, stop when links are equal
        // while meet != head
        //    meet = meet.next
        //    head = head.next

        // Example
        //     <-
        //    |  |
        // 1->2->3
        // slow -> 1 -> 2 -> 3
        // fast -> 1 -> 3 -> 3
        // meet = 3
        // head -> 1 -> 2
        // meet -> 3 -> 2
        // result = 2

        // Example
        //     <----
        //    |     |
        // 1->2->3->4
        // count = 4
        // slow -> 1 -> 2 -> 3 -> 4
        // fast -> 1 -> 3 -> 2 -> 4
        // meet = 4
        // head -> 1 -> 2
        // meet -> 4 -> 1

        // Example
        //  <----
        // |     |
        // 1->2->3
        // count 4
        // slow -> 1 -> 2 -> 3 -> 1 -> 2 -> 3
        // fast -> 1 -> 3 -> 2 -> 1
        // meet = 3
        // head -> 1
        // meet -> 1
        
        // Example 
        // 1->2->3
        // slow -> 1 -> 2
        // fast -> 1 -> 3

        if (head == null || head.next == null) {
            return null;
        }
    
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        ListNode meet = fast == slow ? fast : null;
        if (meet == null) {
            return null;
        }

        while (head != meet) {
            head = head.next;
            meet = meet.next;
        }
        
        return head;
    }
}
