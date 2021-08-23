package com.leetcode.amazon.easy;

import java.util.Arrays;

public class MaximumUnitsOnTruck_1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int i = 0;
        int ans = 0;
        while(i < boxTypes.length && truckSize > 0) {
            int[] current = boxTypes[i++];
            if(truckSize - current[0] < 0){
                while(truckSize > 0){
                    ans = ans + current[1];
                    truckSize --;
                }
                break;
            }
            ans = ans + (current[0] * current[1]);//50+10+7+7+7
            truckSize -= current[0];//5,3

        }

        return ans;

    }
}
