/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < lists.size(); ++i) {
            ListNode list = lists.get(i);
            while (list != null) {
                treeMap.merge(list.val, 1, Integer::sum);
                list = list.next;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            Integer number = entry.getKey();
            Integer count = entry.getValue();

            while (count > 0) {
                tmp.next = new ListNode(number);
                tmp = tmp.next;
                count--;
            }
        }
        
        return result.next;

	}
}
