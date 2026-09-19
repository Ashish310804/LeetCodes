class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        boolean digitAfterExponent = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Digit
            if (Character.isDigit(c)) {
                seenDigit = true;

                if (seenExponent) {
                    digitAfterExponent = true;
                }
            }

            // Decimal point
            else if (c == '.') {
                // Dot is not allowed after exponent
                if (seenDot || seenExponent) {
                    return false;
                }

                seenDot = true;
            }

            // Exponent
            else if (c == 'e' || c == 'E') {
                // Exponent can occur only once
                // and must have a digit before it
                if (seenExponent || !seenDigit) {
                    return false;
                }

                seenExponent = true;
                digitAfterExponent = false;
            }

            // Sign
            else if (c == '+' || c == '-') {
                // Sign is valid only at the beginning
                // or immediately after e/E
                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Anything else
            else {
                return false;
            }
        }

        // Number must contain a digit
        // and exponent (if present) must contain a digit
        return seenDigit && digitAfterExponent;
    }
}