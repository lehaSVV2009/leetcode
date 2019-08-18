import java.io.*;
import java.util.*;

/*
you want one more round ?, but the session will automatically end in approx 2 hr time
but its okay if you wan, ok
no its fine , if there is time may be i'll try another too.
But you could do it in-place also ?, without using extra memory
you can think in terms of swapping char, insteacd of using extra space
first step 
yeah approach is good
*/

// array of chars => array of words 
// reverse array of words
// join with spaces bettween words

// reverse all character, with doing smth inside to store words/spaces
// reverse word when there is a space or end of array

/**
you can write the code itself, mya be the approach looks good.
// i was trying to explain you, 
// 
*/
// 1. arr = ['b', 'r', 'k', ' ', 's', t']
// 2. ['t', 's', ' ', 'k', 'r', 'b']
// 3. int previousSpace, reverse word from the start
// 4. 
//may be you can first reverse the whole array, and then can think in terms of reversing words
// you can just have a while start<end
class Solution {

  static char[] reverseWords(char[] arr) {
    int start = 0;
    int end = arr.length - 1;
    reverseWord(start, end, arr);

    int wordStart = 0;
    for (int index = 0; index < arr.length; index++) {
      if (arr[index] == ' ') {
        reverseWord(wordStart, index - 1, arr);
        wordStart = index + 1;
      } else if (index == arr.length - 1) {
        reverseWord(wordStart, index, arr);
      }
    }
    
    return arr;
  }

  static void reverseWord(int start, int end, char[] arr) {
    while (start < end) {
      char endChar = arr[end];
      arr[end] = arr[start];
      arr[start] = endChar;
      start++;
      end--;
    }
  }
  
  public static void main(String[] args) {
    System.out.println(reverseWords("abc".toCharArray()));
    System.out.println(reverseWords("abc qwe".toCharArray()));
    System.out.println(reverseWords("abc  qwe".toCharArray()));
    System.out.println(reverseWords("   abc  qwe".toCharArray()));
    System.out.println(reverseWords("abc  qwe   ".toCharArray()));
    System.out.println(reverseWords("   abc  qwe  rty ".toCharArray()));
    System.out.println(reverseWords("perfect makes practice".toCharArray()));
  }
}