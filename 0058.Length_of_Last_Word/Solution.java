class Solution {
    public int lengthOfLastWord(String s) {
        // Is it possible to have 2 spaces?

        // Solution 1
        // From the last element integer-- until not space or start of string
        int i = s.length() - 1;
        int lastWordLength = 0;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            lastWordLength++;
            i--;
        }

        return lastWordLength;
    }
}