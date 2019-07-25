module.exports = { 
  //param A : array of integers
  //return a array of integers
     wave : function(A){
         var sortedArray = A.sort(function(a, b) { return a - b; });
         // duplicates ??
         // [1,2,3,4,5] => [2,1,4,3,5]
         // [1,2,3,4] => [2,1,4,3]
         for (var i = 0, j = 1; i < sortedArray.length; i += 2, j += 2) {
             if (j < sortedArray.length) {
                 var temp = sortedArray[i];
                 sortedArray[i] = sortedArray[j];
                 sortedArray[j] = temp;
             }
         }
         return sortedArray;
     }
 };
 