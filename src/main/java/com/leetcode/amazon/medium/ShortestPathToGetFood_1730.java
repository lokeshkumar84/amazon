package com.leetcode.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood_1730 {
    class Solution {
        public int getFood(char[][] grid) {

            int m = grid.length;
            int n = grid[0].length;

            int[][] visited = new int[m][n];
            int[][] directions = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

            Queue<int[]> queue = new LinkedList<>();

            queue.offer(findStartingPoint(m, n, grid));
            int step = 0;
            while (!queue.isEmpty()) {

                int size = queue.size();
                for (int i = 0; i < size; i++) {

                    int[] point = queue.poll();
                    if (grid[point[0]][point[1]] == '#') {
                        return step;
                    }

                    for (int[] direction : directions) {
                        int x = point[0] + direction[0];
                        int y = point[1] + direction[1];

                        if (validateEdge(x, y, m, n, grid) && visited[x][y] == 0) {
                            visited[x][y] = 1;
                            queue.offer(new int[]{x, y});
                        }

                    }


                }


                step++;
            }
            return -1;
        }

        private boolean validateEdge(int x, int y, int m, int n, char[][] grid) {
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 'X') {
                return true;
            }
            return false;
        }

        private int[] findStartingPoint(int m, int n, char[][] grid) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (grid[i][j] == '*') {
                        return new int[]{i, j};
                    }

                }
            }
            return new int[]{};
        }
    }
}

/*
You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.

You are given an m x n character matrix, grid, of these different types of cells:

'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.



Example 1:


Input: grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
Output: 3
Explanation: It takes 3 steps to reach the food.
Example 2:


Input: grid = [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X"],["X","X","X","X","X"]]
Output: -1
Explanation: It is not possible to reach the food.
Example 3:


Input: grid = [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O","X"],["X","O","O","X","O","O","X","X"],["X","O","O","O","O","#","O","X"],["X","X","X","X","X","X","X","X"]]
Output: 6
Explanation: There can be multiple food cells. It only takes 6 steps to reach the bottom food.
Example 4:

Input: grid = [["O","*"],["#","O"]]
Output: 2
Example 5:

Input: grid = [["X","*"],["#","X"]]
Output: -1


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[row][col] is '*', 'X', 'O', or '#'.
The grid contains exactly one '*'.
 */
