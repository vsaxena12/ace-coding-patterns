package org.dsa.lruCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class LRUCache {
    private final Map<Integer, Integer> map;
    private int size;
    private int capacity;

    LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        return this.map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if(this.size == this.capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = this.map.entrySet().iterator();
            if(iterator.hasNext()) {
                Map.Entry<Integer, Integer> firstEntry = iterator.next();
                iterator.remove();
                this.size--;
            }
        }
        this.map.put(key, value);
        this.size++;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,10);
        lruCache.get(1);
        lruCache.put(2,20);
        lruCache.put(3,30);
        lruCache.get(2);
        lruCache.get(1);
    }
}