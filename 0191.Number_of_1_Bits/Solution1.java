public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // bit operation
        // 11 -> 00000000000000000000000000001011

        String binaryString = Integer.toBinaryString(n);
        return (int) binaryString.chars().filter(ch -> ch == '1').count();
    }
}