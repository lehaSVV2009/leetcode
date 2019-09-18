class Solution {
    public int mySqrt(int a) {
        // negative?
	    // 1 - 1
	    // 2 - 1?
	    // 3 - 1?
	    // 4 - 2

	    // Solution 1 naive
        // result = 1
	    // loop number = 1..a
	    //   if number * number > a
	    //     break
	    //   result = number
	    // return result
	    // O(N)
	    
	    // Solution 2 binary search
        // result = 1
	    // start = 1
	    // end = a // maybe a/2 skipping 1
	    // while (start < end)
	    //   result = (start + end) / 2
	    //   value = result ^ 2
	    //   if (value == a) // || result^2 < a && (result+1)^2 > a
	    //     return result
	    //   if (value < a)
        //     start = result + 1
	    //   else
        //     end = result - 1
	    // return result
	    
	    if (a == 0) {
	        return 0;
	    }
	    
	    int result = 1;

	    int start = 1;
	    int end = a;
	    while (start <= end) {
	        result = start + (end - start) / 2;
            int value = a / result;
	        if (value == result) {
	            return result;
	        }
            boolean isLower = result < value;
            if (isLower && result + 1 > a / (result + 1)) {
                return result;
            }
	        if (isLower) {
	            start = result + 1;
	        } else {
	            end = result - 1;
	        }
	    }

	    return result;
    }
}