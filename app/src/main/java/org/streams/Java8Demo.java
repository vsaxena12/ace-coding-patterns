package org.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Java8Demo {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Ram");
        Employee e2 = new Employee(2, "Shyam");
        Employee e3 = new Employee(1, "Ram");

        Map<Integer, String> map = new HashMap<>();
        map.put(e1.getId(), "Emp1");
        map.put(e2.getId(), "Emp2");
        map.put(e3.getId(), "Emp3");

        if(e1.hashCode() == e3.hashCode()) {
           System.out.println("e1.hashCode() == e3.hashCode()");
        }

        if(e1.equals(e3)) {
            System.out.println("e1.equals(e3)");
        }

        System.out.println(map.size());
        System.out.println(map);

    }
}


class Employee {
    private int id;
    private String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}