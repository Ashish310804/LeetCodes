public class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine sign of the result
        boolean positive = (dividend < 0) == (divisor < 0);
        
        // Convert to positive longs to handle MIN_VALUE safely
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        
        int result = 0;
        while (a >= b) {
            long temp = b, multiple = 1;
            // Subtract larger chunks using bitwise operations
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }
        
        return positive ? result : -result;
    }
}