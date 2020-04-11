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
  if (!root) {
      return 0;
  }
  
  return dfs(root).diameter;
};

//       1
//     2
//   4  5
//  8    11
function dfs(root) {
  let left = { maxLevel: 0, diameter: 0 };
  if (root.left) {
      left = dfs(root.left);
  }

  let right = { maxLevel: 0, diameter: 0 };
  if (root.right) {
      right = dfs(root.right);
  }

  const maxLevel = Math.max(left.maxLevel, right.maxLevel) + 1;
  const diameter = Math.max(left.diameter, right.diameter, left.maxLevel + right.maxLevel);
  return { maxLevel, diameter };
}