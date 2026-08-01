class Solution {
    // Mapping of digits to letters (like phone buttons)
    private static final String[] PHONE_MAP = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    
    private List<String> result;
    
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        
        // Edge case: empty input
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        backtrack(digits, 0, new StringBuilder());
        return result;
    }
    
    // Backtracking function
    private void backtrack(String digits, int index, StringBuilder current) {
        // Base case: if we've processed all digits, add to result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get letters for current digit
        int digit = digits.charAt(index) - '0';
        String letters = PHONE_MAP[digit];
        
        // Try each letter and recurse
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));           // Make choice
            backtrack(digits, index + 1, current);       // Move to next digit
            current.deleteCharAt(current.length() - 1);  // Backtrack
        }
    }
}