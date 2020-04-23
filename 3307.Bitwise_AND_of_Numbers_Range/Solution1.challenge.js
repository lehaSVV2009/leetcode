/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var rangeBitwiseAnd = function(start, end) {
    // greater than 0
    // if contains 0 - than all 0
    // [0, 1] = 00 & 01 = 00
    // [5, 7] = 101 & (110 & 111) = 101 & (110) = 100 = 4
    // [11, 12] = 1011 & 1100 = 1000 = 8
    // [14, 15] = 1110 & 1111 = 1110 = 14
    // [11, 11] = 1011 & 1011 = 1011 = 11
    // [1, 3] = 01 & 10 & 11 = 00 ?
    // [0, 3] = 00 && 01 & 10 & 11 = 00 ?
    // [0, 2147483646] = 0
    // [2147483644, 2147483646]
    // [3, 5] = 011 & 100 & 101 = 0
    // [13, 14] = 12
    // [12, 14] = 12

    // Solution 1
    // foreach number from index to    
    
    // Solution 2 get closest to %2? or Math.sqrt 2
    // if start == end return start
    // binary search?
    // find minimum that is square of 2?
    // if range contains number less than this min - than result is 0
    // if range contains min X 2 of it - than result is 0
    // if range doesn't contain square of it - than result is this number
    // else
    // some magic logic with % 2 and / 2

    if (start === 0 || start === end) {
        return start;
    }
    
    let result = start;
    
    for (let number = start + 1; number <= end; ++number) {
        result = result & number;
        if (result === 0) {
            break;
        }
    }
    
    return result;
    
};