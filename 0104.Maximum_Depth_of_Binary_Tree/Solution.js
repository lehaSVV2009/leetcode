/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
  // root - null?
  // root - single?
  // root has one child? - 1

  // Solution 1
  // brute force
  // O(N)

  return dfs(root, 0);
};

var dfs = function(node, counter) {
  if (!node) {
    return counter;
  }
  counter++;

  const leftCounter = dfs(node.left, counter);
  const rightCounter = dfs(node.right, counter);

  return Math.max(leftCounter, rightCounter);
};
