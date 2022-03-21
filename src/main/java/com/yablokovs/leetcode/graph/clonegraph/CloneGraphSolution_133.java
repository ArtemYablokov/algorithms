package com.yablokovs.leetcode.graph.clonegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/clone-graph/submissions/

public class CloneGraphSolution_133 {

    public Node cloneGraph(Node node) {
        Map<Integer, Node> nodesMap = new HashMap<>();
        List<Integer> visited = new ArrayList<>();

        copyNode(node, nodesMap, visited);

        return nodesMap.get(node.val);
    }

    private void copyNode(Node from, Map<Integer, Node> nodesMap, List<Integer> visited) {
        int fromKey = from.val;
        if (visited.contains(fromKey)) {
            return;
        }
//        Node toNode = nodesMap.putIfAbsent(fromKey, new Node(fromKey));
//        Node toNode = nodesMap.get(fromKey);
//        if (toNode == null) {
//            toNode = new Node(fromKey);
//            nodesMap.put(fromKey, toNode);
//        }
        Node toNode = nodesMap.computeIfAbsent(fromKey, Node::new);

        addAllNeighbours(from, nodesMap, toNode);
        visited.add(fromKey);

        for (Node fromNeighbor : from.neighbors) {
            copyNode(fromNeighbor, nodesMap, visited);
        }
    }

    private void addAllNeighbours(Node from, Map<Integer, Node> nodesMap, Node toNode) {
        for (Node fromNeighbor : from.neighbors) {
            Node newNeighbour = nodesMap.computeIfAbsent(fromNeighbor.val, Node::new);
            toNode.neighbors.add(newNeighbour);
        }
    }

    // TODO: 11.09.2022 REDUNDANT because each not visited noted are added to other lists, but hasn't got its own
    private void addAllNeighboursWithChecking(Node from, Map<Integer, Node> nodesMap, int fromKey, List<Node> toNeighbors) {
        for (Node fromNeighbor : from.neighbors) {

            boolean neighbourNotExistsInTo = true;
            neighbourNotExistsInTo = checkIfNeighbourNotExists(toNeighbors, fromNeighbor, neighbourNotExistsInTo);

            if (neighbourNotExistsInTo) {
                Node newNeighbour = new Node(fromNeighbor.val);
                nodesMap.put(fromKey, newNeighbour);
                toNeighbors.add(newNeighbour);
            }
        }
    }

    private boolean checkIfNeighbourNotExists(List<Node> toNeighbors, Node fromNeighbor, boolean neighbourNotExistsInTo) {
        for (Node toNeighbor : toNeighbors) {
            if (toNeighbor.val == fromNeighbor.val) {
                neighbourNotExistsInTo = false;
                break;
            }
        }
        return neighbourNotExistsInTo;
    }
}

// LEETCODE DESCRIPTION :

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
