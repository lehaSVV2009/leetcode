/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }
        
        int leftCounter = maxDepth(A.left);
        int rightCounter = maxDepth(A.right);
        
        return Math.max(leftCounter, rightCounter) + 1;
    }
}
