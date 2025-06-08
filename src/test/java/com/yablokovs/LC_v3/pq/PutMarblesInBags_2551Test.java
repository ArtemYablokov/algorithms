package com.yablokovs.LC_v3.pq;

import org.junit.jupiter.api.Test;

import static com.yablokovs.LC_v3.util.Util.build;

class PutMarblesInBags_2551Test {

    @Test
    void putMarbles() {
        PutMarblesInBags_2551 s = new PutMarblesInBags_2551();
        long l = s.putMarbles(build(4, 3, 2, 1), 3);
        long l2 = s.putMarbles(build(1, 3, 5, 1), 2);
    }
}