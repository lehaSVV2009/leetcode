/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    // No matter which last index is?
    // [] ? failed
    // [0] ? true
    // [1] ? true
    // [1, x] ? true
    // [0, x] ? false
    // [0, *] ? false
    // [0, **] ? false
    // [1, 0, x] ? false
    // [2, 0, x] ? true
    // [1, 0, 1, x] ? false
    // [2, 0, 1, x] ? true
    // [3, 0, 0, x] ? true
    // [1, 1, 1, x] ? true
    // [1, 0, 2, 0, x] ? false
    // [2, 0, 1, 0, x] ? false
    // [2, 0, 2, 0, x] ? true
    // [2, 0, 0, 0, x] ? false
    // [4, 0, 0, 0, x] ? true
    // [4, 0, 2, 0, x] ? true
    // [4, 0, 1, 0, x] ? true !!!
    // [6, 0, 1, 0, 2, 0, x] ? true !!!

    // Solution 1
    // if index === lastIndex
    //   return true
    // if index > lastIndex
    //   return false
    // foreach 1...(Math.min(firstNumber, lastIndex)
    //   if recursively go to index
    //     return true
    // return false

    // Solution 2
    // O(N)
    // if length === 0
    //   return ?
    // if length <= 2
    //   return nums[0] > 0
    // if nums[0] === 0
    //   return false
    //
    // requiredLeft = 1
    // for nums[length - 2]...nums[1]
    //   if number >= requiredLeft
    //     requiredLeft = 1
    //   else
    //     requiredLeft++
    //     
    // return nums[0] >= requiredLeft
    
    if (!nums || nums.length === 0) {
        return false;
    }
    if (nums.length === 1) {
        return true;
    }
    if (nums.length === 2) {
        return nums[0] > 0;
    }
    if (nums[0] === 0) {
        return false;
    }
    
    let requiredLeft = 1;
    for (let i = nums.length - 2; i >= 1; --i) {
        let number = nums[i];
        if (number >= requiredLeft) {
            requiredLeft = 1;
        } else {
            requiredLeft++;
        }
    }
    return nums[0] >= requiredLeft;
};