package org.dsa.leetcode;

import java.util.Arrays;
import java.util.List;

public class ScoreOfAString {
    public int scoreOfString(String s) {
        if(s.length() < 2 || s.length() >100) {
            return -1;
        }
        int counter = 0;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i-1) > 127 || s.charAt(i) > 127) {
                return -1;
            }
            char c1 = s.charAt(i-1);
            char c2 = s.charAt(i);

            counter = counter + Math.abs(c1 - c2);
        }
        return counter;
    }

    public static void main(String[] args) {
        ScoreOfAString scoreOfAString = new ScoreOfAString();
        List<String> list = Arrays.asList("hello", "world", "char", "code");
        for(String s: list) {
            int val = scoreOfAString.scoreOfString(s);
            System.out.println("Output: "+val);
        }

    }
}
