package org.dsa.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixSum {
    private final int[] array;

    public PrefixSum(int[] nums) {
        this.array = new int[nums.length+1];
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            array[i+1] = sum;
        }
        System.out.println(Arrays.toString(array));
    }

    public int sumRange(int left, int right) {
        int r = array[right+1];
        int l = array[left];
        return r-l;
    }

    public static void main(String[] args) {
        PrefixSum sum = new PrefixSum(new int[]{-2,0,3,-5,2,-1});

        int sumRange = sum.sumRange(0,2);
        System.out.println(sumRange);

        sumRange = sum.sumRange(2,5);
        System.out.println(sumRange);
    }


}
