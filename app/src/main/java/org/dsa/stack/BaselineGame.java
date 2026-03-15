package org.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaselineGame {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                int a = stack.pop();
                int b = (!stack.isEmpty()) ? stack.peek() : 0;
                stack.push(a);
                stack.push(a + b);
            } else if (operations[i].equals("C")) {
                stack.pop();
            } else if (operations[i].equals("D")) {
                if (!stack.isEmpty())
                    stack.push(stack.peek() * 2);
            } else {
                stack.push(Integer.valueOf(operations[i]));
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        BaselineGame baselineGame = new BaselineGame();
        System.out.println("Output: "
                +baselineGame.calPoints(new String[]{"1","2","+","C","5","D"}));

    }
}
