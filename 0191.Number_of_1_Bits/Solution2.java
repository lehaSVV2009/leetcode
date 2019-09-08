public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // bit operation
        // 11 -> 00000000000000000000000000001011
        int count = 0;
        
        int mask = 1;
        for (int i = 0; i < 32; ++i) {
            if ((n & mask) != 0) {
                count++;
            }
            
            mask <<= 1;
        }
        
        return count;
    }
}