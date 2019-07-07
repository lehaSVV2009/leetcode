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

        Map<Character, List<Integer>> duplicationStats = findDuplicationStats(text);

        return findLongestPalindromeFromDuplications(duplicationStats, text);
    }

    public Map<Character, List<Integer>> findDuplicationStats(String text) {
        Map<Character, Integer> visited = new HashMap<>();
        Map<Character, List<Integer>> duplicationStats = new HashMap<>();

        for (int index = 0; index < text.length(); ++index) {
            Character letter = text.charAt(index);
            
            if (duplicationStats.containsKey(letter)) {
                List<Integer> indexes = duplicationStats.get(letter);
                indexes.add(index);
            } else if (visited.containsKey(letter)) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(visited.get(letter));
                indexes.add(index);
                duplicationStats.put(letter, indexes);
            } else {
                visited.put(letter, index);
            }
        }

        return duplicationStats;
    }

    public String findLongestPalindromeFromDuplications(
        Map<Character, List<Integer>> duplicationStats,
        String text
    ) {
        String longest = text.substring(0, 1);

        for (Map.Entry<Character, List<Integer>> letterStats : duplicationStats.entrySet()) {
            List<Integer> duplicatesIndexes = letterStats.getValue();
            int duplicatesSize = duplicatesIndexes.size();

            for (int i = 0; i < duplicatesSize; ++i) {
                for (int j = duplicatesSize - 1; j >= i && duplicatesIndexes.get(j) - duplicatesIndexes.get(i) >= longest.length(); --j) {
                    String textToCheck = text.substring(duplicatesIndexes.get(i), duplicatesIndexes.get(j) + 1);
                    if (
                        textToCheck.length() > longest.length() 
                        && isPalindrome(textToCheck)
                    ) {
                        longest = textToCheck;
                    }
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
