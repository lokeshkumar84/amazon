package com.leetcode.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_1091 {
        public int shortestPathBinaryMatrix(int[][] grid) {

            if(grid[0][0] == 1){
                return -1;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0,1});

            grid[0][0] = 1;

            int[][] directions = new int[][]{ {1,0} , {1,-1}, {0,-1}, {-1,-1}, {-1,0} , {-1,1}, {0,1}, {1,1} };

            while(!queue.isEmpty()) {

                int size = queue.size();
                for(int i=0;i<size;i++){

                    int[] point = queue.poll();
                    if(point[0] == grid.length-1 && point[1] == grid[0].length-1) {
                        return point[2];
                    }

                    for(int[] direction:directions){
                        int x = point[0] + direction[0];
                        int y = point[1] + direction[1];

                        if(x < 0 || x > grid.length -1 || y < 0 || y > grid[0].length -1 || grid[x][y] == 1){
                            continue;
                        }
                        queue.offer(new int[]{x,y,point[2]+1});
                        grid[x][y] = 1;
                    }


                }

            }

            return -1;


        }
    }
