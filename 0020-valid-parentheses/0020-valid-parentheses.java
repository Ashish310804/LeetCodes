import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Map for bracket matching
        java.util.Map<Character, Character> map = new java.util.HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Push opening brackets onto stack
                stack.push(c);
            } else {
                // For closing brackets
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        
        // Valid if all brackets are matched
        return stack.isEmpty();
    }
}