package org.dsa.hash.sets;

class ListNode {
    int data;
    ListNode next;
    public ListNode(int val) {
        this.data = val;
        this.next = null;
    }
}

public class MyHashSet {
    private ListNode[] list;
    private int hash;

    public MyHashSet() {
        this.list = new ListNode[10000];
        for(int i=0; i<list.length; i++) {
            this.list[i] = new ListNode(-1);
        }
    }

    public void add(int key) {
        hash = key%list.length;
        ListNode curr = list[hash];

        while(curr.next != null) {
            if(curr.next.data == key) {
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key);
    }

    public void remove(int key) {
        hash = key%list.length;
        ListNode curr = list[hash];

        while(curr.next != null) {
            if (curr.next.data == key) {
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
            if (curr.next.data == key) {
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
                System.out.print(curr.data+" ");
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(11);
        set.add(21);
        set.add(31);
        set.add(41);
        set.print();

        System.out.println(set.contains(21));
        set.remove(31);
        set.print();


    }
}
