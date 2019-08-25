class Solution {
    public int strStr(String haystack, String needle) {
        // needle is empty? 0
        // haystack is empty? -1
        // needle and haystack is empty? 0
        // abccc cc? 2
        // abccrdrrddcc? 2

        // precheck if haystack contains all characters of needle?

        // Solution 1
        // Calculate length of needle
        // Substring with length of needle until end is not greater or equals length
        // O(N)

        // Solution 2
        // build a tree? (O(N))
        
        if (haystack == null || needle == null) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        
        int haystackSize = haystack.length();
        int needleSize = needle.length();
        if (haystackSize < needleSize) {
            return -1;
        }

        if (haystack.equals(needle)) {
            return 0;
        }

        // "abc" "b"
        for (int start = 0; start < haystackSize + 1 - needleSize; ++start) {
            if (haystack.substring(start, start + needleSize).equals(needle)) {
                return start;
            }
        }
        
        return -1;
    }
}