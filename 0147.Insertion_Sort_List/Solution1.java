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
        // Always store preHead
        // O(N^2)
        // for each element
        //   go from preHead and insert into
        //   delete current element

        // Solution 2
        // ListNode to ArrayList
        // Arrays.sort() or insertion sort
        // ArrayList to ListNode
        // O(NlogN)!
        
        List<Integer> numbers = new ArrayList<>();
        
        while (head != null) {
            numbers.add(head.val);
            head = head.next;
        }
        
        Collections.sort(numbers);

        ListNode preResult = new ListNode(-1);
        ListNode tail = preResult;
        for (Integer number: numbers) {
            tail.next = new ListNode(number);
            tail = tail.next;
        }

        return preResult.next;
    }
}

/**
Runtime: 4 ms, faster than 76.39% of Java online submissions for Insertion Sort List.
Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Insertion Sort List. */