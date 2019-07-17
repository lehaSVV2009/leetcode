class Solution {
    // Is it possible to have row with less bricks than in next row?
    // 0 bricks?
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }

        int height = wall.size();
        int width = wall.get(0).stream().mapToInt(Integer::intValue).sum();

        Map<Integer, Integer> cache = new HashMap<>();

        for (List<Integer> row : wall) {
            int i = -1;
            for (Integer brickWidth : row) {
                i += brickWidth;
                if (i < width - 1) {
                    int value = cache.getOrDefault(i, height);
                    cache.put(i, value - 1);         
                }
            }
        }

        return cache.values().stream().mapToInt(Integer::intValue).min().orElse(height);
    }
}