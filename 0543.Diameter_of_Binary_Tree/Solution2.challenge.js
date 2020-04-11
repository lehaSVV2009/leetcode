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
var diameterOfBinaryTree = function(root) {
  // 1 element? 0?
  // 2 elements? 1?
  
  // Solution 1
  // dfs
  // Go through all childs. when it comes to leave - return 1
  // sum left and right count.
  // return { max, current }
  let diameter = 0;
  
  //       1
  //     2
  //   4  5
  //  8    11
  function dfs(root) {
      if (!root) {
          return 0;
      }
      const left = dfs(root.left);
      const right = dfs(root.right);

      diameter = Math.max(diameter, left + right);
      return Math.max(left, right) + 1;
  }
  
  dfs(root);
  
  return diameter;
};