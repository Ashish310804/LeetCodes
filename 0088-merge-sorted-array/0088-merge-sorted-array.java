public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Three pointers
        int p1 = m - 1;           // Last element in nums1's valid part
        int p2 = n - 1;           // Last element in nums2
        int p = m + n - 1;        // Last position in nums1
        
        // Compare from the back and place larger element first
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        
        // If nums2 still has elements left, copy them
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }
}