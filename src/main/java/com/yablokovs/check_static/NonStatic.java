package com.yablokovs.check_static;

import java.util.ArrayList;
import java.util.List;

public class NonStatic {

    public static int number = 0;
    public static class StaticInner {
        List<Integer> list = new ArrayList<>();
    }

    public StaticInner instance(int num) {
        StaticInner staticInner = new StaticInner();
        number = num;

        staticInner.list.add(num);
//        staticInner.list.add(0);
        return staticInner;
    }
}
