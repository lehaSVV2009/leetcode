class Solution {
    public static final char STAR_CHAR = '*';
    public static final char DOT_CHAR = '.';
    public static final String STAR = String.valueOf(STAR_CHAR);
    public static final String DOT = String.valueOf(DOT_CHAR);    

    public boolean isMatch(String text, String pattern) {
        final int patternSize = pattern.length();
        final int textSize = text.length();

        if (text == null || pattern == null) {
            return false;
        }

        if (STAR.equals(pattern)) {
            return false;
        }

        if (DOT.equals(pattern) && textSize == 1) {
            return true;
        }

        if ((DOT + STAR).equals(pattern)) {
            return true;
        }

        if (text.equals(pattern)) {
            return true;
        }

        return isMatchRecursive(text, pattern);
    }

    private boolean isMatchRecursive(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        boolean firstCharsMatch = isFirstCharsMatch(text, pattern);
        
        if (isSecondCharStar(pattern)) {
            return isMatchRecursive(text, pattern.substring(2)) 
                || (firstCharsMatch && isMatchRecursive(text.substring(1), pattern));
        }

        return firstCharsMatch && isMatchRecursive(text.substring(1), pattern.substring(1));
    }

    private boolean isFirstCharsMatch(String text, String pattern) {
        return !text.isEmpty()
            && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == DOT_CHAR);
    }

    private boolean isSecondCharStar(String pattern) {
        return pattern.length() >= 2
            && pattern.charAt(1) == STAR_CHAR;
    }
}