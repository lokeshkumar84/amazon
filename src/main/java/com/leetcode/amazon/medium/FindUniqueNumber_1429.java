package com.leetcode.amazon.medium;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindUniqueNumber_1429 {

        Set<Integer> total = new HashSet<>();
        Set<Integer> unique = new LinkedHashSet<>();
        public FindUniqueNumber_1429(int[] nums) {
            for(int i:nums){
                addToSet(i);
            }
        }

        public int showFirstUnique() {
            return unique.isEmpty()?-1:unique.iterator().next();
        }

        public void add(int value) {
            addToSet(value);
        }

        private void addToSet(int num){
            if(total.add(num)){
                unique.add(num);
            }else{
                unique.remove(num);
            }
        }
    }

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
