package com.yablokovs.laakman;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lombok.RequiredArgsConstructor;

public class BFSRecursiveAndIterative {

    public static void main(String[] args) {

        Node graph = new Node(0);

        Queue<Node> queue = new LinkedList<>();
        queue.add(graph);

        // TODO: 15.04.2022 ITERATIVE APPROACH
        while (!queue.isEmpty()) {
            Node element = queue.poll();
            System.out.println(element.value); // processed NODE of a Graph
            queue.addAll(element.nodes);

        }


        // TODO: 15.04.2022 RECURSIVE APPROACH
        BFS(graph, queue);

    }


    private static void BFS(Node graph, Queue<Node> queue) {
        System.out.println(graph.value);
        queue.addAll(graph.nodes);
        BFS(queue.poll(), queue);
    }
}


@RequiredArgsConstructor
class Node {

    final int value;

    List<Node> nodes;
}
