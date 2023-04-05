package com.yablokovs.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class BestTimeToBuyandSellStockIV_188 {

    public static void main(String[] args) {
        PriorityQueue<PriceDiapason> queue = new PriorityQueue<>();
        queue.add(new PriceDiapason(0, 1));
        queue.add(new PriceDiapason(0, 0));
        queue.add(new PriceDiapason(0, 2));
        PriceDiapason poll = queue.poll();
        PriceDiapason poll2 = queue.poll();
        PriceDiapason poll3 = queue.poll();
    }
}


class Holder {


    List<String> list = new LinkedList<>();

    public void test(String[] args) {
        int size = list.size();

        PriorityQueue<PriceDiapason> queue = new PriorityQueue<>();


    }
}

class PriceDiapason implements Comparable<PriceDiapason> {

    public int price;
    public int start;
    public int end;

    public PriceDiapason(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(PriceDiapason o) {
        if (o == null) {
            return 1;
        }
        return Integer.compare(end - start, o.end - o.start);
    }
}

