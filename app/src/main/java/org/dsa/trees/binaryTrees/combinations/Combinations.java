package org.dsa.trees.binaryTrees.combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // Given n numbers (1 - n), return all possible combinations
    // of size k. (n choose k math problem).
    // Time: O(k * 2^n)
    static int count;
    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        count = 0;
        int val  = helper(1, new ArrayList<>(), combs, n, k);
        System.out.println("Counter: "+count);
        System.out.println("Value: "+val);
        return combs;
    }

    public static int helper2(int i, List<Integer> curComb, List<List<Integer>> combs, int n, int k) {
        if (curComb.size() == k) {
            combs.add(new ArrayList<>(curComb));
            count++;
            return 1;
        }
        if (i > n) {
            return 0;
        }
        // decision to include i
        curComb.add(i);
        int take = helper2(i + 1, curComb, combs, n, k);

        curComb.remove(curComb.size() - 1);
        // decision to NOT include i
        int skip = helper2(i + 1, curComb, combs, n, k);
        return take + skip;
    }

    public static int helper(int i, List<Integer> curComb, List<List<Integer>> combs, int n, int k) {
        int val = 0;
        if(curComb.size() == k){
            combs.add(new ArrayList<>(curComb));
            count++;
            return 1;
        }
        if(i>n) {
            return 0;
        }

        for(int j=i; j<=n; j++) {
            curComb.add(j);
            val = val + helper(j+1, curComb, combs, n, k);
            curComb.remove(curComb.size()-1);

        }
        return val;
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(0, nums, target, curr, list);
        return list;
    }

    private static void helper(int i, int[] nums, int target,
                        List<Integer> curr, List<List<Integer>> list) {
        if(target == 0) {
            list.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || i>=nums.length) {
            return;
        }

        curr.add(nums[i]);
        helper(i, nums, target-nums[i], curr, list);
        curr.remove(curr.size()-1);
        helper(i+1, nums, target, curr, list);

    }

    public static void main(String[] args) {
        List<List<Integer>> list = combinations(4,2);
        System.out.println(list);

        list = combinationSum(new int[]{2,5,6,9}, 9);
        System.out.println(list);

    }
}
