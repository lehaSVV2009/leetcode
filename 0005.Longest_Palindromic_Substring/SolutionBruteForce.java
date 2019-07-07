class Solution {
    
    // brute force -> for [1...char_length] { for [1...] }
    
    // zero characters? - ""
    // single character? - "a"
    // two characters? - "a"
    // spaces? unknown characters?
    // any algorihtm complexity/space requirements?
    public String longestPalindrome(String text) {
        if (isPalindrome(text)) {
            return text;
        }

        return bruteForce(text);
    }
    
    public String bruteForce(String text) {
        int length = text.length();
        String longest = text.substring(0, 1);

        for (int i = length - 1; i >= 2; --i) {
            if (longest.length() > i) {
                break;
            }
            for (int j = 0; j <= length - i; ++j) {
                String part = text.substring(j, j + i);
                if (isPalindrome(part) && part.length() > longest.length()) {
                    longest = part;
                }
            }
        }
        return longest;
    }

    public boolean isPalindrome(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }
}
