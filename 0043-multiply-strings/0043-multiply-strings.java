class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is "0", result is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n]; // max possible length of product

        // Multiply each digit of num1 with each digit of num2
        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;
                int p1 = i + j;     // higher position
                int p2 = i + j + 1; // lower position

                int sum = mul + pos[p2];
                pos[p2] = sum % 10;       // current digit
                pos[p1] += sum / 10;      // carry to higher position
            }
        }

        // Convert result array to string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}