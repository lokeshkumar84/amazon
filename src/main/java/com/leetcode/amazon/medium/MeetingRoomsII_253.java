package com.leetcode.amazon.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        queue.offer(intervals[0]);

        for(int i=1; i<intervals.length; i++){
            int[] earlier = queue.poll();
            int[] current = intervals[i];

            if(earlier[1] <= current[0]){
                earlier[1] = current[1];
            }else{
                queue.add(current);
            }
            queue.add(earlier);
        }

        return queue.size();

    }
}


/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 */
