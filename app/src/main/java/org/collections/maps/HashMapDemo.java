package org.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Var");
        map.put(2, "Ash");
        map.put(3, "Jon");

        System.out.println(map);
//        String student = map.get(2);
//        System.out.println(student);

        String student = map.get(22);
        System.out.println(student);

        System.out.println("Contains Key: " +map.containsKey(2));
        System.out.println("Contains Value: "+map.containsValue("Ashley"));

        


    }
}
