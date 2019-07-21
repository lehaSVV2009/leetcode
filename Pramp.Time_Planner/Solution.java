import java.io.*;
import java.util.*;

class Solution {

  // slotsA 1 <= [[0, 12], []] <= 100
  // slotsB 2 <= [[4, 45]] <= 100
  // duration 1 seconds
  // 
  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    // dur = 8
    // slotsA = [[10, 50], [60, 120], [140, 210]]
    // slotsB = [[11, 15], [25, 28], [60, 70]]
    // [25, 33]
    
    // [10, 50]
    // [25, 45]

    int aIndex = 0;
    int bIndex = 0;

    // 1. check to iterate
    // 2. start/end times for candidate
    
    while (aIndex != slotsA.length && bIndex != slotsB.length) {
      System.out.println(aIndex + " - " + bIndex);
      int[] slotA = slotsA[aIndex];
      int slotAStart = slotA[0]; // 10
      int slotAEnd = slotA[1]; // 50

      int[] slotB = slotsB[bIndex];
      int slotBStart = slotB[0]; // 11
      int slotBEnd = slotB[1]; // 15

      int start = Math.max(slotAStart, slotBStart);
      int end = Math.min(slotAEnd, slotBEnd);

      if (end - start >= dur) {
        int[] result = new int[2];
        result[0] = start;
        result[1] = start + dur;
        return result;
      }

      if (end == slotAEnd) {
        aIndex++;
      } else {
        bIndex++;
      }
    }

    return new int[0];
  }
  
  public static void main(String[] args) {
    int[][] slotsA = new int[][]{
      {10, 50},
      {60, 120},
      {140, 210}
    };
    int[][] slotsB = new int[][]{
      {0, 15},
      {60, 70}
    };

    int[] planner = meetingPlanner(slotsA, slotsB, 12);
    System.out.println(planner.length);
    if (planner.length > 0) {
      System.out.println(planner[0]);
      System.out.println(planner[1]);
    }
  }

}