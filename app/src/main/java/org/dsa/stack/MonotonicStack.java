package org.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {
    public int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>(); // stores indices
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = nums[i];
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        MonotonicStack monotonicStack = new MonotonicStack();

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = monotonicStack.nextGreater(temperatures);

        ans = monotonicStack.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ans));
    }
}
