import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Sorting helps us stop early when candidate > remaining target
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] candidates,
            int remaining,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Target reached
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Since array is sorted, no later candidate can work
            if (candidates[i] > remaining) {
                break;
            }

            // Choose candidate
            current.add(candidates[i]);

            // i, NOT i + 1:
            // This allows the same number to be selected unlimited times.
            backtrack(
                candidates,
                remaining - candidates[i],
                i,
                current,
                result
            );

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}