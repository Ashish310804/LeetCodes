import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int numWords = words.length;
        int wordLen = words[0].length();
        int totalLen = numWords * wordLen;
        int sLen = s.length();

        if (sLen < totalLen) {
            return result;
        }

        // Build word frequency map
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Iterate through all possible starting offsets
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> seenWords = new HashMap<>();
            int count = 0;

            while (right + wordLen <= sLen) {
                // Get the word at the right end of the window
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;

                    // If the word count exceeds expected, shrink window from left
                    while (seenWords.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Found a valid substring containing all concatenated words
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Invalid word encountered: reset window and counts
                    seenWords.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}