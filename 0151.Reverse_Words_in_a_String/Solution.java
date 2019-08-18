class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        for (int i = 0, j = words.length - 1; i < j; ++i, --j) {
            swap(i, j, words);
        }

        return String.join(" ", words);
    }

    private void swap(int i, int j, String[] elements) {
        String temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}