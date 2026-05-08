package org.dsa.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequencyElement {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(new int[]{entry.getValue(), entry.getKey()});
        }

        for(int i=0; i<k; i++) {
            int[] temp = pq.poll();
            result[i] = temp[1];
        }
        return result;
    }
}
