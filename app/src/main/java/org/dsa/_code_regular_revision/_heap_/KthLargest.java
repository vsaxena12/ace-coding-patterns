package org.dsa._code_regular_revision._heap_;

import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> queue;
    private int K;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        for(int n: nums) {
            queue.add(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        this.K = k;
    }

    public int add(int val) {
        //queue.poll();
        queue.offer(val);
        if(queue.size() > K) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3,new int[]{4,5,8,2});

        System.out.println(kthLargest.queue.peek());
        kthLargest.add(6);
        System.out.println(kthLargest.queue.peek());
//        kthLargest.add(5);
//        System.out.println(kthLargest.queue.peek());
//        kthLargest.add(6);
//        System.out.println(kthLargest.queue.peek());
//        kthLargest.add(7);
//        System.out.println(kthLargest.queue.peek());
//        kthLargest.add(8);
//        System.out.println(kthLargest.queue.peek());


    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */