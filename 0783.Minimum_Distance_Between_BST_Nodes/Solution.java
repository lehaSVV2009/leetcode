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
var minDiffInBST = function(root) {
    const cache = [root.val];
    
    let leftMin = deepFindMinDifference(root.left, cache, null);
    let rightMin = deepFindMinDifference(root.right, cache, null);

    if (leftMin && rightMin) {
        return Math.min(leftMin, rightMin);
    }

    return leftMin ? leftMin : rightMin;
};

const deepFindMinDifference = (child, cache, currentMin = null) => {
    if (!child || !child.val) {
        return currentMin;
    }

    let difference = Math.min(...cache.map(item => Math.abs(child.val - item)));
    currentMin = currentMin ? Math.min(currentMin, difference) : difference;
    if (currentMin === 1) {
        return 1;
    }

    cache.push(child.val);

    let leftChildMin = deepFindMinDifference(child.left, cache, currentMin);
    if (leftChildMin === 1) {
        return 1;
    }

    let rightChildMin = deepFindMinDifference(child.right, cache, currentMin);
    if (rightChildMin === 1) {
        return 1;
    }

    return Math.min(currentMin, leftChildMin, rightChildMin);
}