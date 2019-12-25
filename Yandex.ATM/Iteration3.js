function getMoney(amount) {
  const limitsEntries = Object.entries(limits);

  const total = limitsEntries.reduce(
    (total, [banknote, count]) => (total += banknote * count),
    0
  );

  if (amount > total) {
    throw new Error(`Amount is too large. Maximum is ${total}`);
  }

  const combo = backtrack(limitsEntries, amount, {});
  if (!combo) {
    return {
      res: "warn",
      limits: { ...limits }
    };
  }

  const newLimits = { ...limits };
  for (let banknote in combo) {
    newLimits[banknote] -= combo[banknote];
  }

  return {
    res: combo,
    limits: newLimits
  };
}

function backtrack(limitsEntries, amount, result) {
  if (amount === 0) {
    return result;
  }
  if (amount < 0 || limitsEntries.length === 0) {
    return false;
  }

  const [[banknote, banknoteCount]] = limitsEntries;
  for (let count = 0; count <= banknoteCount; ++count) {
    const validCombo = backtrack(
      limitsEntries.slice(1),
      amount - banknote * count,
      { ...result, [banknote]: count }
    );
    if (validCombo) {
      return validCombo;
    }
  }
  return false;
}
