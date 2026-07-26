class Solution {
    public int maximumProduct(int[] nums) {
        // Initialize tracking variables
        int max1 = Integer.MIN_VALUE;   // largest
        int max2 = Integer.MIN_VALUE;   // second largest
        int max3 = Integer.MIN_VALUE;   // third largest
        
        int min1 = Integer.MAX_VALUE;   // smallest
        int min2 = Integer.MAX_VALUE;   // second smallest
        
        // Single pass through array
        for (int num : nums) {
            // Update maximums
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            
            // Update minimums
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        
        // Two cases: all positive vs two negatives + one positive
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}