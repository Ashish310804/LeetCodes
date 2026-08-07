class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";

        String result = "1";

        // Build terms 2 to n
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;

            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    // Append count and digit for the previous group
                    next.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }

            // Append the last group
            next.append(count).append(result.charAt(result.length() - 1));

            result = next.toString();
        }

        return result;
    }
}