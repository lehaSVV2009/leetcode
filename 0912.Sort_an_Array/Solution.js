function bubbleSort(array) {
  for (let i = 0; i < array.length - 1; ++i) {
    for (let j = i + 1; j < array.length; ++j) {
      if (array[i] < array[j]) {
        const tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
      }
    }
  }
  return array;
}

function selectionSort(array) {
  for (let i = 0; i < array.length - 1; ++i) {
    let max = array[i];
    let maxIndex = i;
    for (let j = i + 1; j < array.length; ++j) {
      if (max < array[j]) {
        maxIndex = j;
        max = array[j];
      }
    }
    array[maxIndex] = array[i];
    array[i] = max;
  }
  return array;
}

function quicksort(array, start, end) {
  if (start >= end) return array;
  const pivotIndex = partition(array, start, end);
  quicksort(array, start, pivotIndex - 1);
  quicksort(array, pivotIndex + 1, end);
  return array;
}

function partition(array, start, end) {
  const pivot = array[end];
  let pIndex = start;
  for (let i = start; i < end; ++i) {
    if (array[i] <= pivot) {
      swap(array, i, pIndex);
      pIndex++;
    }
  }
  swap(array, pIndex, end);
  return pIndex;
}

function swap(array, i, j) {
  const tmp = array[i];
  array[i] = array[j];
  array[j] = tmp;
}

function binarySearch(array, value) {
  let start = 0;
  let end = array.length - 1;

  while (start <= end) {
    const medium = Math.floor((start + end) / 2);

    const mediumValue = array[medium];
    if (mediumValue === value) {
      return medium;
    }

    if (value < mediumValue) {
      end = medium - 1;
    } else {
      start = medium + 1;
    }
  }

  return -1;
}
