package org.dsa.linkedListOld;

public class Solution2 {
    public static LinkedListNode<Integer> insertAt (LinkedListNode <Integer> head, int data, int previous) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(data);

        LinkedListNode<Integer> temp = head;

        while(temp != null && !temp.data.equals(previous)) {
            temp = temp.next;
        }
        if(temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }

        return head;
    }
}
