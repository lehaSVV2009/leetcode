class Solution {
    public List<List<String>> groupAnagrams(String[] words) {
        // empty array?
        // all arrays of same length?
        // 
        // Solution 1
        // isAnagrams('eat', 'tea') => HashMap<Char, Count> equal to HashMap<Char, Count>
        // HashMap<HashMap<Char, Count>, List<String>> result
        // foreach
        //   wordStats = generate HashMap<Char, Count>
        //   if result containsKey wordStats
        //     result.put(wordStats, result.get(map).push(word))
        // return result
        Map<Map<Character, Integer>, List<String>> resultMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Map<Character, Integer> wordStats = this.toWordStats(word);
            if (!resultMap.containsKey(wordStats)) {
                List<String> wordsGroup = new ArrayList<>();
                wordsGroup.add(word);
                resultMap.put(wordStats, wordsGroup);
            } else {
                List<String> wordsGroup = resultMap.get(wordStats);
                wordsGroup.add(word);
                resultMap.put(wordStats, wordsGroup);
            }
        }
        return new ArrayList<>(resultMap.values());
    }
    
    public Map<Character, Integer> toWordStats(String word) {
        Map<Character, Integer> wordStats = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character letter = word.charAt(i);
            wordStats.put(letter, wordStats.containsKey(letter) ? wordStats.get(letter) + 1 : 1);
        }
        return wordStats;
    }
}

