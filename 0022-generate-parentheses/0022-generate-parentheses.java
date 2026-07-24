class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: when string length reaches 2*n
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // Add '(' if we haven't used all opening parentheses
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        
        // Add ')' only if it won't make the string invalid
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}