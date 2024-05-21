package de.hskl.itanalyst.alwi.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public Graph computePath(Graph graph, Node start) {
        start.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(start);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = findLowestDistance(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> neighbour : currentNode.getNeighbourNodes().entrySet()) {
                Node neighbourNode = neighbour.getKey();
                int neighbourDistance = neighbour.getValue();

                if(!settledNodes.contains(neighbourNode)) {
                    updateDistance(currentNode, neighbourNode, neighbourDistance);
                    unsettledNodes.add(neighbourNode);
                }
            }

            settledNodes.add(currentNode);
        }

        return graph;
    }

    private void updateDistance(Node source, Node evaluation, Integer distance) {
        if (source.getDistance() + distance < evaluation.getDistance()) {
            evaluation.setDistance(source.getDistance() + distance);
            LinkedList<Node> shortestPath = new LinkedList<>(source.getShortestPath());
            shortestPath.add(source);
            evaluation.setShortestPath(shortestPath);
        }
    }

    private Node findLowestDistance(Set<Node> unsettledNodes) {
        Node currentNode = null;
        int currentDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            if (node.getDistance() < currentDistance) {
                currentDistance = node.getDistance();
                currentNode = node;
            }
        }

        return currentNode;
    }
}
