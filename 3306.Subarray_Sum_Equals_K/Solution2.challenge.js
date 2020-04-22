/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, value) {
    // 2, [] ? 0
    // 0, [] ? 0
    // 0, [1, -1] ? 1
    // 0, [1, 0, -1, 0] ? 
    // 2, [1, -1, 1, 1] ? 2
    // 2, [1, 1, -1, 1] ? 2
    // 2, [1, 2, -1, 1] ? 3
    // 2, [1, 1, 1, 1] ? 3
    // 2, [1, 1, -1, 1, 1] ? 4

    // Solution 1
    // Brute force
    // O(N^2)

    // Solution 2
    // 2 pointers

    // Solution 3
    // divide and conquer

    // Solution 1
    // sums from left
    // [1, 2, 3]
    // sums from right
    // [3, 2, 1]

    // [1, 2, 3, 4]
    // sums - [1, 3, 6, 10]
    // sum(1, 3) = 9
    // sum(1, 3) = sum(0, 3) - sum(0, j-1) = 10 - 1 = 9

    // value = 2
    let result = 0;
    let sum = 0;

    const map = new Map();
    map.set(0, 1);

    // value = 2
    // 1 1 2 1
    // map = { 0: 1 }
    
    // i = 0
    // number = 1
    // sum = 1
    // map = { 0: 1, -1: 1 }
    
    // i = 1
    // number = 1
    // sum = 2
    // result = 1
    // map = { 0: 1, -1: 1, 2: 1 }
    for (let i = 0; i < nums.length; ++i) {
        const number = nums[i];
        sum += number;
        
        if (map.has(sum - value)) {
            result += map.get(sum - value);
        }
        
        map.set(sum, map.has(sum) ? map.get(sum) + 1 : 1)
    }

    return result;
};