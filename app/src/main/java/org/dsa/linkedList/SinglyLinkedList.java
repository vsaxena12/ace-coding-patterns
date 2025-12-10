package org.dsa.linkedList;

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


    public void getSize(){
        System.out.println("Current Size: "+size);
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
    }
}
