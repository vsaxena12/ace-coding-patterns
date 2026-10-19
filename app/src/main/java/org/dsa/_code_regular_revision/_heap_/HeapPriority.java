package org.dsa._code_regular_revision._heap_;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HeapPriority {

    List<Integer> list;

    public HeapPriority() {
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int val) {
        list.add(val);
        int i = list.size()-1;

        // Percolate up
        while(i>1 && list.get(i) < list.get(i/2)) {
            int temp = list.get(i);
            list.set(i, list.get(i/2));
            list.set(i/2, temp);
            i = i/2;
        }
    }

    public int pop() {
        if(list.size() == 1) {
            return 0;
        }
        if(list.size() == 2) {
            return list.removeLast();
        }

        int res = list.get(1);
        list.set(1, list.get(list.size()-1));
        list.removeLast();
        int i = 1;

        while(i<list.size()) {
            if(list.get(2*i) < list.get(2*i+1)) {
                int temp = list.get(i);
                list.set(i, list.get(2*i));
                list.set(2*i, temp);
                i = 2*i;
            } else {
                int temp = list.get(i);
                list.set(i, list.get(2*i+1));
                list.set(2*i+1, temp);
                i = 2*i+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        HeapPriority priority = new HeapPriority();
        priority.insert(1);
        priority.insert(3);
        priority.insert(6);
        priority.insert(5);
        priority.insert(9);
        priority.insert(8);
        priority.insert(4);
        System.out.println(priority.list);

        priority.pop();
        System.out.println(priority.list);
    }
}
