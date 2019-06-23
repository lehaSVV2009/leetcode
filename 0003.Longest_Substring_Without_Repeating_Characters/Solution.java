class Solution {
    // Idea 1.
    // 1. Split to unrepeatable substrings
    // 2. Find max length
    // Go trough all the characters and store it in map and list
    // If character is presented in map, copy the list, put to the list of unrepeatable substrings, remove all characters before first duplicated from current list and map and continue cycle
    
    // Idea 2. regexp

    // tests:
    // abcd
    // abbcd
    // abcbd
    public int lengthOfLongestSubstring(String text) {
        if (text == null) {
            return -1;
        }
        if (text.length() <= 1) {
            return text.length();
        }
        
        List<String> substrings = splitToDistinctSubstrings(text);        
        return findMaxLength(substrings);
    }
    
    public List<String> splitToDistinctSubstrings(String text) {
        List<String> uniqueSubstrings = new ArrayList<>();

        // TODO StringBuilder instead of String?
        String currentText = "";
        for (int index = 0; index < text.length(); index++) {
            char letter = text.charAt(index);

            int letterIndex = currentText.indexOf(letter);
            if (letterIndex != -1) {
                uniqueSubstrings.add(currentText);
                currentText = currentText.substring(letterIndex + 1);
            }
            currentText += letter;
        }

        if (!currentText.isEmpty()) {
            uniqueSubstrings.add(currentText);
        }

        return uniqueSubstrings;
    }

    public int findMaxLength(List<String> substrings) {
        return substrings
            .stream()
            .map(String::length)
            .mapToInt(Integer::intValue)
            .max()
            .getAsInt();
    }
}