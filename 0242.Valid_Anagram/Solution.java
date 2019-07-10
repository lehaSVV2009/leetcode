class Solution {
    // "" - ""? - true
    // "blaaa" - "bla"? - false
    // null - null ? false
    // "test" - "test" - true
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }

        Map<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char letter = s.charAt(i);
            if (letters.containsKey(letter)) {
                letters.put(letter, letters.get(letter) + 1);
            } else {
                letters.put(letter, 1);
            }
        }

        for (int i = 0; i < t.length(); ++i) {
            char letter = t.charAt(i);

            // T contains letter that S doesn't contain
            if (!letters.containsKey(letter)) {
                return false;
            }

            int count = letters.get(letter);
            if (count == 1) {
                letters.remove(letter);
            } else {
                letters.put(letter, count - 1);
            }
        }

        return letters.isEmpty();
    }
}