const index = (sortedArray) => {
  if (!Array.isArray(sortedArray) || sortedArray.length <= 1) {
    return false;
  }
  let j = sortedArray.length - 1;
  for (let i = 0; i < sortedArray.length; ++i) {
    while (j > i && sortedArray[j] + sortedArray[i] >= 0) {
      if (sortedArray[j] + sortedArray[i] === 0) {
        return true;
      }
      j--;
    }
  }
  return false;
}