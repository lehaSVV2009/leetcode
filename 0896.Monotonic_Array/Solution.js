/**
 * @param {number[]} A
 * @return {boolean}
 */
var isMonotonic = function(A) {
    if (!Array.isArray(A)) {
        return false;
    }

    if (A.length <= 1) {
        return true;
    }

    let increasing = false;
    let decreasing = false;
    
    for (let index = 1; index < A.length; index++) {
        let greater = A[index] > A[index - 1];
        let smaller = A[index] < A[index - 1];

        if (smaller) {
            if (increasing) {
                return false;
            }
            decreasing = true;
        }
        if (greater) {
            if (decreasing) {
                return false;
            }
            increasing = true;
        }
    }

    return true;
};