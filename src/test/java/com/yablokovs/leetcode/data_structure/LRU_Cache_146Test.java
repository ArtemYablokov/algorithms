package com.yablokovs.leetcode.data_structure;

import org.junit.jupiter.api.Test;

class LRU_Cache_146Test {

    @Test
    void get() {

//        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(2, 0.75f, true);
//        linkedHashMap.put(0, 1);
//        linkedHashMap.put(4, 2);
//        linkedHashMap.put(7, 3);
//        linkedHashMap.get(4);
//        Set<Integer> keys2 = linkedHashMap.keySet();
//        keys2.forEach(System.out::println);


//        LRU_146 lru146 = new LRU_146(2);
//        lru146.put(1,0);
//        lru146.put(2,2);
//        int i1 = lru146.get(1);
//
//        lru146.put(3,3);
//        int i2 = lru146.get(2);
//
//        lru146.put(4,4);
//
//        int i3 = lru146.get(1);
//        int i4 = lru146.get(3);
//        int i5 = lru146.get(4);

        LRU_Cache_146 lru146 = new LRU_Cache_146(3);
        lru146.put(1,1);
        lru146.put(2,2);
        lru146.put(3,3);
        lru146.put(4,4);

        int i5 = lru146.get(4);
        int i4 = lru146.get(3);
        int i3 = lru146.get(2);
        int i1 = lru146.get(1);

        lru146.put(5,5);
        int i2 = lru146.get(2);

        lru146.put(4,4);






        int i = 0;
    }
}