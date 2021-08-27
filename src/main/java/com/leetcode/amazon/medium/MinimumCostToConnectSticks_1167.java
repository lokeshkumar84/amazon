package com.leetcode.amazon.medium;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks_1167 {
        public int connectSticks(int[] sticks) {

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for(int i:sticks){
                queue.offer(i);
            }


            int totalSum = 0;

            while(queue.size() > 1){
                int stick1 = queue.poll();
                int stick2 = queue.poll();

                int cost = stick1 + stick2;
                totalSum += cost;

                queue.offer(cost);

            }

            return totalSum;

        }
    }
