package org.dsa.linkedList.singlyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList {
    public ListNode head;
    private int size;

    public SinglyLinkedList() {
       this.head = null;
       this.size = 0;
    }

    public void insertAtHead(int value) {
        ListNode node = new ListNode(value);
        if(head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void insertAtTail(int value) {
        ListNode node = new ListNode(value);
        if(head == null) {
            head = node;
        } else {
            ListNode temp = head;

            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    public void makeListCyclic() {
        ListNode temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head.next.next;

    }

    public void insertAtIndex(int index, int value) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            insertAtHead(value);
        } else {
            ListNode node = new ListNode(value);
            ListNode temp = head;
            ListNode prev = null;
            int counter = 0;
            while(temp != null) {
                if(index == counter) {
                    prev.next = node;
                    node.next = temp;
                    size++;
                    return;
                }
                prev = temp;
                temp = temp.next;
                counter++;
            }
            assert prev != null;
            prev.next = node;
        }
        size++;
    }

    public void removeAtHead() {
        if(head == null){
            throw new RuntimeException("HEAD IS EMPTY");
        }
        // int value = head.data;
        head = head.next;
        size--;
    }

    public void removeAtTail() {
        if(head == null){
            throw new RuntimeException("HEAD IS EMPTY");
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        if(prev != null) {
            prev.next = null;
            size--;
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(head == null){
            throw new RuntimeException("HEAD IS EMPTY");
        }
        int currentIndex = 0;
        if(index == 0) {
            removeAtHead();
            return;
        }

        ListNode temp = head;
        int i = 0;
        while(i<index-1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void deleteByValue(int value) {

        // Replace this placeholder return statement with your code
        if(head == null) {
            throw new IllegalArgumentException("head cannot be null");
        }

        ListNode temp = head;
        while(temp.next != null) {
            if(temp.next.data == value) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }

    }


    public void getSize(){
        System.out.println("Current Size: "+size);
    }

    public int getLength() {
        int counter = 0;
        ListNode temp = head;
        while(temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

//    Uses Time complexity O(n) and Space Complexity O(n)
//    public void reverse() {
//        ListNode temp = head;
//        ListNode newHead = null;
//        int counter = 0;
//        while(temp != null) {
//            ListNode node = new ListNode(temp.data);
//            if(newHead == null) {
//                newHead = node;
//            } else {
//                node.next = newHead;
//                newHead = node;
//            }
//            temp = temp.next;
//            counter++;
//        }
//        head = newHead;
//        size = counter;
//    }

    public void reverse() {
        ListNode temp = head;
        ListNode prev = null;
        ListNode newNode = null;
        while(temp != null) {
            newNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = newNode;
        }
        head = prev;

    }

    public boolean detectCycle() {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next; //the p1 pointer will jump 1 step
            p2 = p2.next.next; //the p2 pointer will jump 2 steps
            // when the pointers become equal then there must be a loop
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public void printLinkedList() {
        ListNode temp = head;

        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.getSize();
        list.insertAtHead(10);
        list.printLinkedList();
        list.getSize();

        list.insertAtHead(5);
        list.printLinkedList();
        list.getSize();

        list.insertAtTail(15);
        list.printLinkedList();
        list.getSize();

        list.insertAtIndex(1, 3);
        list.printLinkedList();
        list.getSize();

        list.insertAtIndex(1, 4);
        list.printLinkedList();
        list.getSize();

        list.insertAtIndex(5, 20);
        list.printLinkedList();
        list.getSize();

        list.removeAtHead();
        list.printLinkedList();
        list.getSize();

        list.removeAtTail();
        list.printLinkedList();
        list.getSize();

        list.removeAtTail();
        list.printLinkedList();
        list.getSize();

        list.insertAtTail(15);
        list.printLinkedList();
        list.getSize();

        list.insertAtTail(20);
        list.printLinkedList();
        list.getSize();


        list.removeAtIndex(1);
        list.printLinkedList();
        list.getSize();

        list.deleteByValue(10);
        list.printLinkedList();
        list.getSize();

        list.deleteByValue(20);
        list.printLinkedList();
        list.getSize();

        System.out.println("Length of the list: "+ list.getLength());

        list.reverse();
        list.printLinkedList();
        list.getSize();

        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);
        list.makeListCyclic();
        boolean result = list.detectCycle();
        System.out.println("Is the node cyclic?: "+ result);

        //list.printLinkedList();
        //list.getSize();
    }
}
