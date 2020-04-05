/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  // []? 0
  // [-1, 5]? negative values?
  //
  // [4, 3, 12, 1] -> buy 3, sell 12
  // [4, 5, 3, 12, 1] -> buy 4, sell 5, buy 3, sell 12
  // [3, 6, 7, 45, 44]

  // [4, 3] - 0
  // [3, 4] - if next number is greater than previous - buy and sell
  // [3, 4, 5] - if next-next number is greater than previous - buy and sell next-next
  // [3, 4, 5, 6] - if next number is greater than previous - buy and sell while next number is less than previous
  // [3, 6, 7, 6]
  // [4, 3, 20] - if next number is less than current - skip

  let profit = 0;

  // [7,1,5,3,6,4]
  // [1,2,3,4,5]
  // [7,6,4,3,1]
  for (let i = 0; i < prices.length - 1; ++i) {
    if (prices[i] >= prices[i + 1]) {
      continue;
    }

    let buy = prices[i];
    let sell = prices[i + 1];
    while (i + 1 < prices.length && prices[i] < prices[i + 1]) {
      sell = prices[i + 1];
      i++;
    }
    profit += sell - buy;
  }

  return profit;
};
