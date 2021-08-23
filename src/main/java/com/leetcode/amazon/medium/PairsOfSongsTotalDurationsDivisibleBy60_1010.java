package com.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsTotalDurationsDivisibleBy60_1010 {

    public int numPairsDivisibleBy60_array(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }


    public int numPairsDivisibleBy60(int[] time) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int t:time) {
            if(t%60 == 0){
                count += map.getOrDefault(0,0);
            }
            else{
                count += map.getOrDefault(60 - t%60,0);
            }
            map.put(t%60, map.getOrDefault(t%60,0) + 1);
        }
        return count;
    }
}
