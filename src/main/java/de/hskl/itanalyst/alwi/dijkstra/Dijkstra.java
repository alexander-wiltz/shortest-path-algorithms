package de.hskl.itanalyst.alwi.dijkstra;

import de.hskl.itanalyst.alwi.general.GeneralEdge;
import de.hskl.itanalyst.alwi.general.GeneralGraph;
import lombok.NonNull;

import java.util.*;

public class Dijkstra {

    private final Map<Node, Node> predecessors = new HashMap<>();
    private final List<Node> shortestPath = new ArrayList<>();

    public void computeShortestPaths(@NonNull GeneralGraph<Node> graph, Node start, Node target) {
        Map<Node, Integer> distances = new HashMap<>();
        Set<Node> unvisitedNodes = new HashSet<>(graph.getAllNodes());

        for (Node node : unvisitedNodes) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(target, 0);

        while (!unvisitedNodes.isEmpty()) {
            Node currentNode = getClosestDistances(unvisitedNodes, distances);
            unvisitedNodes.remove(currentNode);

            for (GeneralEdge<Node> adjacencyList : graph.getEdgesByNode(currentNode)) {
                if (unvisitedNodes.contains(adjacencyList.getDestination())) {
                    Integer distance = distances.get(currentNode) + adjacencyList.getWeight();
                    if (distance < distances.get(adjacencyList.getDestination())) {
                        distances.put(adjacencyList.getDestination(), distance);
                        predecessors.put(adjacencyList.getDestination(), currentNode);
                    }
                }
            }
        }

        Node currentNode = start;
        if (predecessors.get(currentNode) == null) {
            return;
        }

        shortestPath.add(currentNode);
        while (predecessors.get(currentNode) != null) {
            currentNode = predecessors.get(currentNode);
            shortestPath.add(currentNode);
        }

        Collections.reverse(shortestPath);
    }

    public void showPath() {
        System.out.println(shortestPath);
    }

    private Node getClosestDistances(Set<Node> unvisitedNodes, Map<Node, Integer> distances) {
        Node currentNode = null;
        Integer closestDistance = Integer.MAX_VALUE;

        for (Node node : unvisitedNodes) {
            Integer currentDistance = distances.get(node);
            if (currentDistance < closestDistance) {
                closestDistance = currentDistance;
                currentNode = node;
            }
        }
        return currentNode;
    }
}
