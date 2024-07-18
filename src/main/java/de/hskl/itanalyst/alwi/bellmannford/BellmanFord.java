package de.hskl.itanalyst.alwi.bellmannford;

import java.util.*;

public class BellmanFord {

    public void findShortestPath(Graph graph, String start, String end) {
        Node startNode;
        Node targetNode;
        Optional<Node> optionalStartNode = graph.getNodes().stream().filter(nd -> nd.getName().equals(start)).findFirst();
        Optional<Node> optionalTargetNode = graph.getNodes().stream().filter(nd -> nd.getName().equals(end)).findFirst();

        if (optionalStartNode.isPresent() && optionalTargetNode.isPresent()) {
            startNode = optionalStartNode.get();
            targetNode = optionalTargetNode.get();
        } else {
            startNode = null;
            targetNode = null;
            System.out.println("Start or Target not found! Way not computable!");
            return;
        }

        List<Node> computed = computeDistances(graph, startNode);
        for (Node node : computed) {
            System.out.println(node.getName() + " - " + node.getPredecessor() + ": " + node.getCost());
        }

        Node currentNode = computed.stream().filter(nd -> nd.getName().equals(targetNode.getName())).findAny().get();
        Map<Node, Integer> shortestPath = new HashMap<>();

        do {
            Integer weight = currentNode.getNeighbourNodes().get(currentNode.getPredecessor());
            shortestPath.put(currentNode, weight);
            currentNode = currentNode.getPredecessor();
        } while (currentNode != startNode);

        shortestPath.put(startNode, 0);

        StringJoiner stringJoiner = new StringJoiner(" -> ");
        for (Map.Entry<Node, Integer> entry : shortestPath.entrySet()) {
            stringJoiner.add(entry.getKey().getName() + "(" + entry.getValue() + ")");
        }

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
