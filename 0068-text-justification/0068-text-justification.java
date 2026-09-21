import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            int j = i;
            int totalWordsLength = 0;

            // Find words that can fit in this line
            while (j < words.length) {

                int requiredLength = totalWordsLength
                        + words[j].length()
                        + (j - i); // spaces between words

                if (requiredLength > maxWidth) {
                    break;
                }

                totalWordsLength += words[j].length();
                j++;
            }

            int wordCount = j - i;
            int totalSpaces = maxWidth - totalWordsLength;

            StringBuilder line = new StringBuilder();

            // Last line OR only one word
            if (j == words.length || wordCount == 1) {

                for (int k = i; k < j; k++) {

                    if (k > i) {
                        line.append(" ");
                    }

                    line.append(words[k]);
                }

                // Left justify: remaining spaces go at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                // Fully justified line
                int gaps = wordCount - 1;

                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int spaces = spacesPerGap;

                        // Left gaps get the extra spaces
                        if (k - i < extraSpaces) {
                            spaces++;
                        }

                        for (int x = 0; x < spaces; x++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());

            i = j;
        }

        return result;
    }
}