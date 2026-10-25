
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        // Check if n is a power of 2
        if ((n & (n - 1)) != 0) {
            return false;
        }

        // Check if the set bit is at an odd position (0-indexed)
        return (n & 0x55555555) != 0;
    }
}
