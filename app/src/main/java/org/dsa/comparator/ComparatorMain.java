package org.dsa.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "date");
        words.sort((a, b) -> b.length() - a.length()); // Descending
        System.out.println(words);

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        list.sort((o1, o2) ->
            o2 - o1 //Ascending o2 - o1 //Descending
        );
        System.out.println(list);

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Varun", 3.9));
        students.add(new Student("Ash", 3.7));
        students.add(new Student("Vasu", 3.2));
        students.add(new Student("Mihir", 3.2));

        Comparator<Student> comparator1 = Comparator.comparing(Student::getGpa)
                .reversed().thenComparing(Student::getName);
        students.sort(comparator1);

//        students.sort(null);
//        students.sort((a, b) -> {
//            if(a.getGpa() - b.getGpa() > 0) {
//                return 1;
//            } else if(b.getGpa() - a.getGpa() > 0) {
//                return -1;
//            } else {
//                return a.getName().compareTo(b.getName());
//            }
//        });

        for(Student student : students) {
            System.out.println(student.getName()+ " : "+student.getGpa());
        }

        Collections.sort(students, comparator1);
    }
}
