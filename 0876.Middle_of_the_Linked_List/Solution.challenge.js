/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function(head) {
  // Solution 1
  // 2 pointers (slow/fast)
  // when fast is null, slow is approximate result

  // [] ? runtime error
  // [1] ? [1]
  // [1, 2]? [2]
  // [1, 2, 3]? [2,3]
  // [1, 2, 3, 4]? [3,4]
  // [1, 2, 3, 4, 5]? [3,4,5]
  // [1, 2, 3, 4, 5, 6]? [4,5,6]

  let slow = head;
  let fast = head;

  while (fast && fast.next) {
      slow = slow.next;
      fast = fast.next.next;       
  }
  
  return slow;
};