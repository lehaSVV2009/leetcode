/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  // if empty? []
  // binary?
  // looks like simple bfs
  // loops?
  // single elements?
  // [3, 9, 20, 6, 8, 15, 7]

  // Solution 1 O(N)
  // bfs (children, result)
  //   result.push(children)
  //   allSubChildren = children.flatMap(child => {
  //     const subChildren = []
  //     if child.left subChildren.push(child.left.val)
  //     if child.right subChildren.push(child.right.val)
  //     return subChildren
  //   })
  //   if allSubChildren.length === 0
  //     return
  //   bfs(allSubChildren, result)
  if (!root) {
    return [];
  }

  return findAllSubChildren([root]);
};

function findAllSubChildren(children, result = []) {
  if (children.length === 0) {
    return result;
  }
  result.push(children.map(child => child.val));

  const allSubChildren = [];
  for (let child of children) {
    if (child.left) {
      allSubChildren.push(child.left);
    }
    if (child.right) {
      allSubChildren.push(child.right);
    }
  }

  return findAllSubChildren(allSubChildren, result);
}
