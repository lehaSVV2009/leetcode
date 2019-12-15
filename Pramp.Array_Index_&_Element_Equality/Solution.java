import java.io.*;
import java.util.*;

class Solution {
  
  static int indexEqualsValueSearch(int[] arr) {
    // your code goes here
    
    int start = 0;
    int end = arr.length - 1;
    
    int result = -1;

    while (start <= end) {
      int medium = (start + end) / 2;

      if (arr[medium] > medium) { 
        end = medium - 1; 
      }

      if (arr[medium] < medium) {
        start = medium + 1; // 2
      }

      if (arr[medium] == medium) {
        result = medium;
        end = medium - 1; 
      }
    }
    
    return result;
  }

  public static void main(String[] args) {
    // if array is empty => -1
    // if no index != value => -1
    
    // Solution 1
    // O(N)
    
    // Solution 2
    // 
    // [0,1,2,5]
    // 2 - is valid
    // 1 - is valid
    // 0 - is valid
    //
    // 
    // logN N/2
  }

}