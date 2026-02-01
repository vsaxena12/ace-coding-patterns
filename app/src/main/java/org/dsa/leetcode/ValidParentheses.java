package org.dsa.leetcode;

import org.patterns.twoPointers.ValidPalindrome;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        boolean isContains = s.contains("()");
//        System.out.println(isContains);
//
//        isContains = s.contains("{}");
//        System.out.println(isContains);
//
//        isContains = s.contains("[]");
//        System.out.println(isContains);
//
//        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
//            s = s.replace("()", "");
//            s = s.replace("{}", "");
//            s = s.replace("[]", "");
//        }
//        return s.isEmpty();
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(char c: s.toCharArray()) {
            if(map.containsKey(c) && !stack.isEmpty() && map.get(c) == stack.peek()) {
                stack.pop();
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        ValidParentheses stack = new ValidParentheses();
        boolean isValid = stack.isValid("[]");
        System.out.println(isValid);

        isValid = stack.isValid("([{}])");
        System.out.println(isValid);

        isValid = stack.isValid("[(])");
        System.out.println(isValid);
    }
}
