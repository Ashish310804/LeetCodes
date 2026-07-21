class Solution {
    public int missingNumber(int[] nums) {
        int xorAll = 0;
        int n = nums.length;
        
        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xorAll ^= i;
        }
        
        // XOR all array elements
        for (int num : nums) {
            xorAll ^= num;
        }
        
        // Result is the missing number (others cancel out)
        return xorAll;
    }
}