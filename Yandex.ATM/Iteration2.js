moneyTypes = [5000, 1000, 500, 100, 50];
limits = {
  5000: 4,
  1000: 3,
  500: 2,
  100: 5,
  50: 100
};

function getMoney(amount) {
  const smallestBanknote = moneyTypes[moneyTypes.length - 1];
  if (amount % smallestBanknote !== 0) {
    // amount < 0? amount == 0?
    throw new Error(`Amount must be divided by ${smallestBanknote}`);
  }

  const result = {
    res: moneyTypes.reduce((map, banknote) => {
      map[banknote] = 0;
      return map;
    }, {}),
    limits: { ...limits }
  };

  for (let banknote of moneyTypes) {
    const neededCount = Math.floor(amount / banknote);
    const countToWithdraw = Math.min(neededCount, limits[banknote]);
    result.res[banknote] += countToWithdraw;
    result.limits[banknote] -= countToWithdraw;
    amount -= banknote * countToWithdraw;
  }

  if (amount > 0) {
    return {
      res: "warn",
      limits: { ...limits }
    };
  }

  return result;
}
