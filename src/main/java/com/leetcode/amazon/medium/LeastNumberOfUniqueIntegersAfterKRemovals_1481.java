package com.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals_1481 {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {

            Map<Integer,Integer> map = new HashMap<>();

            for(int a:arr){
                map.put(a,map.getOrDefault(a,0)+1);
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

            for(int i:map.keySet()){
                queue.offer(i);
            }

            while(k-- > 0){
                int ele = queue.poll();
                map.put(ele, map.get(ele) -1);
                queue.offer(ele);
                if(map.get(queue.peek()) <= 0){
                    queue.poll();
                }
            }


            return queue.size();
        }
    }
