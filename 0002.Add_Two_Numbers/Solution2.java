/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        // A = 2 -> 4 -> 3, A.val = 2?
        // A empty?
        // B empty?
        // trailing zero?
        // A = 9 -> 9, B = 1 => 0 -> 0 -> 1?
        // Should I care about Integer.MAX?

        // Solution 1
        // result = new ListNode(0) // mock
        // tmp = result
        // bolean plusOne
        // while A != null || B != null
        //   int value = 0
        //   if A
        //     value += A.val
        //     A = A.next
        //   if B
        //     value += B.val
        //     B = B.next
        //   if plusOne
        //     value++
        //   if value >= 10
        //     value -= 10
        //     plusOne = true
        //   else
        //     plusOne = false
        //   tmp.next = new ListNode(value)
        //   tmp = tmp.next
        //
        // if plusOne tmp.next = new ListNode(1)
        //
        // return result.next;
        // O(N+M)

        ListNode result = new ListNode(0);
        ListNode tmp = result;
        boolean plusOne = false;
        
        while (A != null || B != null) {
            int value = 0;
            if (A != null) {
                value += A.val;
                A = A.next;
            }
            if (B != null) {
                value += B.val;
                B = B.next;
            }
            if (plusOne) {
                value++;
            }
            
            if (value >= 10) {
                plusOne = true;
                value -= 10;
            } else {
                plusOne = false;
            }
            
            tmp.next = new ListNode(value);
            tmp = tmp.next;
        }

        if (plusOne) {
            tmp.next = new ListNode(1);
        }

        return result.next;
    }
}
