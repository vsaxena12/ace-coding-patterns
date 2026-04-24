package org.dsa.arrays;

public class MaximumSumCircularSubarray {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int res = nums[0];

        for (int i = 0; i < n; i++) {
            int curSum = 0;
            for (int j = i; j < i + n; j++) {
                System.out.println(i+" "+j);
                System.out.println(j%n);
                curSum += nums[j % n];
                res = Math.max(res, curSum);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-2,4,-5,4,-5,9,4};
        int n = nums.length;
        int i = 0;
        int result1 = nums[(i+1) % n];
        System.out.println("RESULT: "+result1+"; n is: "+n);
        result1 = nums[(i-1+n) % n];
        System.out.println("RESULT: "+result1+"; n is: "+n);

        int res = maxSubarraySumCircular(nums);
        System.out.println(res);
    }
}
