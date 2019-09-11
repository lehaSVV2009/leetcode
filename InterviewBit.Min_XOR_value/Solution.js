module.exports = { 
 //param A : array of integers
 //return an integer
	findMinXor : function(array){
	    // sorted?
	    // no values?
	    // 1 value?
	    // negative values?
	    
        // Solution 1
        // straight forward
        // var minXor
        // foreach
        //  foreach
        //    xor
        //    if less - minXor
        // O(N^2)

	    // Solution 2
        // 1st Try 5 xor to find logic
        //
        // 0 4 7 9

        // 0 4
        // 0 7
        // 4 7
        // 4 9
        // 7 9
        
        // 0 - 0000
        // 4 - 0100
        // 7 - 0111
        // 9 - 1001

        // 0 4
        // 0100 - 4
        // 0 7
        // 0111 - 7
        // 4 7
        // 0011 - 2
        // 4 9
        // 1101 - 13
        // 7 9
        // 1110 - 14

        // <<
        // >>
        // ^
        // ~
        // |
        // &
        
        // Guess.. ^
        // 0100
        // 0011
        // 1010
        
        // Guess.. &
        // 0000
        // 0000
        // 0000
        
        // Guess.. |
        // 0100
        // 0111
        // 1111
        
        // Solution 3
        // Sort before calculating
        // Cause only neighbours can have minimum ^

        if (array.length === 0) {
            return 0;
        }
        if (array.length === 1) {
            return array[0];
        }

        array.sort(function (left, right) { 
            return left - right;
        });

        var minXor = Number.MAX_VALUE;
        for (var i = 0, j = 1; j < array.length; ++i, ++j) {
            var xor = array[i] ^ array[j];
            if (xor < minXor) {
                minXor = xor;
            }
        }
        return minXor;
	}
};
