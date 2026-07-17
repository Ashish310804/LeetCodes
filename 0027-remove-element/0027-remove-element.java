class Solution {
    public int removeElement(int[] nums, int val) {
        // Pointer to track position of next valid element
        int k = 0;
        
        // Iterate through all elements
        for (int i = 0; i < nums.length; i++) {
            // If current element is not equal to val, keep it
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k;
    }
}