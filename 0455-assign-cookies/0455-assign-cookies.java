class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Step 1: Sort both arrays to enable greedy matching
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0;  // Pointer for children
        int cookie = 0; // Pointer for cookies
        int count = 0;  // Content children counter
        
        // Step 2: Greedy matching - try to satisfy least greedy first
        while (child < g.length && cookie < s.length) {
            // If current cookie can satisfy current child
            if (s[cookie] >= g[child]) {
                count++;      // Child is content
                child++;      // Move to next child
            }
            cookie++;         // Move to next cookie (whether used or not)
        }
        
        return count;
    }
}