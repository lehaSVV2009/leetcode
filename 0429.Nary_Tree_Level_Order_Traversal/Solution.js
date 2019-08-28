/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    // is root always single???
    // All children of same level are in a single array, right?
    // Could I change existing nodes?
    // Could child be a child of 2 parents?
    // Tree with n nodes
    // 
    // dfs - deep first search
    // bfs - bradth first search
    // bfs 
    
    // Solution 1
    // while node.length != 0
    //   traverse(List<Node> nodes) :: List<Node> leaves
    //   foreach leaves
    //      add to list of lists
    // O(N^2)...
    // Space O(N^2)...

    // Solution 2
    // while node.length != 0
    //   traverse(List<Node> nodes) :: List<Node> leaves
    //   add to list of list of nodes
    // foreach list of list of nodes
    //  foreach list of nodes
    //    add to list of integers..
    // O(N^2)...
    // Space O(N^2)...

    // Solution 3
    // while node.length != 0
    //   traverse(List<Node> nodes, List<List<Integer>> result) :: List<Node> leaves
    // O(N)...
    // Space O(N)...

    // traverse
    //   nextLevelChildren
    //   values
    //   foreach nodes
    //     children = getchildren
    //     foreach child
    //       values.add
    //       nextLevelChildren.addAll(child.children)
    const result = [];

    if (!root) {
        return result;
    }

    const queue = [root];
    while (queue.length !== 0) {
        const values = [];

        const length = queue.length;
        for (let i = 0; i < length; ++i) {
            const parent = queue.shift();
            if (parent.val || parent.val === 0) {
                values.push(parent.val);
            }
            if (Array.isArray(parent.children) && parent.children.length > 0) {
                Array.prototype.push.apply(queue, parent.children);
            }
        }
        result.push(values);
    }
    
    return result;
};