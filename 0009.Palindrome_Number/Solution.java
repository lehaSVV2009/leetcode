class Solution {
    public boolean isPalindrome(int x) {
        String stringX = String.valueOf(x);
        String reverseX = new StringBuilder(stringX).reverse().toString();
        return stringX.equals(reverseX);
    }
}