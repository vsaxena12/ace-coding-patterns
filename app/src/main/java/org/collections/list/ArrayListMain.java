package org.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
    //compare, comparable, comparator, compareTo, comparing
    //Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reverse().thenComparing(Student::getName);
}

public class ArrayListMain {
    /**
     *  add(E)
     *  get(I)
     *  size()
     *  contains(E)
     *  remove(I)
     *  add(I,E) -> Add and shift
     *  set(I,E) -> Replace
     *  Capacity default is 10 (this is not same as size)
     *      Adding element -> Check capacity -> Resize if Necessary ->Add the element -> Initial Capacity
     *      -> Growth Factor (1.5) -> Copying element [O(n)]
     *      Remove -> Check bounds -> Remove the element -> Reduce size [O(n)]
     *  new ArrayList<>(1000); //Initial Capacity -> Capacity can be checked using reflection
     *  trimToSize(); //this will help to reduce the capacity to improve the memory
     *  Arrays.asList("","",""); //Cannot add or remove but can replace
     *  List.of(); //Unmodifiable at all
     *  addAll(list1);
     *  remove(Integer.valueOf(1)); //Convert primitive to object
     *  Object[] array = list.toArray();
     *  Integer[] array = list.toArray(new Integer[0]);
     *  Collection.sort(list);
     *  Comparator -> Interface
     *  o1-o2 => Ascending
     *  o2-o1 => Descending
     */
    public static void  main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(53);
        list.add(10);
        // Collections.sort(list);
        list.sort(null);
        System.out.println(list);

        System.out.println(list.get(2));

        List<String> words = Arrays.asList("banana", "apple", "date");
        words.sort(new StringLengthComparator());
        System.out.println(words);
    }
}
