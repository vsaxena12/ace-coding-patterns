package org.dsa.linkedList.singlyLinkedList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtTail(0);
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.printLinkedList();

        list.head = reverseLinkedList.reverseList(list.head);
        list.printLinkedList();
    }
}
