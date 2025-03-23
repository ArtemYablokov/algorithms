package com.yablokovs.leetcode.v2.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int ix = map.get(val);
        if (ix == list.size() - 1) {
            list.remove(list.size() - 1);
        } else {
            int last = list.remove(list.size() - 1);
            map.put(last, ix);
            list.add(ix, last);
        }
        map.put(val, null);

        return true;
    }

    public int getRandom() {
        int ix = new Random().nextInt(list.size());
        return list.get(ix);
    }


}
