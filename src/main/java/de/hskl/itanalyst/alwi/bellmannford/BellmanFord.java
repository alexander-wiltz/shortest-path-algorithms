package de.hskl.itanalyst.alwi.bellmannford;

import java.util.*;

public class BellmanFord {

    public void findShortestPath(Graph graph, String start, String end) {
        Node startNode = null;
        Optional<Node> optionalStartNode = graph.getNodes().stream().filter(nd -> nd.getName().equalsIgnoreCase(start)).findFirst();
        if (optionalStartNode.isPresent()) {
            startNode = optionalStartNode.get();
        } else {
            System.out.println("Start not found! Way not computable!");
            return;
        }

        List<Node> computed = computeDistances(graph, startNode);
        Node currentNode = null;
        Optional<Node> optionalCurrentNode = computed.stream().filter(nd -> nd.getName().equalsIgnoreCase(end)).findAny();
        if (optionalCurrentNode.isPresent()) {
            currentNode = optionalCurrentNode.get();
        } else {
            System.out.println("Target not found! Way not computable!");
            return;
        }

        StringJoiner stringJoiner = new StringJoiner(" <- ");
        do {
            stringJoiner.add(currentNode.getName());
            currentNode = currentNode.getPredecessor();
        } while (currentNode != startNode);

        stringJoiner.add(startNode.getName());
        System.out.println(stringJoiner.toString());
    }

    private List<Node> computeDistances(Graph graph, Node startNode) {
        startNode.setCost(0);

        List<Node> sortedGraph = graph.getNodes().stream().sorted(Comparator.comparing(Node::getName)).toList();
        int n = sortedGraph.size() - 1;

        while (n > 0) {
            for (Node currentNode : sortedGraph) {
                for (Map.Entry<Node, Integer> edge : currentNode.getNeighbourNodes().entrySet()) {
                    int cost = currentNode.getCost() + edge.getValue();
                    if (edge.getKey().getCost() > cost) {
                        edge.getKey().setCost(cost);
                        edge.getKey().setPredecessor(currentNode);
                    }
                }
            }
            n -= 1;
        }

        return sortedGraph;
    }
}
