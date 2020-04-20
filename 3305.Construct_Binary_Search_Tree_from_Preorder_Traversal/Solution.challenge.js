/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @return {TreeNode}
 */
var bstFromPreorder = function(preorder) {
    // Duplicates?
    // 
    if (!preorder || preorder.length === 0) {
        return [];
    }
    
    // Solution 1
    // easy way
    // NlogN
    // for each element
    //   insert to node from root
    
    // Solution 2
    // Stack
    // O(N)?
    // 
    
    const root = new TreeNode(preorder[0]);
    const path = [root];

    for (let i = 1; i < preorder.length; ++i) {
        const currentValue = preorder[i];

        let currentNode = null;
        while (path.length > 0 && path[path.length - 1].val < currentValue) {
            currentNode = path.pop();
        }

        if (currentNode) {
            currentNode.right = new TreeNode(currentValue);
            path.push(currentNode.right);
        } else {
            currentNode = path[path.length - 1];
            currentNode.left = new TreeNode(currentValue);
            path.push(currentNode.left);
        }
    }
    
    return root;
};