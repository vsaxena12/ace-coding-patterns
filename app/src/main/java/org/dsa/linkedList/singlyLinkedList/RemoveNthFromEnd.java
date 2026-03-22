package org.dsa.linkedList.singlyLinkedList;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        int index = counter - n;

        ListNode curr = head;

        int c = 0;
        while(curr != null) {
            if(c == index-1) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            c++;
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();

        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);

        list.printLinkedList();

        int n = 2;
        removeNthFromEnd.removeNthFromEnd(list.head, n);
        list.printLinkedList();
    }
}
