package org.dsa.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private final Map<Integer, Integer> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return this.map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        this.map.put(key, value);
        if(map.size() > capacity) {
            Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
            it.next();
            it.remove();
        }
    }
}

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(5);
        lRUCache.put(1, 10);  // cache: {1=10}
        lRUCache.get(1);      // return 10
        lRUCache.put(2, 20);  // cache: {1=10, 2=20}
        lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
        lRUCache.put(3, 30);
        lRUCache.put(3, 30);
        lRUCache.get(2);      // returns 20
        lRUCache.get(1);      // return -1 (not found)
    }
}
