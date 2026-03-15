package org.dsa.comparable;

import org.dsa.comparable.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableMain {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Varun", 3.9));
        students.add(new Student("Ash", 3.7));
        students.add(new Student("Vasu", 3.2));
        students.add(new Student("Mihir", 3.2));

        students.sort(null);
        System.out.println(students);
    }
}
