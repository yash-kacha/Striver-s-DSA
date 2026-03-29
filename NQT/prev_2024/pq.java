package NQT.prev_2024;

import java.util.*;

public class pq {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        pq.add(30);
        pq.add(10);
        pq.add(20);

        // Always removes smallest
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
