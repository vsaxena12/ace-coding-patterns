package org.dsa.prefixSum;

import java.util.ArrayList;
import java.util.List;

public class PrefixSum {
    private final List<Integer> list;

    public PrefixSum(int[] nums) {
        this.list = new ArrayList<>();
        int total = 0;
        for(int n: nums) {
            total = total + n;
            list.add(total);
        }
        System.out.println(list);
    }

    public int sumRange(int left, int right) {
        int r = this.list.get(right);
        int l = left > 0 ? this.list.get(left-1) : 0;
        return r-l;
    }

    public static void main(String[] args) {
        PrefixSum sum = new PrefixSum(new int[]{2,-1,3,-3,4});

        int sumRange = sum.sumRange(0,2);
        System.out.println(sumRange);
    }


}
