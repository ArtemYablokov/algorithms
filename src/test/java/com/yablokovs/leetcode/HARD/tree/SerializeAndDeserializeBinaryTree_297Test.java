package com.yablokovs.leetcode.HARD.tree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SerializeAndDeserializeBinaryTree_297Test {

    @Test
    void test() {
        SerializeAndDeserializeBinaryTree_297 s = new SerializeAndDeserializeBinaryTree_297();

        String data1 = "5,4,7,N,N,2,N,9,N,N,N";
        String data2 = "1,N,2,3";
        String data = "1,N,2,3,N,N,N";
        TreeNode deserialize = s.deserialize(data);

        String serialize = s.serialize(deserialize);
        int n = 0;
    }

}