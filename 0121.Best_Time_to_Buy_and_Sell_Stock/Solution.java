class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int minValue = prices[0];

        for (int i = 1; i < prices.length; ++i) {
            int value = prices[i];
            if (value < minValue) {
                minValue = value;
                continue;
            }

            int difference = value - minValue;
            if (difference > maxProfit) {
                maxProfit = difference;
            }
        }
        
        return maxProfit;
    }
}