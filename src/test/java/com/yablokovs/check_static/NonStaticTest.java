package com.yablokovs.check_static;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonStaticTest {

    @Test
    void instance() {
        NonStatic nonStatic = new NonStatic();
        NonStatic.StaticInner instance1 = nonStatic.instance(1);
        NonStatic.StaticInner instance2 = nonStatic.instance(2);
    }
}