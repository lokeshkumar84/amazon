package com.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderDatainLogFiles_937 {
    public static void main(String[] args) {
        String[] str = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        System.out.println(reorderLogFiles(str));
    }

    public static String[] reorderLogFiles(String[] logs) {

        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for(int i=0;i<logs.length;i++){

            if(! Character.isDigit(logs[i].split(" ")[1].charAt(0))){
                letters.add(logs[i]);
            } else{
                digits.add(logs[i]);
            }
        }

        Collections.sort(letters,(a,b) -> {

            int index = a.indexOf(" ");
            String a_id = a.substring(0,index);
            String a_letter = a.substring(index+1,a.length());

            index = b.indexOf(" ");
            String b_id = b.substring(0,index);
            String b_letter = b.substring(index+1,b.length());

            if(a_letter.compareTo(b_letter) == 0){
                return a_id.compareTo(b_id);
            }else if(a_letter.compareTo(b_letter) < 0){
                return -1;
            }else {
                return 1;
            }
        });
        digits.forEach(letters::add);
        return letters.toArray(new String[letters.size()]);


    }
}
