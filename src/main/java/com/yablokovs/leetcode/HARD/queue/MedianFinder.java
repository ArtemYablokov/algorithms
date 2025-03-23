package com.yablokovs.leetcode.HARD.queue;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> qMin;

    PriorityQueue<Integer> qMax;

    double median = 0;


    public MedianFinder() {
        qMin = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        qMax = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int minSize = qMin.size();
        int maxSize = qMax.size();

        if (num < median) {

            if(minSize == maxSize) {
                qMin.offer(num);
                median = qMin.peek();
            } else if (minSize < maxSize) {
                qMin.offer(num);
                median = getMedian();

            } else { // minSize > maxSize
                int minTop = qMin.poll();
                qMax.offer(minTop);
                qMin.offer(num);
                median = getMedian();
            }
        } else { // num > median
            if(minSize == maxSize) {
                qMax.offer(num);
                median = qMax.peek();
            } else if (maxSize < minSize) {
                qMax.offer(num);
                median = getMedian();

            } else { // maxSize > minSize
                int maxTop = qMax.poll();
                qMin.offer(maxTop);
                qMax.offer(num);
                median = getMedian();

            }

        }

    }

    private double getMedian() {
        return ((double) qMax.peek() + qMin.peek()) / 2;
    }

    public double findMedian() {
        return median;
    }
}
