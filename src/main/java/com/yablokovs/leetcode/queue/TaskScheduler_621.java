package com.yablokovs.leetcode.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counter = new HashMap<>();

        for (char task : tasks) {
            counter.compute(task, (k, v) -> v == null ? 1 : v + 1);
        }

        Queue<Tuple> q = new LinkedList<>();
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.counter, a.counter));

        for (Map.Entry<Character, Integer> e : counter.entrySet()) {
            priorityQueue.add(new Tuple(e.getValue(), e.getKey()));
        }

        int result = 0;
        List<Character> resultList = new ArrayList<>();
        Tuple idle = new Tuple(0, '!');

        while (!priorityQueue.isEmpty() || !q.isEmpty()) {
            Tuple current;
            if (priorityQueue.isEmpty()) {
                current = q.poll();
                if (current == idle) {
                    result++;
                    resultList.add(current.character);
                    continue;
                }
                result++;
                resultList.add(current.character);
                current.counter = current.counter - 1;
                if (current.counter == 0)
                    continue;

                addToQ(n, q, idle, current);
                continue;

            }
            if (!q.isEmpty()) {
                current = q.poll();
                if (current != idle) {
                    priorityQueue.offer(current);
                }
            }
            current = priorityQueue.poll();
            current.counter = current.counter - 1;
            result++;
            resultList.add(current.character);
            if (current.counter > 0)
                addToQ(n, q, idle, current);
        }
        return result;
    }

    private void addToQ(int n, Queue<Tuple> q, Tuple idle, Tuple current) {
        int size = q.size();
        if (size < n) {
            for (int i = 0; i < n - size; i++) {
                q.offer(idle);
            }
        }
        q.offer(current);
    }

    class Tuple {
        public Tuple(Integer counter, Character character) {
            this.counter = counter;
            this.character = character;
        }
        Integer counter;
        Character character;
    }

}
