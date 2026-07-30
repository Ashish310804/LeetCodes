class Solution {
    public int lengthOfLastWord(String s) {
        // Skip trailing spaces by iterating backwards
        int i = s.length() - 1;
        
        // Step 1: Skip all trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        // Step 2: Count characters until we hit a space or beginning
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }
}