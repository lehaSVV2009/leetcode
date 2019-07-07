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

        return findLongestExpandingCenter(text);
    }

    public String findLongestExpandingCenter(String text) {
        String longest = "";
        for (int index = 0; index < text.length(); index++) {
            int oddPalindromeLength = findPalindromeLength(text, index, index);
            int evenPalindromeLength = findPalindromeLength(text, index, index + 1);
            int maxLength = Math.max(oddPalindromeLength, evenPalindromeLength);
            if (maxLength > longest.length()) {
                longest = text.substring(index - ((maxLength - 1) / 2), index + (maxLength / 2) + 1);
            }
        }
        return longest;
    }

    private int findPalindromeLength(String text, int left, int right) {
        while (left >= 0 && right < text.length() && text.charAt(left) == text.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    public boolean isPalindrome(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }
}
