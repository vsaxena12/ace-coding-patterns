package org.dsa.hash.sets;

import java.util.HashSet;
import java.util.Set;

public class LearnHashSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        boolean x = set.add(1);
        boolean y = set.add(1);

        System.out.println(x+" "+y);

        Set<Integer> set2 = HashSet.newHashSet(4);
    }
}
