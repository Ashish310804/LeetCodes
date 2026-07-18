class Solution {
    public int removeDuplicates(int[] nums) {
        // Handle edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int slow = 0;  // Position of last unique element
        
        // Start fast pointer from index 1
        for (int fast = 1; fast < nums.length; fast++) {
            // When we find a new unique element
            if (nums[fast] != nums[slow]) {
                slow++;           // Move slow forward
                nums[slow] = nums[fast];  // Place unique element
            }
        }
        
        return slow + 1;  // Number of unique elements
    }
}