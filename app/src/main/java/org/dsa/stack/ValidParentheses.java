package org.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(char c: s.toCharArray()) {
            if(map.containsKey(c) && !stack.isEmpty() && map.get(c) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println("Output: "
                +validParentheses.isValid("([{}])"));

    }
}
