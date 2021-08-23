package com.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        List<int[]> output = new ArrayList<>();
        int[] earlier = intervals[0];

        for(int i=1;i<intervals.length;i++){
            int[] current = intervals[i];

            if(current[0] <= earlier[1]){
                earlier[1] = Math.max(earlier[1],current[1]);
            }else{
                output.add(earlier);
                earlier = current;
            }
        }
        output.add(earlier);

        return output.toArray(new int[output.size()][]);
    }
}

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */