package com.leetcode.amazon.medium;

public class TheMaze_490 {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            return dfs(start, destination, maze, visited);

        }

        private boolean dfs(int[] start, int[] destination, int[][] maze, boolean[][] visited){

            if(visited[start[0]][start[1]]){
                return false;
            }

            if(destination[0] == start[0] && destination[1] == start[1]) {
                return true;
            }

            visited[start[0]][start[1]] = true;

            //right manipulation
            int r = start[1] + 1;
            int l = start[1] - 1;
            int d = start[0] + 1;
            int u = start[0] - 1;
            while(r < maze[0].length && maze[start[0]][r] == 0){
                r++;
            }
            if(dfs(new int[]{start[0],r-1}, destination, maze, visited)){
                return true;
            }


            while(l >= 0 && maze[start[0]][l] == 0){
                l--;
            }
            if(dfs( new int[]{start[0],l+1}, destination, maze, visited)){
                return true;
            }


            while(d < maze.length && maze[d][start[1]] == 0) {
                d++;
            }
            if(dfs(new int[]{d-1,start[1]}, destination, maze, visited)){
                return true;
            }


            while(u >= 0 && maze[u][start[1]] == 0) {
                u--;
            }
            if(dfs(new int[]{u+1,start[1]}, destination, maze, visited)){
                return true;
            }

            return false;
        }

    }
