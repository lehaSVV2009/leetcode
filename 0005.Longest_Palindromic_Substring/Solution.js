module.exports = { 
  //param A : string
  //return a strings
     longestPalindrome : function(text){
         // spaces/other characters?
         // empty array?
         // one character array?
         // 2 palindrome with same lengths?
         // is 'aa' also palindrome?
 
         // Solution 1
         // longestPalindrome = A[0]
         // foreach length
         //   foreach substring (i, length)
         //      is palindrome (from center to edges) or StringBuilder().reverse().equals()~ O(N)
         //      is longest
         //          longestPalindrome = A[0]
         // 
         // O(N^3)
         
         // Solution 2
         // longestPalindrome
         // foreach character
         //   while neigbourCharactersEqual and not out of range
         //      palindrome = leftNeigbour + palindrome + rightNeigbour
         //      palindromeLength += 2
         //   if palindromeLength > longestPalindrome
         //      longestPalindrome = palindrome
         //
         // O(N^2)
 
         // Solution 3
         // Map<char, list<index>>
         // foreach list<index> - substring, ifPalindrome
         // O(N^2)
         
         if (!text || text.length === 0) {
             return null;
         }
         
         function findPalindrome(base, left, right, text) {
             var palindrome = base;
             while (left >= 0 && right < text.length && text.charAt(left) === text.charAt(right)) {
                 palindrome = text.charAt(left) + palindrome + text.charAt(right);
                 left--;
                 right++;
             }
             return palindrome;
         }
 
         var longestPalindrome = text[0];
 
         for (var i = 0; i < text.length; ++i) {
             var oddPalindrome = findPalindrome(text.charAt(i), i - 1, i + 1, text);
             var evenPalindrome = findPalindrome('', i, i + 1, text);
 
             if (oddPalindrome.length > longestPalindrome.length) {
                 longestPalindrome = oddPalindrome;
             }
             if (evenPalindrome.length > longestPalindrome.length) {
                 longestPalindrome = evenPalindrome;
             }
         }
         
         return longestPalindrome;
     }
 };
 