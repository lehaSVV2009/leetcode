/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxPathSum = function(root) {
    // empty tree?
    // one node tree?
    // dfs
    let result = { max: -2147483648 };
    
    dfs(root, result);
    return result.max;
};

//  -10
//  / \
// 9  20
//   /  \
//  15   7
// /  \
//20  20

//    -1 
//   2 -20
//  3
//-40
function dfs (node, result) {
    if (!node) {
        return 0;
    }

    const left = dfs(node.left, result);
    const right = dfs(node.right, result);

    const value = node.val;
    const maxSingle = Math.max(Math.max(left, right) + value, value);

    result.max = Math.max(result.max, maxSingle, left + right + value);
    
    return maxSingle;
}