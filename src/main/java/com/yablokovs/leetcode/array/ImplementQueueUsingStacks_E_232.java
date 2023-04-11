package com.yablokovs.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class ImplementQueueUsingStacks_E_232 {

    List<Integer> input = new ArrayList();
    List<Integer> output = new ArrayList();

    int inputPointer = -1;
    int outputPointer = -1;


    // int [] input = new int[];
    // int [] output = new int[];

    public ImplementQueueUsingStacks_E_232() {

    }

    public void push(int x) {
        input.add(++inputPointer, x);
    }

    public int pop() {
        if (outputPointer > -1) return output.get(outputPointer--);

        move();

        return output.get(outputPointer--);
    }

    public int peek() {
        if (outputPointer > -1) return output.get(outputPointer);

        move();

        return output.get(outputPointer);
    }

    public boolean empty() {
        return inputPointer == -1 && outputPointer == -1;
    }

    private void move() {

        for (int i = inputPointer, j = 0; i > -1; i--, j++) {
            output.add(j, input.get(i));
        }
        outputPointer = inputPointer;
        inputPointer = -1;

    }


}

