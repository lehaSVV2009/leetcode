class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];

        for (int index = 1; index < strs.length; ++index) {
            int prefixSize = prefix.length();
            if (prefixSize == 0) {
                return prefix;
            }

            String textToCompare = strs[index];
            int textToCompareSize = textToCompare.length();
            if (prefixSize > textToCompareSize) {
                prefix = prefix.substring(0, textToCompareSize);
            }

            for (int charIndex = 0; charIndex < prefix.length(); ++charIndex) {
                char prefixChar = prefix.charAt(charIndex);
                char textChar = textToCompare.charAt(charIndex);

                if (prefixChar != textChar) {
                    if (charIndex == 0) {
                        return "";
                    }
                    prefix = prefix.substring(0, charIndex);
                    break;
                }
            }
        }

        return prefix;
    }
}