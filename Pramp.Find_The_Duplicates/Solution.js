function findDuplicates(arr1, arr2) {
  const output = [];
  
  let arr1Index = 0, arr2Index = 0;
  
  // arr1 = [1, 2, 3]
  // arr2 = [3, 6]
  for (let i = 0; i < arr1.length + arr2.length; ++i) {
    if (arr1Index >= arr1.length || arr2Index >= arr2.length) {
      break;
    }
    if (arr1[arr1Index] < arr2[arr2Index]) {
      arr1Index++;
    } else if (arr1[arr1Index] > arr2[arr2Index]) {
      arr2Index++;
    } else {
      output.push(arr1[arr1Index]);
      arr1Index++;
      arr2Index++;
    }
  }

  return output;
}

//findDuplicates([], [])
//findDuplicates([1, 2], [3, 4])
//findDuplicates([1, 2, 3], [3, 4])
//findDuplicates([1, 2, 3, 5, 6, 7], [3, 6, 7, 8, 20])
// Solution 1. 2 loops
// O(N^2)

// Solution 2.
// i, j
// 

// arr1 = [1, 2, 3, 5, 6, 7]
// arr2 = [3, 6, 7, 8, 20]

// output
// i, j = 0
// loop 0 .. arr1.length + arr2.length
//   arr1Value < arr2Value
//     i++
//   else arr2Value > arr1Value
//     j++
//   else 
//     output[]
//     i++
//     j++
// O (N+M)
// 