import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        // Create mapping for symbol values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int result = 0;
        int n = s.length();
        
        // Traverse through the string
        for (int i = 0; i < n; i++) {
            int currentValue = romanMap.get(s.charAt(i));
            
            // If current value is less than next value, subtract it
            if (i + 1 < n && currentValue < romanMap.get(s.charAt(i + 1))) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }
        
        return result;
    }
}