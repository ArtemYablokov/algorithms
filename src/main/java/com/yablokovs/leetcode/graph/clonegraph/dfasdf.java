package com.yablokovs.leetcode.graph.clonegraph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class dfasdf {

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();

        Node response = new Node(node.val);
        map.put(node.val, response);

        q.offer(node);

        while (q.size() > 0) { // 1

            Node current = q.poll();
            List<Node> childs = new ArrayList<>();

            Node currentNew = map.get(current.val);

            for (Node n : node.neighbors) {

                Node child = map.get(n.val);
                if (child == null) {
                    child = new Node(n.val);
                    q.offer(n);
                    map.put(n.val, child);
                }
                childs.add(child);
            }
            currentNew.neighbors = childs;
        }

        return response;
    }

}
