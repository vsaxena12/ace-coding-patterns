package org.dsa.iterator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IteratorClass {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,5,6);
        Iterator<Integer> iterator = list.iterator();
    }
}
