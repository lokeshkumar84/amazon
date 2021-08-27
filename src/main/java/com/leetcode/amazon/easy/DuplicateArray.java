package com.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateArray {

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,3};
        Set<Integer> set = new HashSet<>();
        for(int a:array){
            if(set.contains(a)){
                System.out.println(a);
            }
            set.add(a);
        }

        Arrays.sort(array);
        for(int i=0;i<array.length-1;i++){
            if(array[i] == array[i+1]){
                System.out.println(array[i]);
            }
        }

    }
}
