public class Solution {
    public int pow(int x, int n, int d) {
        // x - 0? always 0
        // x - negative? (-27 ^ 1) % 5 == 3
        // x - Int.MAX? working ((2147483647 ^ 3) % 24 == 7)
        // n - 0? 1
        // n - negative? EXCEPTION
        // n - Int.MAX? working
        // d - 0? Exception
        // d - negative? AAA! (27 ^ 1) % (-5) == 2. (-27 ^ 1) % (-5) == -2
        // d - Int.MAX/Int.MIN? ok. If greater than x => value is x
        // AAAA!!! (-27) % 2147483647 == 2147483620

        // Remainder is from different system!!! Always positive
        // NOT -27 = -5 x 5 + (-2)
        // BUT -27 = -5 X 5 + (-2)
        // => -27 % 5 = 3
        // BUT NOT -27 % 5 = -2

        // Actually, same as (-27 % 5) + 5

        // Solution 1. naive.
        // Math.pow(x, n) % d

        // Solution 2
        // Feeling of simplifying formula
        // (5^3) % 4 = 25 % 4 = 1
        // (5%4) * (5%4) * (5%4) = 1
        // 3^3 % 5 = 2
        // (3%5) * (3%5)* (3%5) = 3 * 3 * 3 = 27 FAILED...

        // Solution 3
        // Thinking only about number of digits in d
        // 
        
        // Solution 4
        // vice versa
        // 27 % 5 means

        // 30 / 5 = 6
        // 29 / 5 = 5
        // 28 / 5 = 5
        // 27 / 5 = 5
        // 26 / 5 = 5
        // 25 / 5 = 5
        // 24 / 5 = 4
        // remainder is 30 - 27 = 3

        // 3
        // binary search
        // 27
        // (71045970 ^ 41535484) % 64735492 problem
        //

        /**
         *  long res = 1;
         *  long a=x; // 1. 3
            int b=n; // 1. 4
            a = a % d;  // 1. 3 % 5 = 3
            while (b> 0){ 
                if((b & 1)==1){ 
                    res = (res * a) % d; // 3. (1 * 1) % 5
                }
                // 1. 2
                // 2. 1
                b = b >> 1;
                // 1. (3 * 3) % 5 = 2
                // 2. (2 * 2) % 5 = 1
                a = (a * a) % d;
            } 
         */
        // 3^4 = 81 % 5 == 1
        
        // 3, 4, 5
        // 
        // Finally!
        // ab mod c = [(a mod c)*(b mod c)]mod c
        // (3^2) % 5 = 4
        // ((3 % 5) * (3 % 5)) % 5 = (3 * 3) % 5 = 9 % 5;
        // 5^2 % 7 = 4
        // ((5 % 7) * (5 % 7)) % 7 = (2 * 2) % 7

        // (a*b*c) mod z = (((a mod z)*(b mod z)*(c mod z)) mod z)        
        // (3^3) % 5 = 2 = (3%5 * 3%5 * 3%5) %5 = 3*3*3 %5 = 27 % 5 = 2
        // (3^4) % 5 = 1 = (3%5 * 3%5 * 3%5 * 3%5) %5 = 81 % 5
        // (3^4) % 5 = 1 = ((3 * 3) % 5 * (3 * 3) % 5) % 5 = ((9 % 5) * (9 % 5)) % 5 = 1
        // (3^4) % 5 = 1 = (((3%5 * 3%5) % 5) * ((3%5 * 3%5) % 5))) % 5 = (4 * 4) % 5 = 1
        if (x == 0 && n == 0) {
            return d != 1 ? 1 : 0;
        }
        if (x == 0) {
            return 0;
        }
        
        boolean negative = false;
        if (x < 0) {
            x = Math.abs(x);
            if (n % 2 != 0) {
                negative = true;
            }
        }

        long result = 1;
        long base = x % d;

        while (n > 0) {
            // n is odd
            if ((n & 1) == 1) {
                result = (result * base) % d;
            }

            n = n / 2;
            base = (base * base) % d;
        }

        return negative ? d - (int) result : (int) result;
    }
}
