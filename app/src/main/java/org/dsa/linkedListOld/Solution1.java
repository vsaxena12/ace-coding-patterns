package org.dsa.linkedListOld;

public class Solution1 {
    public static LinkedListNode<Integer> insertAtTail(LinkedListNode <Integer> head, int value) {

        // Three things
        // Head node
        // New node
        // Temp node to traverse
        LinkedListNode<Integer> newNode = new LinkedListNode<>(value);
        if(head == null) {
            head = newNode;
        } else {
            LinkedListNode<Integer> temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }
}
