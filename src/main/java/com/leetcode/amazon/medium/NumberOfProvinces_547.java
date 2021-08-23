package com.leetcode.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces_547 {

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i=0; i<isConnected.length; i++){

            if(visited[i] == 0){
                queue.offer(i);
                while(!queue.isEmpty()){

                    int s = queue.poll();
                    visited[s] = 1;
                    for(int j=0;j<isConnected.length;j++){
                        if(isConnected[s][j] == 1 && visited[j] == 0) {
                            queue.offer(j);
                        }
                    }
                }
                count++;
            }

        }
        return count;
    }
}
