package com.yablokovs.leetcode.data_structure;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache_146 {
    Map<Integer, Wrapper> map = new HashMap<>();

    int capacity;
    int size;
    Wrapper head;
    Wrapper tail;

    public LRU_Cache_146(int capacity) {
        this.capacity = capacity;

    }

    public void moveToHead(Wrapper w) {
        if (w == head) {
            return;
        }
        if (w == tail) {
            tail = w.previous;
            tail.next = null;

            w.next = head;
            head.previous = w;

            w.previous = null;
            head = w;
            return;
        }
        Wrapper previous = w.previous;
        Wrapper next = w.next;

        previous.next = next;
        next.previous = previous;

        w.previous = null;
        w.next = head;
        head.previous = w;
        head = w;
    }

    public void addNew(Wrapper w) {
        if (size == 0) {
            head = w;
            tail = w;
            size++;
            return;
        }
        head.previous = w;
        w.next = head;

        head = w;
        size++;
        if (size > capacity) {
            map.remove(tail.key);
            size--;
            tail = tail.previous;
            tail.next = null;
        }
    }


    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Wrapper wrapper = map.get(key);
        moveToHead(wrapper);
        return wrapper.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Wrapper newWrapper = new Wrapper(key, value);
            map.put(key, newWrapper);
            addNew(newWrapper);
        } else {
            Wrapper wrapper = map.get(key);
            wrapper.value = value;
            moveToHead(wrapper);
        }
    }

    class Wrapper {
        int value;
        int key;

        Wrapper next;
        Wrapper previous;

        public Wrapper(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
