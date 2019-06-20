/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean nextPlusOne = false;
        int sum = calculateSum(l1, l2);
        if (sum >= 10) {
            nextPlusOne = true;
            sum %= 10;
        }
        l1 = l1.next;
        l2 = l2.next;

        ListNode result = new ListNode(sum);
        ListNode tail = result;

        while (l1 != null || l2 != null) {
            sum = calculateSum(l1, l2);

            // Add 1 if previous sum was greater or equals to 10
            if (nextPlusOne) {
                sum++;
            }

            // Check is current sum is greater or equals to 10
            if (sum >= 10) {
                nextPlusOne = true;
                sum %= 10;
            } else {
                nextPlusOne = false;
            }

            tail = addNode(tail, sum);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Add last 1 if previous sum is greater than 10
        if (nextPlusOne) {
            tail = addNode(tail, 1);
        }

        return result;
    }

    private int calculateSum(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return -1;
        }
        if (list1 == null) {
            return list2.val;
        } 
        if (list2 == null) {
            return list1.val;
        }
        return list1.val + list2.val;
    } 
    
    private ListNode addNode(ListNode tail, int value) {
        tail.next = new ListNode(value);
        return tail.next;
    }
}