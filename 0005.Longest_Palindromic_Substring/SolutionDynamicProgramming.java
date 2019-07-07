class Solution {
    // zero characters? - ""
    // single character? - "a"
    // two characters? - "a"
    // spaces? unknown characters?
    // any algorihtm complexity/space requirements?
    public String longestPalindrome(String text) {
        if (isPalindrome(text)) {
            return text;
        }

        return dinamycProgramming(text);
    }
    
    public String dinamycProgramming(String text) {
        
        // abba
        int n = text.length();
        boolean [][]table = new boolean[n][n];

        // All substrings of length 1 are palindromes 
        // 1 0 0 0
        // 0 1 0 0 
        // 0 0 1 0
        // 0 0 0 1
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        // check for sub-string of length 2.
        // 1 0 0 0
        // 0 1 1 0 
        // 0 0 1 0
        // 0 0 0 1
        // start = 1
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                table[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }

        // Check for lengths greater than 2. k is length of substring 
        // 1 0 1 1
        // 0 1 1 1 
        // 0 0 1 0
        // 0 0 0 1
        // maxLength = 4
        // start = 0
        for (int k = 3; k <= n; ++k) { 
            
            // Fix the starting index 
            for (int i = 0; i < n - k + 1; ++i) {

                // Get the ending index of substring from 
                // starting index i and length k 
                int j = i + k - 1;
                
                // checking for sub-string from ith index to 
                // jth index if str.charAt(i+1) to  
                // str.charAt(j-1) is a palindrome 
                
                // L(0, 5) = L(1, 4) && text.charAt(0) == text.charAt(5)
                if (table[i + 1][j - 1] && text.charAt(i) == text.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }

        return text.substring(start, start + maxLength);
    }
    
    public boolean isPalindrome(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }
}
