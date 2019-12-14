/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class ListNodeInfo {
        public int top;
        public ListNode node;
        
        public ListNodeInfo(int top, ListNode node) {
            this.top = top;
            this.node = node;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNodeInfo> queue = new PriorityQueue<>(
            11, 
            (ListNodeInfo info1, ListNodeInfo info2) -> info1.top < info2.top ? -1 : 1
        );

        for (int i = 0; i < lists.length; ++i) {
            ListNode list = lists[i];
            if (list != null) {
                queue.add(new ListNodeInfo(list.val, list));
            }
        }

        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        while (queue.size() != 0) {
            ListNodeInfo info = queue.poll();

            tmp.next = new ListNode(info.top);
            tmp = tmp.next;
            
            ListNode nextNode = info.node.next;
            if (nextNode != null) {
                queue.add(new ListNodeInfo(nextNode.val, nextNode));
            }
        }

        return result.next;
        // Solution 1
        // brute-force
        // array
        // foreach lists
        //   foreach item
        //     array.push
        // array.sort
        // array to ListNode
        // ONlogN

        // Solution 2
        // many pointers?
        // ListNode result
        // minIndex = 0
        // while minIndex != -1
        //   int min = Integer.MIN_VALUE
        //   int minIndex = -1;
        //   foreach index, list
        //     if list == null
        //       continue
        //     if list.val >= min
        //       min = list.val
        //       minIndex = index
        //   if minIndex != -1
        //     O(N*M), M - numbers of elements in lists
        
        // Solution 3
        // Build sorted TreeMap with duplicate counters
        // Then transform tree map to ListNode
        // NlogN

        // Solution 4
        // Build array
        // foreach element
        //   binary-search to find position to element
        //   add to array
    }
}