package org.dsa.hash.map;

class ListNode {
    int key;
    int val;
    ListNode next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

public class MyHashMap {
    private ListNode[] list;
    private int hash;

    public MyHashMap() {
        this.list = new ListNode[10000];
        for(int i=0; i<list.length; i++) {
            this.list[i] = new ListNode(-1,-1);
        }
    }

    public void add(int key, int val) {
        hash = key%list.length;
        ListNode curr = list[hash];

        while(curr.next != null) {
            if(curr.next.key == key) {
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, val);
    }

    public void remove(int key) {
        hash = key%list.length;
        ListNode curr = list[hash];

        while(curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        hash = key%list.length;
        ListNode curr = list[hash];

        while(curr.next != null) {
            if (curr.next.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void print() {
        for(int i=0; i<10; i++) {
            ListNode curr = list[i];
            while(curr != null) {
                System.out.print(curr.key+" ");
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.add(1,1);
        map.add(11,3);
        map.add(21,5);
        map.add(31,4);
        map.add(41,7);
        map.print();

        System.out.println(map.contains(21));
        map.remove(31);
        map.print();


    }
}
