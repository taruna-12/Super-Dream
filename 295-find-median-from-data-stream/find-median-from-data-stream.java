import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (small.isEmpty() || num <= small.peek()) {
            small.add(num);
        } else {
            large.add(num);
        }

        // Balance the heaps
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        }

        if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }

        if (small.size() > large.size()) {
            return small.peek();
        }

        return large.peek();
    }
}