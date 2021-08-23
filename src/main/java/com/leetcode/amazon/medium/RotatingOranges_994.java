package com.leetcode.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RotatingOranges_994 {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {

                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }

            }
        }

        int[][] directions = new int[][]{{1,0},{0,-1}, {-1,0}, {0,1}};
        int minute = 0;
        if(fresh == 0) {
            return 0;
        }
        while(!queue.isEmpty()) {

            minute++;
            int size = queue.size();

            for(int i=0; i<size ;i++){

                int[] point = queue.poll();
                for(int[] direction: directions){

                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];

                    if(x < 0 || y < 0 || x > grid.length -1 || y > grid[0].length -1 ||
                            grid[x][y] == 0 || grid[x][y] == 2 ) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x,y});
                    fresh--;
                }
            }
        }

        return (fresh == 0)?minute-1:-1;
    }
}
