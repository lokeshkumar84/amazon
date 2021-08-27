package com.leetcode.amazon.easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        Arrays.stream(sortArray(new int[]{1,2,3},new int[]{2,7,8,9})).forEach(System.out::println);

    }

    private static int[] sortArray(int[] one, int[] two) {

        int i =0, j = 0,index = 0;
        int[] result = new int[one.length+two.length];

        while(i < one.length && j < two.length) {
            if(one[i] < two[j]){
                result[index++] = one[i++];
            } else{
                result[index++] = two[j++];
            }
        }
        if(i < one.length){
            add(result, one, index, i);
        }
        if(j < two.length){
            add(result, two, index, j);
        }
        return result;
    }
    private static void add(int[] result, int[] array, int resultIndex, int arrayIndex){
        while(arrayIndex < array.length){
            result[resultIndex++] = array[arrayIndex++];
        }
    }
}
