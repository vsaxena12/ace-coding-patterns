package org.dsa.linkedListOld;

import static org.dsa.linkedListOld.Solution1.insertAtTail;
import static org.dsa.linkedListOld.Solution2.insertAt;
import static org.dsa.linkedListOld.Solution4.deleteByValue;

public class Driver {
    public static void main(String[] args) {
        Integer[][] input = {
//                {1, 2, 3, 4, 5},
//                {-1, -2, -3, -4, -6},
//                {3, 2, 1},
//                {},
                {1, 2},
        };

//         int[] values = {4, -5, 2, 0, -98};

        int[] values = {-98};

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(input[i]);

            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList<Integer> printLinkedList = new PrintList<Integer>();

            printLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println("\n\tNew node to be added: "+ values[i]);
            System.out.print("\n\tUpdated linked list: ");

            printLinkedList.printListWithForwardArrow(insertAtTail(inputLinkedList.head, values[i]));

            System.out.print("\n\tUpdated linked list: ");
            printLinkedList.printListWithForwardArrow(insertAt(inputLinkedList.head, 10, 2));

            boolean isDeleted = deleteByValue(inputLinkedList.head, 1);
            System.out.print("\n\tIs element deleted: "+isDeleted);
            System.out.print("\n\tUpdated linked list: ");
            printLinkedList.printListWithForwardArrow(insertAtTail(inputLinkedList.head, values[i]));
            System.out.println("\n" + new String(new char[100]).replace('\0', '-'));
        }

        System.out.println("\n" + new String(new char[100]).replace('\0', '-'));




    }
}
