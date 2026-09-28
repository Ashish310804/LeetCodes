import java.util.*;

class Solution {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;

        // result[mouse][cat][turn]
        // 0 = draw/unknown
        // 1 = mouse wins
        // 2 = cat wins
        int[][][] result = new int[n][n][2];

        // degree[mouse][cat][turn]
        int[][][] degree = new int[n][n][2];

        // Calculate number of available moves for every state
        for (int mouse = 0; mouse < n; mouse++) {
            for (int cat = 0; cat < n; cat++) {
                degree[mouse][cat][0] = graph[mouse].length;

                // Cat cannot move to node 0
                int catMoves = 0;
                for (int next : graph[cat]) {
                    if (next != 0) {
                        catMoves++;
                    }
                }

                degree[mouse][cat][1] = catMoves;
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        // Mouse reaches the hole -> Mouse wins
        for (int cat = 1; cat < n; cat++) {
            result[0][cat][0] = 1;
            result[0][cat][1] = 1;

            queue.offer(new int[]{0, cat, 0});
            queue.offer(new int[]{0, cat, 1});
        }

        // Mouse and Cat meet -> Cat wins
        for (int pos = 1; pos < n; pos++) {
            result[pos][pos][0] = 2;
            result[pos][pos][1] = 2;

            queue.offer(new int[]{pos, pos, 0});
            queue.offer(new int[]{pos, pos, 1});
        }

        // Process known winning states
        while (!queue.isEmpty()) {
            int[] state = queue.poll();

            int mouse = state[0];
            int cat = state[1];
            int turn = state[2];

            int winner = result[mouse][cat][turn];

            // Find previous states that can move to this state
            if (turn == 0) {
                // Current turn is Mouse.
                // Previous turn was Cat.
                for (int prevCat : graph[cat]) {
                    if (prevCat == 0) {
                        continue;
                    }

                    int prevTurn = 1;

                    if (result[mouse][prevCat][prevTurn] != 0) {
                        continue;
                    }

                    // Cat can choose this move and get the winner
                    if (winner == 2) {
                        result[mouse][prevCat][prevTurn] = 2;
                        queue.offer(new int[]{
                            mouse, prevCat, prevTurn
                        });
                    } else {
                        degree[mouse][prevCat][prevTurn]--;

                        if (degree[mouse][prevCat][prevTurn] == 0) {
                            result[mouse][prevCat][prevTurn] = 1;
                            queue.offer(new int[]{
                                mouse, prevCat, prevTurn
                            });
                        }
                    }
                }

            } else {
                // Current turn is Cat.
                // Previous turn was Mouse.
                for (int prevMouse : graph[mouse]) {
                    int prevTurn = 0;

                    if (result[prevMouse][cat][prevTurn] != 0) {
                        continue;
                    }

                    // Mouse can choose this move and get the winner
                    if (winner == 1) {
                        result[prevMouse][cat][prevTurn] = 1;
                        queue.offer(new int[]{
                            prevMouse, cat, prevTurn
                        });
                    } else {
                        degree[prevMouse][cat][prevTurn]--;

                        if (degree[prevMouse][cat][prevTurn] == 0) {
                            result[prevMouse][cat][prevTurn] = 2;
                            queue.offer(new int[]{
                                prevMouse, cat, prevTurn
                            });
                        }
                    }
                }
            }
        }

        return result[1][2][0];
    }
}