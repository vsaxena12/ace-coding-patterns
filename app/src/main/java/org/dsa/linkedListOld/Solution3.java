package org.dsa.linkedListOld;

public class Solution3 {

    public static boolean searchNode(LinkedListNode <Integer> head, int value) {

        // Replace this placeholder return statement with your code
        if(head == null) {
            //throw new IllegalArgumentException("head cannot be null");
            return false;
        }
        LinkedListNode<Integer> temp = head;
        while(temp != null) {
            if(temp.data == value){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
