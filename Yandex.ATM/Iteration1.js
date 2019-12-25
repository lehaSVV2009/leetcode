moneyTypes = [5000, 1000, 500, 100, 50];

function getMoney(amount) {
  const smallestBanknote = moneyTypes[moneyTypes.length - 1];
  if (amount % smallestCount !== 0) {
    throw new Error(`Amount must be divided by ${smallestBanknote}`);
  }

  const result = {};
  for (let banknote of moneyTypes) {
    const neededCount = Math.floor(amount / banknote);
    result[banknote] = neededCount;
    amount -= banknote * neededCount;
  }
  return result;
}
