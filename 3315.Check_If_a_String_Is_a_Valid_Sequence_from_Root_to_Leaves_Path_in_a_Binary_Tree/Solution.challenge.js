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
 * @param {number[]} arr
 * @return {boolean}
 */
var isValidSequence = function(root, arr) {
    // Empty tree?
    // Empty arr?
    // array is greater than longest path from root to leaf?
    
    // Solution 1
    // O(N), n is all tree nodes
    // arr to string (because of 0-9 number requirement, no need to add separators between numbers)
    // dfs with path as argument
    // when you meat leaf, compare with arr. if yes - return true
    
    // Solution 2
    // O(M), m is size of array
    // Try to find element of arr in left or right
    // If found, go to left or right
    // If not found - return false 
    if (!root) {
        return false;
    }
    
    return dfs(root, [...arr]);
};

//  1
// 2

// [1]
function dfs(node, path) {
    if (path.length === 0) {
        return false;
    }

    const [firstPathElement, ...subPath] = path;
    if (node.val !== firstPathElement) {
        return false;
    }

    if (!node.left && !node.right && path.length == 1) {
        return true;
    }

    const left = !!node.left && dfs(node.left, subPath);
    const right = !!node.right && dfs(node.right, subPath);

    return left || right;
}