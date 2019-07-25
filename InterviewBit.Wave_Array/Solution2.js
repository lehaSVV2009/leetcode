module.exports = { 
  //param A : array of integers
  //return a array of integers
     wave : function(A){
         // [1,2,3,4,5]
         // [4,6,1,3,2,10,10]
         // [6,1,4,2,10,3,10]
         // if i - 1 >= 0 and element is less than previous
         // swap
         // if i + 1 < A.length and element is less than next
         // swap
         for (var i = 0; i < A.length; i += 2) {
             if (i - 1 >= 0 && A[i] < A[i - 1]) {
                 var temp = A[i];
                 A[i] = A[i - 1];
                 A[i - 1] = temp;
             }
             
             if (i + 1 < A.length && A[i] < A[i + 1]) {
                 var temp = A[i];
                 A[i] = A[i + 1];
                 A[i + 1] = temp;
             }
         }
         
         return A;
     }
 };
 