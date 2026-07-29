class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int i = 0;
        int n = s.length();
        
        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Handle empty string after whitespace
        if (i == n) return 0;
        
        // Step 3: Determine sign
        int sign = 1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Step 4: Read digits and check overflow
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Check for overflow BEFORE multiplying
            if (sign == 1 && result > (Integer.MAX_VALUE - digit) / 10) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < (Integer.MIN_VALUE + digit) / 10) {
                return Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}