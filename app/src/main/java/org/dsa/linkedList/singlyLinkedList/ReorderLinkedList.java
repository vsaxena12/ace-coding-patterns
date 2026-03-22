package org.dsa.linkedList.singlyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        ListNode result = new ListNode(-1);
        ListNode dummy = result;

        while(temp != null) {
            ListNode curr = temp.next;
            temp.next = null;
            list.add(temp);
            temp = curr;
        }

        int i=0;
        int j = list.size()-1;

        while(i<j) {
            list.get(i).next = list.get(j);
            i++;
            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null;
    }

    public static void main(String[] args) {
        ReorderLinkedList reorderLinkedList = new ReorderLinkedList();

        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtTail(0);
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtTail(6);
        list.printLinkedList();

        reorderLinkedList.reorderList(list.head);
        list.printLinkedList();
    }
}
