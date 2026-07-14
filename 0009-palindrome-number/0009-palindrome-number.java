class Solution {
    public boolean isPalindrome(int x) {
        // Handle edge cases
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        
        // Build the reversed second half
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        // Odd digits: compare reversedHalf/10 with x
        // Even digits: compare reversedHalf with x
        return x == reversedHalf || x == reversedHalf / 10;
    }
}