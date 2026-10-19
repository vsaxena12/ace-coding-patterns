package org.collections.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Which employee comes first? Java doesn't know how to compare -> id, name etc.
 * There are two ways to tell Java
 * Comparable -> default/ natural sorting -> Interface
 * Comparator -> custom sorting
 */
public class Employee implements Comparable<Employee> {

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + " " + name + " ";
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(3, "John"));
        employees.add(new Employee(1, "Alice"));
        employees.add(new Employee(2, "Bob"));

        Collections.sort(employees);
        System.out.println(employees);

    }
}
